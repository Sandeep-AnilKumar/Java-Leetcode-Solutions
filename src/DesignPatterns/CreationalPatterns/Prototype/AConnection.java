package DesignPatterns.CreationalPatterns.Prototype;

public abstract class AConnection implements IConnection {
  @Override
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  public abstract void print();
}
