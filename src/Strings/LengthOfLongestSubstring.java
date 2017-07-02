package Strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
		String s = "pwwkew";
		System.out.println("The length of longest substring is := " + ls.lengthOfLongestSubstringBetter(s));
	}

	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		Deque<Character> dq = new ArrayDeque<>();
		Set<Character> set = new HashSet<>();

		char[] array = s.toCharArray();
		int length = array.length;
		int max = 0;

		for(int i = 0; i < length; ++i) {
			if(set.add(array[i])) {
				dq.offerLast(array[i]);
				max = Math.max(max, dq.size());
			} else {
				while(!set.add(array[i]) && !dq.isEmpty()) {
					set.remove(dq.pollFirst());
				}
				dq.offerLast(array[i]);
			}
		}
		return max;
	}

	public int lengthOfLongestSubstringBetter(String s) {
		int n = s.length(), ans = 0;
		int[] index = new int[128];
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}
}