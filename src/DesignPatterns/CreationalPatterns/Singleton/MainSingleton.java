package DesignPatterns.CreationalPatterns.Singleton;

public class MainSingleton {
  public  static void main(String[] args) {
    Singleton singleton1 = Singleton.getInstance();
    System.out.println(System.identityHashCode(singleton1));
    
    Singleton singleton2 = Singleton.getInstance();
    System.out.println(System.identityHashCode(singleton2));
    
    System.out.println("Are two instances equal := " + singleton1.equals(singleton2));
  }
}
