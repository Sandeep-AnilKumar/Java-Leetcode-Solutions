package DesignPatterns.CreationalPatterns.Factory;

public class WithCheese extends ACheese {
  public WithCheese() {
    setHasCheese(true);
  }
  
  @Override
  public void print() {
    System.out.println("With Cheese");
  }
}
