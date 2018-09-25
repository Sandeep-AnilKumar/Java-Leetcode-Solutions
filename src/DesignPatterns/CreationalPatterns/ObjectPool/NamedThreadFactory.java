package DesignPatterns.CreationalPatterns.ObjectPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class NamedThreadFactory implements ThreadFactory {
  private final AtomicInteger counter;
  private final String prefix;
  private final String format;
  
  public NamedThreadFactory(String format, String prefix) {
    this.format = format;
    this.prefix = prefix;
    this.counter = new AtomicInteger(1);
  }
  
  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r, String.format(format, prefix, counter.getAndIncrement()));
  }
}
