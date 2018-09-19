package DesignPatterns.CreationalPatterns.FactoryPattern;

public class CheeseBurger extends ABurger {
  public CheeseBurger(String name, Double price) {
    setName(name);
    setPrice(price);
    cheese = new WithCheese();
    meat = new WithMeat();
    veggies = new WithNoVeggies();
  }
}
