package Strings;

public class LongestSubstring {

	public static void main(String[] args) {
		LongestSubstring ls = new LongestSubstring();
		String s = "hello";
		int k = 2;
		System.out.println("The longest substring with 2 distinct characters is := " + ls.longestSubstring(s, k));
	}

	public String longestSubstring(String s, int k) {
		if(s == null || s.length() == 0 || k <= 0) {
			return s;
		}

		if(k == 1) {
			return s.charAt(0) + "";
		}
		
		int[] count = new int[26];
		char[] array = s.toCharArray();
		
		


		return s;
	}
}
