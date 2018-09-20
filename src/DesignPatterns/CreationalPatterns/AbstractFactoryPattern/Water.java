package DesignPatterns.CreationalPatterns.AbstractFactoryPattern;

public class Water extends ADrink {

  public Water(String name, Double price) {
    setName(name);
    setPrice(price);
    print();
  }

  @Override
  public void print() {
    System.out.println("Adding : " + getName() + " with a price of : " + getPrice());
  }
}