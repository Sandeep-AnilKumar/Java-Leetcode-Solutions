package DynamicProgramming;

public class InterleaveString {
	public static void main(String[] args) {
		InterleaveString interleaveString = new InterleaveString();
		String s = "aabcc";
		String p = "dbbca";
		String r = "aadbbcbcac";

		System.out.println(interleaveString.isInterleave(s, p, r));

	}

	public boolean isInterleave(String s, String p, String r) {
		if (s == null) return p != null && r != null && p.equals(r);
		if (p == null) return r != null && s.equals(r);

		int m = s.length(), n = p.length();
		Boolean[][] memo = new Boolean[m][n];
		return isInterleave(s, p, r, 0, 0, 0, memo);
	}

	private boolean isInterleave(String s, String p, String r, int i, int j,
								 int k, Boolean[][] memo) {
		if (i == s.length()) {
			if (j == p.length() && k == r.length()) return true;
			if (j == p.length() || k == r.length()) return false;

			return p.substring(j).equals(r.substring(k));

		} else if (j == p.length()) {
			if (k == r.length()) return false;
			return s.substring(j).equals(r.substring(k));

		} else if (memo[i][j] == null) {
			char a = s.charAt(i), b = p.charAt(j), c = r.charAt(k);

			memo[i][j] = (a == c && isInterleave(s, p, r, i + 1, j, k + 1, memo))
					|| (b == c && isInterleave(s, p, r, i, j + 1, k + 1, memo));
		}

		return memo[i][j];
	}
}
