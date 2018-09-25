package DesignPatterns.CreationalPatterns.Factory;

public class WithMeat extends AMeat {

  public WithMeat() {
    setHasMeat(true);
  }

  @Override
  public void print() {
    System.out.println("With meat");
  }
}
