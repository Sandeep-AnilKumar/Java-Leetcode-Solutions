package Arrays;

public class TestClass {
  int y = 1;
  public TestClass(){ y = 2; f(); }
  void f () {System.out.println("Value = " +  String.valueOf(y));}
  public class B extends TestClass{
  int y = 3;
  public B(){ System.out.println("Value = " + String.valueOf(y));
  f(); }
  void f () {System.out.println("Value = " + String.valueOf(y));}
  }
  public static void main(String[] args) {
  TestClass o = new TestClass();
  B p = o.new B();
}} 