package DesignPatterns.CreationalPatterns.AbstractFactoryPattern;

import DesignPatterns.CreationalPatterns.FactoryPattern.ABurger;

public abstract class MealFactory {
  public abstract ABurger createBurger(String burgerType, Double price) throws Exception;
  public abstract ADrink createDrink(String drinkType, Double price) throws Exception;
}
