package DesignPatterns.CreationalPatterns.AbstractFactoryPattern;

import DesignPatterns.CreationalPatterns.FactoryPattern.BurgerFactory;

public class MealProducer {
  public static MealFactory getFactory(String mealItem) throws Exception {
    MealFactory mealFactory;
    switch (mealItem) {
      case "b" : mealFactory = BurgerFactory.getInstance(); break;
      case "d" : mealFactory = DrinkFactory.getInstance(); break;
      default: throw new Exception("Invalid meal item type");
    }
    return mealFactory;
  } 
}
