package DesignPatterns.CreationalPatterns.AbstractFactory;

import DesignPatterns.CreationalPatterns.Factory.ABurger;

public class DrinkFactory extends MealFactory {
  private static DrinkFactory instance;

  private DrinkFactory () { }

  public static DrinkFactory getInstance() {
    if (instance == null) {
      synchronized (DrinkFactory.class) {
        if (instance == null) {
          instance = new DrinkFactory();
        }
      }
    }
    return instance;
  }
  
  public ADrink createDrink(String drinkType, Double price) throws Exception {
    ADrink drink;
    switch (drinkType) {
      case "c": drink = new Cola("Cola", price); break;
      case "w": drink = new Cola("Water", price); break;
      case "j": drink = new Cola("Juice", price); break;
      default: throw new Exception("Invalid drink type");
    }
    return drink;
  }

  @Override
  public ABurger createBurger(String burgeType, Double price) throws Exception {
    throw new Exception("Cannot create burger from DrinkFactory");
  }
}
