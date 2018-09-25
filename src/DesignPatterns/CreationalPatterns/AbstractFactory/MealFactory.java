package DesignPatterns.CreationalPatterns.AbstractFactory;

import DesignPatterns.CreationalPatterns.Factory.ABurger;

public abstract class MealFactory {
  public abstract ABurger createBurger(String burgerType, Double price) throws Exception;
  public abstract ADrink createDrink(String drinkType, Double price) throws Exception;
}
