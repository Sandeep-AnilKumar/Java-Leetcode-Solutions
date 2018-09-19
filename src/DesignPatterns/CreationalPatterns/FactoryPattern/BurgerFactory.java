package DesignPatterns.CreationalPatterns.FactoryPattern;

public class BurgerFactory {
  private static BurgerFactory instance;
  
  private BurgerFactory () { }
  
  public static BurgerFactory getInstance() {
    if (instance == null) {
      instance = new BurgerFactory();
    }
    return instance;
  }

  public ABurger create(String burgerType, Double price) throws Exception {
    ABurger burger;
    switch(burgerType) {
      case "C" : burger = new CheeseBurger("CheeseBurger", price); break;
      case "H" : burger = new HamBurger("Hamburger", price); break;
      case "V" : burger = new VeggieBurger("VeggieBurger", price); break;
      default: throw new Exception("Incorrect Burger Type");
    }
    burger.onCreate();
    return burger;
  }
}
