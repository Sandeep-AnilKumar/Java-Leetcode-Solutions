package DesignPatterns.CreationalPatterns.FactoryPattern;

import DesignPatterns.CreationalPatterns.AbstractFactoryPattern.ADrink;
import DesignPatterns.CreationalPatterns.AbstractFactoryPattern.MealFactory;

public class BurgerFactory extends MealFactory {
  private static BurgerFactory instance;
  
  private BurgerFactory () { }
  
  public static BurgerFactory getInstance() {
    if (instance == null) {
      synchronized (BurgerFactory.class) {
        if (instance == null) {
          instance = new BurgerFactory();
        }
      }
    }
    return instance;
  }

  public ABurger createBurger(String burgerType, Double price) throws Exception {
    ABurger burger;
    switch(burgerType) {
      case "c" : burger = new CheeseBurger("CheeseBurger", price); break;
      case "h" : burger = new HamBurger("Hamburger", price); break;
      case "v" : burger = new VeggieBurger("VeggieBurger", price); break;
      default: throw new Exception("Incorrect Burger Type");
    }
    burger.onCreate();
    return burger;
  }

  @Override
  public ADrink createDrink(String drinkType, Double price) throws Exception {
    throw new Exception("Cannot create drink from BurgerFactory");
  }
}
