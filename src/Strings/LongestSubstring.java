package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		LongestSubstring ls = new LongestSubstring();
		String s = "ababaccbcccca";
		int k = 2;
		System.out.println("The longest substring with 2 distinct characters is := " + ls.longestSubstring(s, k));
	}

	public String longestSubstring(String s, int k) {
		if(s == null || s.length() == 0) {
			return s;
		}

		Set<Character> set = new HashSet<>();
		char[] array = s.toCharArray();
		int length = array.length;
		int j = 0;
		List<Character> list = new ArrayList<>();
		String result = "";
		int max = 0;

		for(int i = 0; i < length; ++i) {
			if(set.size() < k) {
				set.add(array[i]);
				list.add(array[i]);
			} else if(set.size() == k) {
				if(set.add(array[i])) {
					while(set.size() > k) {
						set.remove(array[j++]);
						list.removeAll(Arrays.asList(list.get(0)));
					}
				}
				list.add(array[i]);
			}
			if(list.size() > max) {
				max = list.size();
				result = list.toString();
			}
		}
		return result;
	}
}
