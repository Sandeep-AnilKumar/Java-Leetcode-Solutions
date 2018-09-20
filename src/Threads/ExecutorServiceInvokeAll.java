package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceInvokeAll {
  public static void main(String[] args) {
    List<Task<Integer>> tasks = new ArrayList<>();
    for (int i = 0; i < 5; ++i) {
      tasks.add(new Task<>(i));
    }

    //A thread pool of 5 threads to run all tasks concurrently.
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    try {
      /* Invokes all and waits for 4 seconds.
       * The List will contain future of all the tasks, and will be done. Note they might not have completed,
       * uncompleted ones will be cancelled. Invoking get on cancelled leads to exception.
       * If timeout is not given all the tasks will be completed. In other words it will be a blocking call.*/

      List<Future<Integer>> futures = executorService.invokeAll(tasks, 4, TimeUnit.SECONDS);
      for (Future<Integer> future : futures) {
        System.out.println(future.isDone());
        if (!future.isCancelled()) {
          System.out.println("Thread " + future.get() + " returned ");
        }
      }
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Interrupted " + e);
    } finally {
      System.out.println("Is executor service shutdown? := " + executorService.isShutdown());
      if (!executorService.isShutdown()) {
        executorService.shutdownNow();
      }
    }
  }
}

class Task<V> implements Callable<V> {

  private V index;

  public Task(V index) {
    this.index = index;
  }

  @Override
  public V call() throws Exception {
    System.out.println("Executing thread " + index);
    Thread.sleep((Integer) index * 1000);
    System.out.println("Exiting thread " + index);
    return index;
  }
}