package Strings;

/**
 * @author sandeepa
 */

public class RegularExpressionMatching {

	enum Result {
		TRUE, FALSE;
	}

	public static void main(String[] args) {
		String s = "aabcd";
		String p = "c*a*b.d*";

		System.out.println("Is the regular expression := '" + p + "' a right one for '" + s + "' ? := " + new RegularExpressionMatching().isMatch(s, p));
	}

	public boolean isMatch(String s, String p) {
		if(s == null || s.length() == 0) return false;
		if(p == null || p.length() == 0) return false;
		Result[][] memo = new Result[s.length() + 1][p.length() + 1];

		return dp(0, 0, s, p, memo);
	}

	//Top-down.
	public boolean dp(int i, int j, String s, String p, Result[][] memo) {
		if(memo[i][j] != null) {
			return memo[i][j] == Result.TRUE;
		}

		boolean ans = false;
		boolean check = false;
		if(j == p.length()) {
			ans = i == s.length();
		} else {
			check = (i < s.length() && (s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.')) ? true : false;

			if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
				ans = dp(i, j + 2, s, p, memo) || check && dp(i + 1, j, s, p, memo);
			} else {
				ans = check && dp(i + 1, j + 1, s, p, memo);
			}
		}

		memo[i][j] = ans ? Result.TRUE : Result.FALSE;
		return ans;
	}

	//Bottom-up
	public boolean isMatchBottomUp(String text, String pattern) {
		boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
		dp[text.length()][pattern.length()] = true;

		for (int i = text.length(); i >= 0; i--){
			for (int j = pattern.length() - 1; j >= 0; j--){
				boolean first_match = (i < text.length() && 
						(pattern.charAt(j) == text.charAt(i) ||
						pattern.charAt(j) == '.'));
				if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
					dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
				} else {
					dp[i][j] = first_match && dp[i+1][j+1];
				}
			}
		}
		return dp[0][0];
	}
}
