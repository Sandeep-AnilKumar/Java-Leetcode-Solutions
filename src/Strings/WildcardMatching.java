package Strings;

/**
 * @author sandeepa
 */

public class WildcardMatching {

	public static void main(String[] args) {
		String s = "aa";
		String p = "a";

		System.out.println("Is the wildcard expression := '" + p + "' a right one for '" + s + "' ? := " + new WildcardMatching().isMatch(s, p));
	}

	enum Result {
		TRUE, FALSE;
	}

	public boolean isMatch(String s, String p) {
		Result[][] memo = new Result[s.length() + 1][p.length() + 1];
		return dp(0, 0, s, p, memo);
	}

	public boolean dp(int i, int j, String s, String p, Result[][] memo) {
		if(i == s.length()) {
			return checkPattern(p, j);
		}

		if(memo[i][j] != null) {
			return memo[i][j] == Result.TRUE;
		}

		boolean ans = false;

		if(j == p.length()) {
			ans = i == s.length();
		}

		boolean check = (i < s.length() && j < p.length() && ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '?'))) ? true : false;

		if(check) {
			ans = dp(i + 1, j + 1, s, p, memo);
		} else {
			if(j < p.length() && p.charAt(j) == '*') {
				ans = dp(i + 1, j + 1, s , p, memo) || dp(i, j + 1, s, p, memo) || dp(i + 1, j, s, p, memo);
			} else {
				ans = false;
			}
		}

		memo[i][j] = ans ? Result.TRUE : Result.FALSE;
		return ans;
	}

	public boolean checkPattern(String p, int index) {
		for(; index < p.length(); ++index) {
			if(p.charAt(index) != '*') return false;
		}
		return true;
	}
}
