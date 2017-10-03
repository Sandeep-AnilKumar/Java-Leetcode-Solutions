package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sandeepa
 */

public class GroupShiftedStrings {

	public static void main(String[] args) {
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println("The grouped hsifted strings are := " + new GroupShiftedStrings().groupStrings(strings));
	}

	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		int length = 0;
		String cur = "";
		int diff = 0;

		for(String s: strings) {
			length = s.length();
			sb = new StringBuffer();
			sb.append('#');

			for(int i = 0; i < length - 1; ++i) {
				diff = s.charAt(i + 1) - s.charAt(i);

				if(diff < 0) {
					diff += 26;
				}

				sb.append(diff + '#');
			}

			cur = sb.toString();
			if(!map.containsKey(cur)) {
				map.put(cur, new ArrayList<>());
			}

			map.get(cur).add(s);
		}

		return new ArrayList<List<String>>(map.values());
	}
}
