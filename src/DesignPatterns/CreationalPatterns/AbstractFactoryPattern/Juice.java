package DesignPatterns.CreationalPatterns.AbstractFactoryPattern;

public class Juice extends ADrink {

  public Juice(String name, Double price) {
    setName(name);
    setPrice(price);
    print();
  }

  @Override
  public void print() {
    System.out.println("Adding : " + getName() + " with a price of : " + getPrice());
  }
}
