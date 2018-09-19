package DesignPatterns.CreationalPatterns.FactoryPattern;

public abstract class ABurger {
  private String name;
  private Double price;
  
  public ACheese cheese;
  public AMeat meat;
  public AVeggies veggies;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }

  public void onCreate() {
    System.out.println("Created " + getName() + " with a price of " + getPrice());
    printContents();
  }

  private void printContents() {
    cheese.print();
    meat.print();
    veggies.print();
  }
}
