package String;


import java.util.TreeMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;


public class MinimumWindowString_Unsolved {

	public static void main(String args[]) {
		String s = "ADOBECADEBANC";
		String t = "ABC";

		String result = findMinimumWindow(s,t);
		if(result == null || result.isEmpty()) {
			System.out.println("");
		}
		else {
			System.out.println(result);
		}
	}

	public static String findMinimumWindow(String s, String t) {
		if(s == null || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}

		if(t.length() > s.length()) {
			return "";
		}

		int initIndex = 0;
		int min = Integer.MAX_VALUE;
		int nextIndex = 0;
		int length = t.length();
		int end = s.length();
		Map<Integer, String> resultMap = new TreeMap<Integer, String>();
		Set<Character> tSet = new HashSet<Character>();

		for(char tChar : t.toCharArray()) {
			tSet.add(tChar);
		}

		Set<Character> tempSet = new HashSet<Character>(tSet);

		for(int index = 0; index < end; index++ ) {
			char temp = s.charAt(index);

			if(tempSet != null && tempSet.contains(temp)) {
				if(tempSet.size() == length) {
					initIndex = index;
				}

				else if(tempSet.size() + 1 == length) {
					nextIndex = initIndex;
				}
				tempSet.remove(temp);
			}

			else {
				if(index == 0) {
					initIndex = index + 1;
					continue;
				}
			}

			if(tempSet == null || tempSet.isEmpty()) {
				min = Math.min(index - initIndex + 1, min);
				tempSet = new HashSet<Character>(tSet);
				resultMap.put(min, s.substring(initIndex, index + 1));
				initIndex = index + 1;
			}
		}
		return (resultMap.get(min) == null ? "" : resultMap.get(min));	
	}
}