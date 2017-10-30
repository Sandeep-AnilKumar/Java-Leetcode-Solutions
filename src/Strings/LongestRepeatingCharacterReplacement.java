package Strings;

/**
 * @author sandeepa
 */

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		String s = "BACDBB";
		int k = 2;

		System.out.println("The longest substring with character replacement is := " + new LongestRepeatingCharacterReplacement().characterReplacementBest(s, k));
	}

	//Will fail for "BAAAB"
	public int characterReplacement(String s, int k) {
		if(s == null || s.length() == 0) return 0;
		return Math.max(getLongest(s, k), getLongest(new StringBuilder(s).reverse().toString(), k));
	}

	public int getLongest(String s, int k) {
		int length = s.length();
		int max = 0;
		char cur;
		int j = 0;
		int r = 0;
		int next = 0;

		for(int i = 0; i < length && length - i >= max; ++i) {
			j = 0;
			cur = s.charAt(i);
			r = i + 1;

			while(j <= k && r < length) {
				if(cur != s.charAt(r)) {
					if(j == 0) next = r;
					j++;
					if(j > k) r--;
				}
				r++;
			}

			max = Math.max(max, r - i);
			if(r == length) break;
			i = next - 1;
		}
		return max;
	}

	public int characterReplacementBetter(String s, int k) {
		if(s == null || s.length() == 0){
			return 0;
		}
		int max = 0;
		int[] ch = new int[26];
		int length = s.length();
		char[] str = s.toCharArray();
		for(int i = 0, j = 0; i < length && length - i >= max; i++) {
			while(j < s.length()) {
				ch[str[j] - 'A']++;
				if(count(ch) > k){
					ch[str[j] - 'A']--;
					break;
				}
				j++;
			}
			max = Math.max(max, j-i);
			ch[str[i] - 'A']--;
			if(j == length) break;
		}
		return max;
	}

	public int count(int[] ch){
		int max = 0;
		int sum = 0;
		for(int val:ch){
			sum += val;
			max = Math.max(max, val);
		}
		return sum - max;
	}

	public int characterReplacementBest(String s, int k) {
		int len = s.length();
		int[] count = new int[26];
		int start = 0, maxCount = 0, maxLength = 0;
		for (int end = 0; end < len; end++) {
			maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
			while (end - start + 1 - maxCount > k) {
				count[s.charAt(start) - 'A']--;
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
}
