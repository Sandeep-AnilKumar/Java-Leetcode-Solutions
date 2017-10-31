package Strings;

/**
 * @author sandeepa
 */

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println("The longest substring without repetaing characters is := " + new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;

		int length = s.length();
		int start = 0;
		int max = 0;
		char c;
		int[] count = new int[256];

		for(int i = 0; i < length; ++i) {
			c = s.charAt(i);
			count[(int) c]++;

			while(count[(int) c] > 1) count[(int) s.charAt(start++)]--;

			max = Math.max(max, i - start + 1);
		}

		return max;
	}
}