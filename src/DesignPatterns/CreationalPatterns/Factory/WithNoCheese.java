package DesignPatterns.CreationalPatterns.Factory;

public class WithNoCheese extends ACheese {

  public WithNoCheese() {
    setHasCheese(false);
  }

  @Override
  public void print() {
    System.out.println("With no cheese");
  }
}
