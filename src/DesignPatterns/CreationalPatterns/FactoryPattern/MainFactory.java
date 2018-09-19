package DesignPatterns.CreationalPatterns.FactoryPattern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFactory {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    try {
      ABurger burger = BurgerFactory.getInstance().create(input.nextLine(), input.nextDouble());
    } catch (InputMismatchException ime) {
      System.out.println("Exception: Please enter a Uppercase character from ('C', 'H', 'V') and then a Number");
    } catch (Exception e) {
      System.out.println("Exception: Wrong Input: " + e);
    }
  }
}