package Strings;

/**
 * @author sandeepa
 */

public class ValidPalindromeAtMostOneCharRemoval {

	public static void main(String[] args) {
		String s = "abcda";
		System.out.println("Is string '" + s + "' a valid palindrome, with at most one char removed? := " + new ValidPalindromeAtMostOneCharRemoval().validPalindrome(s));
	}

	boolean once = false;
	public boolean validPalindrome(String s) {
		if(s == null || s.length() == 0) return false;

		return validPalindrome(s, 0, s.length() - 1);
	}

	public boolean validPalindrome(String s, int start, int end) {
		if(start == end) return true;

		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				if(once) return false;
				if(start + 1 == end && !once) return true;
				once = true;

				return validPalindrome(s, start + 1, end) || validPalindrome(s, start, end - 1);
			}
			end--;
			start++;
		}
		return true;
	}
}
