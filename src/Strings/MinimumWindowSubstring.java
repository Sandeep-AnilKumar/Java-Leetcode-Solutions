package Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sandeepa
 */

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "ADOBEBAEFCBANC";
		String t = "ABC";
		
		
		
		System.out.println("The minimum window substring is := " + new MinimumWindowSubstring().minWindow(s, t));
	}

	public String minWindow(String s, String t) {
		if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";

		String sub = "";
		int max = 0, l = 0, num = 0, length = s.length();
		Set<Character> set = new HashSet<>();
		int[] count = new int[256];
		char c;
		char p;

		for(int i = 0; i < t.length(); ++i) {
			set.add(t.charAt(i));
		}

		for(int i = 0; i < length; ++i) {
			c = s.charAt(i);
			if(set.contains(c) && count[c] == 0) {
				num++;
				count[c]++;
				if(num == set.size()) {
					if(i - l + 1 > max) {
						max = i - l + 1;
						sub = s.substring(l, i + 1);
					}
				}
			}

			if(set.contains(c) && count[c] > 0) {
				while(l < length && s.charAt(l) != c) {
					p = s.charAt(l);
					if(set.contains(p)) {
						count[p]--;
					}
					l++;
				}

				while(l + 1 < length && !set.contains(s.charAt(l + 1))) l++;
			}
		}
		return sub;
	}
}
