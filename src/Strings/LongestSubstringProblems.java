package Strings;

/**
 * @author sandeepa
 */

public class LongestSubstringProblems {

	public static void main(String[] args) {
		LongestSubstringProblems longest = new LongestSubstringProblems();
		String s = "abcaabbcda";
		System.out.println("the length of the longest substring of string '" + s + "' without repeating characters is := " + longest.lengthOfLongestSubstring(s));
		s = "baaab";
		int k = 2;
		System.out.println("The length of the substring with longest character replacement with '" + k + "' chars in the string '" + s + "' is := " + longest.characterReplacement(s, k));
		s = "aabcbdaab";
		System.out.println("The length of the longest substring in '" + s + "' with at most 2 distinct characters is := " + longest.lengthOfLongestSubstringTwoDistinct(s));
		k = 3;
		System.out.println("The length of the longest substring in '" + s + "' with at most " + k + " distinct characters is := " + longest.lengthOfLongestSubstringKDistinct(s, k));
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
		if(s == null || s.length() == 0) return 0;

		int length = s.length();
		int[] count = new int[256];

		int start = 0, maxCount = 0, max = 0;

		for (int i = 0; i < length; i++) {
			maxCount = Math.max(maxCount, ++count[(int) s.charAt(i)]);

			while (i - start + 1 - maxCount > k) count[(int) s.charAt(start++)]--;

			max = Math.max(max, i - start + 1);
		}
		return max;
	}

	//Longest substring with at most 2 distinct characters
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s == null || s.length() == 0) return 0;

		int length = s.length();
		int[] count = new int[256];

		char c;
		int start = 0, max = 0;

		for(int i = 0; i < length; ++i) {
			c = s.charAt(i);
			count[(int) c]++;

			while(distinctCount(count) > 2) count[(int) s.charAt(start++)]--;

			max = Math.max(max, i - start + 1);
		}
		return max;
	}

	public int distinctCount(int[] count) {
		int distinct = 0;
		for(int c: count) {
			if(c >= 1) distinct++;
		}
		return distinct;
	}

	//Longest substring with at most k distinct characters
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(s == null || s.length() == 0) return 0;

		int length = s.length();
		int[] count = new int[256];

		char c;
		int start = 0, max = 0;

		for(int i = 0; i < length; ++i) {
			c = s.charAt(i);
			count[(int) c]++;

			while(distinctCount(count) > k) count[(int) s.charAt(start++)]--;

			max = Math.max(max, i - start + 1);
		}
		return max;
	}

	//A better way, without calculating the distinctCount every time.
	public int lengthOfLongestSubstringKDistinctBetter(String s, int k) {
		int[] count = new int[256];
		int num = 0, i = 0, res = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)]++ == 0) num++;
			if (num > k) {
				while (--count[s.charAt(i++)] > 0);
				num--;
			}
			res = Math.max(res, j - i + 1);
		}
		return res;
	}
	
	//Good resources to read: https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
	//https://discuss.leetcode.com/topic/71662/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
}
