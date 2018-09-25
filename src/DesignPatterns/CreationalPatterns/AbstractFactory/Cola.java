package DesignPatterns.CreationalPatterns.AbstractFactory;

public class Cola extends ADrink {
  
  public Cola(String name, Double price) {
    setName(name);
    setPrice(price);
    print();
  }
  
  @Override
  public void print() {
    System.out.println("Adding : " + getName() + " with a price of : " + getPrice());
  }
}
