package DesignPatterns.CreationalPatterns.ObjectPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainObjectPool {
  public static void main(String[] args) {


    JDBCConnectionPool jdbcConnectionPool = JDBCConnectionPool.getPool()
            .withMaxConnections(1)
            .withMaxKeepAlive(30000)
            .withDs("jdbc:mysql://localhost:3306/")
            .withUsername("someUsername")
            .withPassword("somePassword")
            .build();

    int numThreads = 3;
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads, new NamedThreadFactory("%s-%d", "JDBCConn"));

    for(int i = 1; i <= numThreads; ++i) {
      final int num = i;
      executorService.submit(() -> {
        String name = Thread.currentThread().getName();
        try {
          
          if (num == 2) Thread.sleep(35000);
          System.out.println(name + " is trying to acquire connection ");
          Connection connection = jdbcConnectionPool.getConnection(name);
          System.out.println(name + " acquired connection ");
          
          Thread.sleep(1000);
          
          System.out.println(name + " is " + connection.prepareStatement());
          System.out.println(name + " is " + connection.execute());
          
          Thread.sleep(1000);
          
          System.out.println(name + " is releasing connection");
          
          Thread.sleep(1000);

          if (num == 3) connection.close();
          
          jdbcConnectionPool.releaseConnection(connection, name);
          
        } catch (InterruptedException e) {
          System.out.println(name + " interrupted");
          Thread.currentThread().interrupt();
        }
        
        System.out.println(name + " is done");
      });
    }

    ScheduledExecutorService killer = Executors.newSingleThreadScheduledExecutor();
    killer.schedule(executorService::shutdownNow, 45, TimeUnit.SECONDS);

    try {
      Thread.sleep(50 * 1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    
    killer.shutdownNow();
  }
}
