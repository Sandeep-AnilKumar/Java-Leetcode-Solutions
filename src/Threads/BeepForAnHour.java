package Threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class BeepForAnHour {
  public static void main(String[] args) {
    ScheduledExecutorService beepExecutorService = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<?> handler = beepExecutorService.scheduleAtFixedRate(() -> System.out.println("Beep"), 5, 5, TimeUnit.SECONDS);
    ScheduledExecutorService killExecutorService = Executors.newSingleThreadScheduledExecutor();
    killExecutorService.schedule(() -> handler.cancel(true), 1, TimeUnit.HOURS);
    try {
      System.out.println("Main thread sleeping for 1 hour");
      Thread.sleep(60 * 60 * 1000);
    } catch (InterruptedException ie) {
      System.out.println("Interrupted := " + ie);
    } finally {
      System.out.println("Killing all threads");
      beepExecutorService.shutdownNow();
      killExecutorService.shutdownNow();
    }
  }
}
