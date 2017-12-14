package Strings;

/**
 * @author sandeepa
 */

public class OnesAndZeros {
	public static void main(String[] args) {
		String[] strs = {"10"};
		int m = 5;
		int n = 3;

		System.out.println("The number of strings that can be formed with '" + m + "' zeros and '" + n + "' ones are := " + new OnesAndZeros().findMaxForm(strs, m, n));
	}

	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s: strs) {
			int[] count = countzeroesones(s);
			for (int zeroes = m; zeroes >= count[0]; zeroes--)
				for (int ones = n; ones >= count[1]; ones--)
					dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
		}
		return dp[m][n];
	}
	public int[] countzeroesones(String s) {
		int[] c = new int[2];
		for (int i = 0; i < s.length(); i++) {
			c[s.charAt(i)-'0']++;
		}
		return c;
	}
}
