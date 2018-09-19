package DesignPatterns.CreationalPatterns.FactoryPattern;

public class HamBurger extends ABurger {
  public HamBurger(String name, Double price) {
    setName(name);
    setPrice(price);
    cheese = new WithNoCheese();
    meat = new WithMeat();
    veggies = new WithNoVeggies();
  }
}
