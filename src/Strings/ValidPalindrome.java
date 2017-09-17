package Strings;

public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "abcdadba";
		System.out.println("Is it a valid palindrome := " + new ValidPalindrome().validPalindrome(s));
	}

	public boolean validPalindrome(String s) {
		if(s == null || s.length() == 0) return false;

		int length = s.length();
		int start = 0;
		int end = length - 1;

		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				if(!validPalindrome(s, start + 1, end) && !validPalindrome(s, start, end - 1)) return false;
				return true;
			}
			start++;
			end--;
		}
		return true;
	}

	public boolean validPalindrome(String s, int start, int end) {
		if(start >= s.length() && end < 0) return false;
		while(start < end){
			if(s.charAt(start++) != s.charAt(end--)) return false;
		}
		return true;
	}
}