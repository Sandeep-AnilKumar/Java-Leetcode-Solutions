package Arrays;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int count = coinChange(coins, amount);
        System.out.println("The number of coins needed to tender the change is : " + count);
    }

    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        Arrays.sort(coins);
        int length = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int min = Integer.MAX_VALUE;
        int diff = 0;
        for(int i = 1; i <= amount; ++i) {
            min = Integer.MAX_VALUE;
            for(int j = 0; j < length; ++j) {
                diff = i - coins[j];
                if(diff >= 0 && dp[diff] >= 0) {
                    min = Math.min(min, dp[diff] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }
}
