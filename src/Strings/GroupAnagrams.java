package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat","bat","tan","nat","ate","tea"};
		System.out.println("The anagram groups are: " + new GroupAnagrams().groupAnagrams(strs));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groups = new ArrayList<>();
		if(strs == null || strs.length == 0) {
			return groups;
		}

		int[] occ = new int[26];
		Map<String, List<String>> group = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		String curString = "";

		for(String s: strs) {
			occ = new int[26];
			sb = new StringBuilder();
			for(char c: s.toCharArray()) {
				occ[c - 'a']++;
			}

			for(int i = 0; i < 26; ++i) {
				if(occ[i] >= 1) {
					while(occ[i]-- > 0) {
						sb.append('a' + i);
					}
				}
			}

			curString = sb.toString();
			if(group.containsKey(curString)) {
				group.get(curString).add(s);
			} else {
				List<String> curList = new ArrayList<>();
				curList.add(s);
				group.put(curString, curList);
			}
		}
		for(List<String> g: group.values()) {
			groups.add(g);
		}
		return groups;
	}
}
