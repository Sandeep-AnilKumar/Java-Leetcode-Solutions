package Strings;

/**
 * @author sandeepa
 */

public class InterleavingStrings {

	public static void main(String[] args) {
		InterleavingStrings strings = new InterleavingStrings();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";

		System.out.println("Are the strings interleaving ? := " + strings.isInterleave(s1, s2, s3));
		s3 = "aadbbbaccc";
		System.out.println("Are the strings interleaving ? := " + strings.isInterleave(s1, s2, s3));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s1.length() == 0) {
			return s2.equals(s3);
		}

		if(s2 == null || s2.length() == 0) {
			return s1.equals(s3);
		}

		if(s1.length() + s2.length() != s3.length()) {
			return false;
		}

		return isInterleave(s1, s2, s3, 0, 0, 0, new Boolean[s1.length()][s2.length()]);
	}

	public boolean isInterleave(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
		if(i >= s1.length()) {
			return s2.substring(j).equals(s3.substring(k));
		}

		if(j >= s2.length()) {
			return s1.substring(i).equals(s3.substring(k));
		}

		if(memo[i][j] != null) {
			return memo[i][j];
		}

		boolean result = false;

		result = s1.charAt(i) == s3.charAt(k) && isInterleave(s1, s2, s3, i + 1, j, k + 1, memo) || s2.charAt(j) == s3.charAt(k) && isInterleave(s1, s2, s3, i, j + 1, k + 1, memo);

		memo[i][j] = result;
		return result;
	}
}
