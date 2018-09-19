package DesignPatterns.CreationalPatterns.FactoryPattern;

public class VeggieBurger extends ABurger {
  public VeggieBurger(String name, Double price) {
    setName(name);
    setPrice(price);
    cheese = new WithCheese();
    meat = new WithNoMeat();
    veggies = new WithVeggies();
  }
}
