package DesignPatterns.CreationalPatterns.AbstractFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainAbstractPattern {
  private static Map<String, Double> burgerPrices = new HashMap<String, Double>() {{
    put("c", 6d);
    put("h", 7d);
    put("v", 4d);
  }};

  private static Map<String, Double> drinkPrices = new HashMap<String, Double>() {{
    put("c", 2d);
    put("w", 1d);
    put("j", 3d);
  }};
  
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the meal type");
    System.out.println("'b' for Burger");
    System.out.println("'d' for Drink");
    System.out.println("'c' for Combo");
    
    String mealType = input.next().trim().toLowerCase();
    
    try {
      switch (mealType) {
        case "b" : createBurger(input, mealType); break;
        case "d" : createDrink(input, mealType); break;
        case "c" : createBurger(input, "b"); createDrink(input, "d"); break;
      }
    } catch (Exception e) {
      System.out.println("Exception occurred : " + e);
    }
  }
  
  private static void createBurger(Scanner input, String mealType) throws Exception {
    System.out.println("Enter the type of burger");
    System.out.println("'c' for Cheeseburger");
    System.out.println("'h' for Hamburger");
    System.out.println("'v' for Veggie Burger");
    String burgerType = input.next().trim().toLowerCase();
    MealProducer.getFactory(mealType).createBurger(burgerType, burgerPrices.get(burgerType));
  }

  private static void createDrink(Scanner input, String mealType) throws Exception {
    System.out.println("Enter the type of drink");
    System.out.println("'c' for Cola");
    System.out.println("'w' for Water");
    System.out.println("'j' for Juice");
    String drinkType = input.next().trim().toLowerCase();
    MealProducer.getFactory(mealType).createDrink(drinkType, drinkPrices.get(drinkType));
  }
}
