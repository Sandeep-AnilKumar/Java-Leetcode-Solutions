package Strings;

public class LongestSubstringAtmostKChars {

	public static void main(String[] args) {
		LongestSubstringAtmostKChars substring = new LongestSubstringAtmostKChars();
		String s = "aaabbbcdefcdefgggggggggggggggcde";
		int k = 3;
		System.out.println("Longest substring with at most k characters is := " + substring.longestSubstring(s, k));
	}

	public int longestSubstring(String s, int k) {
		int length = s.length();
		char[] chars = s.toCharArray();
		int[] counts = new int[26];
		int[] curCount = new int[26];

		for(int i = 0; i < length; ++i) {
			counts[chars[i] - 'a']++;
		}

		int max = 0;
		int count = 0;
		int curStart = 0;

		for(int i = 0; i < length; ++i) {
			if(counts[chars[i] - 'a'] >= k) {
				curCount[chars[i] - 'a']++;
				count++;
			} else {
				if(count > 0 && validSubstring(curCount, k)) {
					max = Math.max(max, count);
				} else if(count > max){
					max = Math.max(max, longestSubstring(s.substring(curStart, i), k));
				}
				count = 0;
				curStart = i + 1;
				curCount = new int[26];
			}
		}

		if(count > 0 && validSubstring(curCount, k)) {
			max = Math.max(max, count);
		} else if (count > max){
			max = Math.max(max, longestSubstring(s.substring(curStart), k));
		}

		return max;
	}

	public boolean validSubstring(int[] curCount, int k) {
		for(int j = 0; j < 26; ++j) {
			if(curCount[j] != 0 && curCount[j] < k) {
				return false;
			}
		}
		return true;
	}

	public int longestSubstringBetter(String s, int k) {
		int d = 0;

		for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
			d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

		return d;
	}

	private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
		int[] map = new int[128];
		int numUnique = 0; // counter 1
		int numNoLessThanK = 0; // counter 2
		int begin = 0, end = 0;
		int d = 0;

		while (end < s.length()) {
			if (map[s.charAt(end)]++ == 0) numUnique++; // increment map[c] after this statement
			if (map[s.charAt(end++)] == k) numNoLessThanK++; // inc end after this statement

			while (numUnique > numUniqueTarget) {
				if (map[s.charAt(begin)]-- == k) numNoLessThanK--; // decrement map[c] after this statement
				if (map[s.charAt(begin++)] == 0) numUnique--; // inc begin after this statement
			}

			// if we found a string where the number of unique chars equals our target
			// and all those chars are repeated at least K times then update max
			if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
				d = Math.max(end - begin, d);
		}
		return d;
	}
}
