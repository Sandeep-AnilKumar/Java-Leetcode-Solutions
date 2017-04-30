package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CoinChange2 {

	public static void main(String[] args) {
		int[] coins = new int[20];
		for(int i = 1; i < 20; ++i) {
			coins[i - 1] = i;
		}
		int amount = 20;
		System.out.println(changeDP(amount, coins));
	}

	//May not work for large numbers.
	public static int change(int amount, int[] coins) {
		if((coins == null || coins.length == 0) && amount == 0) {
			return 1;
		}

		List<Integer> coinsList = new ArrayList<>(coins.length);
		for(int c: coins) {
			coinsList.add(c);
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int sum = change(amount, coinsList, result, new ArrayList<Integer>(), 0);
		for(List<Integer> r: result) {
			System.out.println(r);
		}

		return sum;
	}

	public static int change(int amount, List<Integer> coins, List<List<Integer>> result, List<Integer> perm, int sum) {
		if(coins == null || coins.size() == 0 || amount < 0) {
			return sum;
		}

		if(amount == 0) {
			result.add(new ArrayList<>(perm));
			return sum + 1;
		}

		List<Integer> cur = new ArrayList<>(coins);
		int curCoin = cur.get(cur.size() - 1);
		if(amount >=  curCoin) {
			perm.add(curCoin);
			sum = change(amount - curCoin, cur, result, perm, sum);
			perm.remove(new Integer(curCoin));
		}

		cur.remove(cur.indexOf(curCoin));
		sum = change(amount, cur, result, perm, sum);
		return sum;
	}

	//Best Solution.
	public static int changeDP(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = 1; i <= amount; i++) {
				if (i >= coin) {
					dp[i] += dp[i - coin];
				}
			}
		}
		return dp[amount];
	}
}
