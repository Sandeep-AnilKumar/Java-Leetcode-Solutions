package DesignPatterns.CreationalPatterns.ObjectPool;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ConnectionPool<T> {

  private Map<T, Long> available, leased;
  private int maxConnections;
  private long maxKeepAlive;
  private Lock lock = new ReentrantLock();
  private Condition instanceRelease = lock.newCondition();

  protected ConnectionPool(int maxConnections, long maxKeepAlive) {
    this.maxConnections = maxConnections;
    this.maxKeepAlive = maxKeepAlive;
    available = new ConcurrentHashMap<>(maxConnections);
    leased = new ConcurrentHashMap<>(maxConnections);
  }

  protected abstract T create();

  public abstract boolean validate(T t);

  protected abstract void expire(T t);

  public T getConnection(String name) {
    T t = null;
    Long now = System.currentTimeMillis();

    lock.lock();

    try {

      if (leased.size() == maxConnections) {
        System.out.println(name + " is waiting for instances to be released");
        instanceRelease.await();
      }

      if (available.size() > 0) {
        
        for (Map.Entry<T, Long> entry : available.entrySet()) {
          T connection = entry.getKey();
          Long lastAccess = entry.getValue();
          
          if (now - lastAccess > maxKeepAlive) {
            System.out.println("Connection has expired");
            expire(connection);
            available.remove(connection);
            
          } else {
            
            if (validate(connection)) {
              System.out.println("Connection is valid and can be re-used");
              available.remove(connection);
              leased.put(connection, now);
              return connection;
              
            } else {
              System.out.println("Connection is invalid");
              expire(connection);
              available.remove(connection);
            }
          }
        }
      }

      System.out.println("Creating new connection for " + name);
      t = create();
      leased.put(t, now);

    } catch (Exception e) {
      System.out.println(name + " couldn't get or create instance");
      e.printStackTrace();
    } finally {
      lock.unlock();
    }

    return t;
  }

  public void releaseConnection(T t, String name) {
    lock.lock();

    try {
      available.put(t, System.currentTimeMillis());
      leased.remove(t);
      System.out.println(name + " is signalling release of instance");
      instanceRelease.signal();
    } catch (Exception e) {
      System.out.println(name + " couldn't release connection");
    } finally {
      lock.unlock();
    }
  }
}
