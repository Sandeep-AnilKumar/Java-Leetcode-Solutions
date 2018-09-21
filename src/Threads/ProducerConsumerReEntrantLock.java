package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerReEntrantLock {
  private Lock lock;
  private Condition notEmpty, notFull;
  private int[] buffer;
  private int count;

  public ProducerConsumerReEntrantLock(int bufferSize) {
    lock = new ReentrantLock();
    //lock = new ReentrantLock(true);
    notEmpty = lock.newCondition();
    notFull = lock.newCondition();
    buffer = new int[bufferSize];
    count = 0;
  }

  class Producer implements Runnable {
    @Override
    public void run() {
      int i = 1, index = 0;
      while (!Thread.currentThread().isInterrupted()) {
        try {
          lock.lock();
          if (count == buffer.length) notFull.await();

          if (index == buffer.length) index = 0;

          buffer[index++] = i;
          System.out.println("Produced " + i++);
          count++;
          notEmpty.signal();
          Thread.sleep(1000);

        } catch (InterruptedException ie) {
          System.out.println("Producer is interrupted");
          Thread.currentThread().interrupt();
        } finally {
          lock.unlock();
//          try {
//            Thread.sleep(1000);
//          } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//          }
        }
      }
      System.out.println("Producer is done");
    }

  }

  class Consumer implements Runnable {
    @Override
    public void run() {
      int index = 0;
      while (!Thread.currentThread().isInterrupted()) {
        try {
          lock.lock();
          if (count == 0) notEmpty.await();
          if (index == buffer.length) index = 0;
          System.out.println("Consumed " + buffer[index++]);
          count--;
          notFull.signal();
          Thread.sleep(1000);

        } catch (InterruptedException ie) {
          System.out.println("Consumer is interrupted");
          Thread.currentThread().interrupt();
        } finally {
          lock.unlock();
//          try {
//            Thread.sleep(1000);
//          } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//          }
        }
      }
      System.out.println("Consumer is done");
    }
  }


  public static void main(String[] args) {

    // A bounded buffer implementation, to produce until buffer is not full, to consume until buffer is not empty. 
    // To make it "do not produce until consumed", make the bufferSize = 1, or make the lock fair, 
    // or add sleep after releasing the lock

    ProducerConsumerReEntrantLock producerConsumer = new ProducerConsumerReEntrantLock(5);
    ExecutorService producerExecutorService = Executors.newSingleThreadExecutor();
    ExecutorService consumerExecutorService = Executors.newSingleThreadExecutor();
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    Future<?> producerHandle = producerExecutorService.submit(producerConsumer.new Producer());
    Future<?> consumerHandle = consumerExecutorService.submit(producerConsumer.new Consumer());

    scheduledExecutorService.schedule(() -> {

      producerHandle.cancel(true);
      producerExecutorService.shutdownNow();

      consumerHandle.cancel(true);
      consumerExecutorService.shutdownNow();

      try {
        producerExecutorService.awaitTermination(5, TimeUnit.SECONDS);
        consumerExecutorService.awaitTermination(5, TimeUnit.SECONDS);
      } catch (InterruptedException ie) {
        System.out.println("Interrupted : " + ie);
      }
    }, 10, TimeUnit.SECONDS);

    try {
      Thread.sleep(15 * 1000);
    } catch (InterruptedException ie) {
      System.out.println("Main thread interrupted");
    } finally {
      System.out.println("Producer Consumer exit");
      scheduledExecutorService.shutdownNow();
    }
  }
}