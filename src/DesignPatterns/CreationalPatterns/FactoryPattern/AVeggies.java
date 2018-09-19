package DesignPatterns.CreationalPatterns.FactoryPattern;

public abstract class AVeggies {
  private boolean hasVeggies;
  
  public void setHasVeggies(boolean hasVeggies) { this.hasVeggies = hasVeggies; }
  public boolean getHasVeggies() { return hasVeggies; }
  public abstract  void print();
}
