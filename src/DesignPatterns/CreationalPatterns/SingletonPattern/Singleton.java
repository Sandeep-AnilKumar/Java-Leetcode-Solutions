package DesignPatterns.CreationalPatterns.SingletonPattern;

public class Singleton {
  
  private static Singleton singleton;
  
  private Singleton() { }
  
  public static Singleton getInstance() {
    if (singleton == null) {
      System.out.println("Acquiring the instance for the first time");
      synchronized (Singleton.class) {
        if (singleton == null) {
          singleton = new Singleton();
          System.out.println("Instance created");
        }
      }
    }
    return singleton;
  }
}
