package Strings;


/*Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
Return the maximum product you canShip get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).*/

public class IntegerBreak {

    public static void main(String[] args) {
        int n = 8;
        System.out.println("Maximum product for number " + n + " is : " + integerBreak(n));
    }

    public static int integerBreak(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= n; ++i) {
            for(int j = 1; j <= i/2; ++j) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
