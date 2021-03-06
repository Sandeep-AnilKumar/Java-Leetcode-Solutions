package DesignPatterns.CreationalPatterns.Factory;

public class WithNoVeggies extends AVeggies {
  public WithNoVeggies() {
    setHasVeggies(false);
  }

  @Override
  public void print() {
    System.out.println("With no veggies");
  }
}
