package Arrays;

public class GuessGame2 {
  public int getMoneyAmount(int n) {
    int total = 0;
    double cur = 0, prev = 0, base = 2;
    while (true) {
      cur = Math.ceil(prev + n / base);
      if (cur >= n) return total;
      total += cur;
      base *= 2;
      prev = cur;
    }
  }
  
  public static void main(String[] args) {
    GuessGame2 guessGame2 = new GuessGame2();
    int n = 10;
    System.out.println("The amount of money needed to guarantee a win for n := " + n + " is := " + guessGame2.getMoneyAmount(n));
  }
}
