package DynamicProgramming;

/**
 * @author sandeepa
 */

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String s = "cbbd";
		System.out.println("The length of the longest palindromic subsequence is := " + new LongestPalindromicSubsequence().longestPalindromicSubsequence(s));
	}

	public int longestPalindromicSubsequence(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		int length = s.length();
		int[][] dp = new int[length][length];

		for(int i = length - 1; i >= 0; --i) {
			dp[i][i] = 1;
			for(int j = i + 1; j < length; ++j) {
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[0][length - 1];
	}
}
