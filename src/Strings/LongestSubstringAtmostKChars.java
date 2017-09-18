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
}
