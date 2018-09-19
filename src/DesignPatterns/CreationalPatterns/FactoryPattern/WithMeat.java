package DesignPatterns.CreationalPatterns.FactoryPattern;

public class WithMeat extends AMeat {

  public WithMeat() {
    setHasMeat(true);
  }

  @Override
  public void print() {
    System.out.println("With meat");
  }
}
