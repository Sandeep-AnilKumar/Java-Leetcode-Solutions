package DesignPatterns.CreationalPatterns.FactoryPattern;

public class WithNoCheese extends ACheese {

  public WithNoCheese() {
    setHasCheese(false);
  }

  @Override
  public void print() {
    System.out.println("With no cheese");
  }
}
