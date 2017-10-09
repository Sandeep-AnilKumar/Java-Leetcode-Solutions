package Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sandeepa
 */

public class LongestSubstringContainingKChars {

	public static void main(String[] args) {
		String s = "eceebaeeeec";
		int k = 3;
		System.out.println("The length of longest substring containing " + k + " chars is := " + new LongestSubstringContainingKChars().longestSubstring(s, k));
	}

	public int longestSubstring(String s, int k) {
		if(s == null || s.length() == 0) return 0;

		int length = s.length();

		int[] count = new int[256];
		Set<Character> set = new HashSet<>();
		int max = 0;
		int l = 0;
		char c;

		for(int i = 0; i < length; ++i) {
			c = s.charAt(i);

			if(set.size() == k && !set.contains(c)) {
				while(set.size() == k && l < length) {
					count[s.charAt(l)]--;
					if(count[s.charAt(l)] == 0) {
						set.remove(s.charAt(l));
					}
					l++;
				}
			}
			count[c]++;
			set.add(c);
			max = Math.max(max, i - l + 1);
		}
		return max;
	}
}
