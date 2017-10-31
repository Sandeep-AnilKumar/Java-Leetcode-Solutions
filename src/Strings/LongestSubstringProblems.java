package Strings;

/**
 * @author sandeepa
 */

public class LongestSubstringProblems {

	public static void main(String[] args) {
		LongestSubstringProblems longest = new LongestSubstringProblems();
		String s = "abcaabbcda";
		System.out.println("the length of the longest substring of string '" + s + "' without repeating characters is := " + longest.lengthOfLongestSubstring(s));
	}

	//Longest Substring without repeating characters.
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;

		int length = s.length();
		int start = 0;
		int max = 0;
		char c;
		int[] count = new int[256]; //Extended ASCII, 128 for ASCII, 26 for 'a' to 'z' or 'A' to 'Z'.

		for(int i = 0; i < length; ++i) {
			c = s.charAt(i);
			count[(int) c]++;

			while(count[(int) c] > 1) count[(int) s.charAt(start++)]--;

			max = Math.max(max, i - start + 1);
		}
		return max;
	}
}
