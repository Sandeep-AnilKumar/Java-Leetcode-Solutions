package Strings;

/**
 * @author sandeepa
 */

public class CountPalindromicSubstrings {

	public static void main(String[] args) {
		String s = "aaaaa";
		System.out.println("The number of palincromic substrings in the string '" + s + "' are := " + new CountPalindromicSubstrings().countSubstrings(s));
	}

	public int countSubstrings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		int length = s.length();
		int count = 0;

		for(int i = 0; i < length; ++i) {
			count += countSubstrings(s, i, i);
			count += countSubstrings(s, i, i + 1);
		}

		return count;
	}

	public int countSubstrings(String s, int i, int j) {
		if(i < 0 || j < 0 || i >= s.length() || j >= s.length()) {
			return 0;
		}

		int count = 0;
		while(i >= 0 && j < s.length()) {
			if(s.charAt(i) != s.charAt(j)) {
				break;
			}
			count++;
			i--;
			j++;
		}

		return count;
	}
}
