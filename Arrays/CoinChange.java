package Arrays;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {

		int[] coins = new int[]{1};
		int amount = 1;
		int count = coinChange(coins, amount);
		System.out.println("The number of coins needed to tender the change is : " + count);
	}

	public static int coinChange(int[] coins, int amount)
	{
		int dp[] = new int[amount+1];
		int min = Integer.MAX_VALUE;

		int coinsLength = coins.length;
		int dpLength = dp.length;

		for(int i = 1; i < dpLength; i++)
		{
			min = Integer.MAX_VALUE;
			for(int j = 0; j < coinsLength; j++)
			{
				int diff = i - coins[j];
				if(diff >= 0 && dp[diff] >= 0)
				{
					min = Math.min(min,dp[diff] + 1);
				}
			} 

			dp[i] = (min == Integer.MAX_VALUE ? -1 : min);
		}

		return dp[amount];
	}
}
