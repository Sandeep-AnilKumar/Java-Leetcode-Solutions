package Arrays;

import java.util.HashSet;
import java.util.Set;

public class SuperPalindrome {
  public static int superpalindromesInRange(String L, String R) {
    long left = Long.valueOf(L);
    long right = Long.valueOf(R);
    int total = 0;
    Set<Long> pals = new HashSet<>();

    double sqrt = 0;
    while (left <= right) {
      if (isPalindrome(left)) {
        pals.add(left);
        sqrt = Math.sqrt(left);
        if (sqrt % 1 == 0 && pals.contains((long) sqrt)) total++;
        left++;
      }
    }
    return total;
  }

  private static boolean isPalindrome(long i) {
    String val = String.valueOf(i);
    int l = 0, r = val.length() - 1;
    while (l < r) {
      if (val.charAt(l) != val.charAt(r)) return false;
      l++; r--;
    }
    return true;
  }
  
  public static void main(String[] args) {
    String L = "4";
    String R = "1000";
    System.out.println(SuperPalindrome.superpalindromesInRange(L, R));
  }
}
