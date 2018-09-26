package DesignPatterns.CreationalPatterns.Singleton;

public class Singleton {
  
  private Singleton() { }
  
  private static class SingletonHolder {
    private static final Singleton singleton = new Singleton();
  }
  
  public static Singleton getInstance() {
    return SingletonHolder.singleton;
  }
}
