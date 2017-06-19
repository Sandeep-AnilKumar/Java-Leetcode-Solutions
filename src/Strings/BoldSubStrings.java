package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoldSubStrings {
	Map<Character, List<String>> map;

	public BoldSubStrings(List<String> dict) {
		map = new HashMap<>();
		List<String> cur = null;
		for(String d: dict) {
			if(map.containsKey(d.charAt(0))) {
				cur = map.get(d.charAt(0));
			} else {
				cur = new ArrayList<>();
			}
			cur.add(d);
			map.put(d.charAt(0), cur);
		}
		return;
	}

	public String boldSubStrings(String s) {
		if(s == null || s.length() == 0 || map == null || map.size() == 0) {
			return s;
		}

		int length = s.length();
		int[] bit = new int[length];
		int max = Integer.MIN_VALUE;
		List<String> curList = null;
		StringBuffer sb = new StringBuffer();
		char cur;
		int j = 0;

		for(int i = 0; i < length; ++i) {
			cur = s.charAt(i);
			max = Integer.MIN_VALUE;
			if(map.containsKey(cur)) {
				curList = map.get(cur);
				for(String l: curList) {
					if((s.substring(i, i + l.length())).equals(l)) {
						if(l.length() > max) {
							max = l.length();
						}
					}
				}
			}

			for(j = i; j < i + max; ++j) {
				bit[j] = 1;
			}
		}

		for(int i = 0; i < length; ++i) {
			if(bit[i] == 0) {
				sb.append(s.charAt(i));
				continue;
			}
			j = i;
			sb.append("<b>");
			while(j < length && bit[j] != 0) {
				sb.append(s.charAt(j++));
			}
			sb.append("</b>");
			i = j - 1;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		List<String> dict = Arrays.asList("ab", "cd", "123", "a");
		BoldSubStrings b = new BoldSubStrings(dict);
		System.out.println("The bold string for 'cb123ae' is:= " + b.boldSubStrings("cb123ae"));
		System.out.println("The bold string for 'cd123ae' is:= " + b.boldSubStrings("cd123ae"));
		dict = Arrays.asList("abc", "cd", "123", "a", "b", "c");
		b = new BoldSubStrings(dict);
		System.out.println("The bold string for 'abcdacb12cd123' is:= " + b.boldSubStrings("abcdacb12cd123"));
	}
}
