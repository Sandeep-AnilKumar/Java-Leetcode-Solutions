package DesignPatterns.CreationalPatterns.Prototype;

public class MainPrototype {
  public static void main(String[] args) {
    try {

      AConnection jdbcConnection = ConnectionFactory.getConnection("jdbc");
      jdbcConnection.print();
      System.out.println(System.identityHashCode(jdbcConnection));

      AConnection httpConnection = ConnectionFactory.getConnection("http");
      httpConnection.print();
      System.out.println(System.identityHashCode(httpConnection));

      AConnection jdbcConnection2 = ConnectionFactory.getConnection("jdbc");
      jdbcConnection2.print();
      System.out.println(System.identityHashCode(jdbcConnection2));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
