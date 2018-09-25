package DesignPatterns.CreationalPatterns.Factory;

public class WithVeggies extends AVeggies {
  public WithVeggies() {
    setHasVeggies(true);
  }

  @Override
  public void print() {
    System.out.println("With veggies");
  }
}
