package Strings;

/**
 * @author sandeepa
 */

public class LongestSubstringProblems {

	public static void main(String[] args) {
		LongestSubstringProblems longest = new LongestSubstringProblems();
		String s = "abcaabbcda";
		System.out.println("the length of the longest substring of string '" + s + "' without repeating characters is := " + longest.lengthOfLongestSubstring(s));
		s = "BAAAB";
		int k = 2;
		System.out.println("The length of the substring with longest character replacement with '" + k + "' chars in the string '" + s + "' is := " + longest.characterReplacement(s, k));
	}

	//Longest Substring without repeating characters.
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;

		int length = s.length();
		int[] count = new int[256]; //Extended ASCII, 128 for ASCII, 26 for 'a' to 'z' or 'A' to 'Z'.
		
		int start = 0, max = 0;
		char c;

		for(int i = 0; i < length; ++i) {
			c = s.charAt(i);
			count[(int) c]++;

			while(count[(int) c] > 1) count[(int) s.charAt(start++)]--;

			max = Math.max(max, i - start + 1);
		}
		return max;
	}

	//Longest repeating character replacement
	public int characterReplacement(String s, int k) {
		int len = s.length();
		int[] count = new int[256];
		int start = 0, maxCount = 0, max = 0;
		
		for (int i = 0; i < len; i++) {
			maxCount = Math.max(maxCount, ++count[(int) s.charAt(i)]);

			while (i - start + 1 - maxCount > k) count[(int) s.charAt(start++)]--;

			max = Math.max(max, i - start + 1);
		}
		return max;
	}
}
