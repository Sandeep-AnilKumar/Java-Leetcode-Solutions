package DesignPatterns.CreationalPatterns.Factory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFactory {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    try {
      System.out.println("Enter the Burger type ('c', 'h', 'v') along with its price");
      ABurger burger = BurgerFactory.getInstance().createBurger(input.nextLine().trim().toLowerCase(), input.nextDouble());
    } catch (InputMismatchException ime) {
      System.out.println("Exception: Please enter a Uppercase character from ('c', 'h', 'v') and then a Number");
    } catch (Exception e) {
      System.out.println("Exception: Wrong Input: " + e);
    }
  }
}