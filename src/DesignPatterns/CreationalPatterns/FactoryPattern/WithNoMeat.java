package DesignPatterns.CreationalPatterns.FactoryPattern;

public class WithNoMeat extends AMeat {
  
  public WithNoMeat() {
    setHasMeat(false);
  }

  @Override
  public void print() {
    System.out.println("With no meat");
  }
}
