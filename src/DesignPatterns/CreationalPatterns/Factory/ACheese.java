package DesignPatterns.CreationalPatterns.Factory;

public abstract class ACheese {
  private boolean hasCheese;
  
  public void setHasCheese(boolean hasCheese) { this.hasCheese = hasCheese; }
  
  public boolean getHasCheese() { return hasCheese; }
  
  public abstract void print();
}
