package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class PerfectSquares2 {

	public static void main(String[] args) {
		int n = 28;
		System.out.println("The least number of primes that sum up to '" + n + "' is := " + new PerfectSquares2().numSquares(n));
	}

	public int numSquares(int n) {
		List<Integer> primes = new ArrayList<>();
		generatePrimes(n, primes);

		int[] dp = new int[n + 1];
		int curMin = Integer.MAX_VALUE;

		for(int i = 1; i <= n; ++i) {
			curMin = Integer.MAX_VALUE;
			for(int prime : primes) {
				if(i >= prime) {
					curMin = Math.min(curMin, dp[i - prime] + 1);
				} else {
					break;
				}
			}

			dp[i] = curMin != Integer.MAX_VALUE ? curMin : 0;
		}

		return dp[n];
	}

	public void generatePrimes(int n, List<Integer> primes) {
		for(int i = 1; i * i <= n; ++i) {
			primes.add(i * i);
		}
	}
}
