package Strings;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String s = "bbcbcdb";
		System.out.println("The longest palindromic subsequence is of length := " + lps.longestPalindromeSubseqMemo(s));
	}

	//Will cause a time limit exceeded alert.
	public int longestPalindromeSubseq(String s) {
		int count = getLPS(s);
		return count;
	}

	public int getLPS(String s) {
		if(s == null || s.length() == 0) return 0;
		if(s.length() == 1) return 1;

		int count = 0;
		int start = 0;
		int end = s.length() - 1;

		while(start < end && s.charAt(start) == s.charAt(end)) {
			start++;
			end--;
			count += 2;
		}

		if(start > end) return count;
		if(start == end || (end - start == 1 && s.charAt(start) != s.charAt(end))) return count + 1;

		count += Math.max(getLPS(s.substring(start, end)), getLPS(s.substring(start + 1, end + 1)));
		return count;
	}

	public int longestPalindromeSubseqBetter(String s) {
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

	public int longestPalindromeSubseqMemo(String s) {
		return helper(s, 0, s.length() - 1, new int[s.length()][s.length()]);
	}

	private int helper(String s, int i, int j, int[][] memo) {
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		if (i > j)      return 0;
		if (i == j)     return 1;

		if (s.charAt(i) == s.charAt(j)) {
			memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
		} else {
			memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
		}
		return memo[i][j];
	}
}
