package DesignPatterns.CreationalPatterns.FactoryPattern;

public abstract class AMeat {
  private boolean hasMeat;
  
  public void setHasMeat(boolean hasMeat) { this.hasMeat = hasMeat; }
  public  boolean getHasMeat() { return hasMeat; }
  public abstract  void print();
}
