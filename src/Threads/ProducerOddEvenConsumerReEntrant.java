package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerOddEvenConsumerReEntrant {

  private Lock lock = new ReentrantLock();
  private Condition produce = lock.newCondition();
  private Condition even = lock.newCondition();
  private Condition odd = lock.newCondition();
  private Integer value;

  class OddConsumer implements Runnable {

    @Override
    public void run() {
      while (!Thread.currentThread().isInterrupted()) {
        lock.lock();
        try {
          odd.await();
          System.out.println("Odd consumer consumed : " + value);
          value = null;
          produce.signal();
          
          Thread.sleep(1000);
          
        } catch (InterruptedException e) {
          System.out.println("Odd Consumer interrupted");
          Thread.currentThread().interrupt();
        } finally {
          lock.unlock();
        }
      }
      System.out.println("Odd Consumer done");
    }
  }

  class EvenConsumer implements Runnable {

    @Override
    public void run() {
      while (!Thread.currentThread().isInterrupted()) {
        lock.lock();
        try {
          if (value == null) even.await();
          System.out.println("Even consumer consumed : " + value);
          value = null;
          produce.signal();
          
          Thread.sleep(1000);
          
        } catch (InterruptedException e) {
          System.out.println("Even Consumer interrupted");
          Thread.currentThread().interrupt();
        } finally {
          lock.unlock();
        }
      }
      System.out.println("Even Consumer done");
    }
  }

  class Producer implements Runnable {

    @Override
    public void run() {
      int i = 0;
      while (!Thread.currentThread().isInterrupted()) {
        lock.lock();
        try {
          if (value != null) {
            produce.await();
          }

          value = i;
          System.out.println("Producer produced : " + i);

          if (i % 2 == 0) {
            even.signal();
          } else {
            odd.signal();
          }

          Thread.sleep(1000);
        } catch(InterruptedException e) {
          System.out.println("Producer interrupted");
          Thread.currentThread().interrupt();
        } finally{
          lock.unlock();
        }
        i++;
      }
      System.out.println("Producer done");
    }
  }

  public static void main(String[] args) {
    ProducerOddEvenConsumerReEntrant producerOddEvenConsumer = new ProducerOddEvenConsumerReEntrant();
    System.out.println("Producer Odd Even Consumer with ReEntrant lock started");

    ExecutorService producerExecutorService = Executors.newSingleThreadExecutor();
    Future<?> producerHandle = producerExecutorService.submit(producerOddEvenConsumer.new Producer());

    ExecutorService oddConsumerExecutorService = Executors.newSingleThreadExecutor();
    Future<?> oddConsumerHandle = oddConsumerExecutorService.submit(producerOddEvenConsumer.new OddConsumer());
    
    ExecutorService evenConsumerExecutorService = Executors.newSingleThreadExecutor();
    Future<?> evenConsumerHandle = evenConsumerExecutorService.submit(producerOddEvenConsumer.new EvenConsumer());

    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<?> killer = scheduledExecutorService.schedule(() -> {
      producerHandle.cancel(true);
      oddConsumerHandle.cancel(true);
      evenConsumerHandle.cancel(true);

      producerExecutorService.shutdownNow();
      oddConsumerExecutorService.shutdownNow();
      evenConsumerExecutorService.shutdownNow();

      try {
        producerExecutorService.awaitTermination(5, TimeUnit.SECONDS);
        oddConsumerExecutorService.awaitTermination(5, TimeUnit.SECONDS);
        evenConsumerExecutorService.awaitTermination(5, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

    }, 10, TimeUnit.SECONDS);

    try {
      Thread.sleep(25 * 1000);
    } catch (InterruptedException ie) { }

    scheduledExecutorService.shutdownNow();
    System.out.println("Producer consumer end");
    System.out.println(scheduledExecutorService.isShutdown());
  }
}
