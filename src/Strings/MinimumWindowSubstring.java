package Strings;

/**
 * @author sandeepa
 */

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "ABBCBCABAFCBBBBBACCCCC";
		String t = "ABCA";
		System.out.println("The minimum window substring is := " + new MinimumWindowSubstring().minWindow(s, t));
	}

	public String minWindow(String s, String t) {
		if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";

		int l = 0, length = s.length(), max = Integer.MAX_VALUE, num = t.length();
		int[] count = new int[256];
		int sStart = 0, sEnd = 0;

		for(int i = 0; i < t.length(); ++i) {
			count[t.charAt(i)]++;
		}

		for(int i = 0; i < length; ++i) {
			if(count[s.charAt(i)]-- > 0) num--;

			while(num == 0) {
				if(i - l + 1 < max) {
					max = i - l + 1;
					sStart = l;
					sEnd = i;
				}
				if(count[s.charAt(l++)]++ == 0) num++;
			}
		}
		return max == Integer.MAX_VALUE ? "" : s.substring(sStart, sEnd + 1);
	}
}
