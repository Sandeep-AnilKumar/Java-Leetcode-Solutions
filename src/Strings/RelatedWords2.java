package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author sandeepa
 */

public class RelatedWords2 {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		String text = in.nextLine();
		String word = in.next();
		int n = in.nextInt();
		in.close();

		String frequent = getMostFrequent(text, word, n);
		System.out.println(frequent);
	}

	public static String getMostFrequent(String text, String word, int n) {
		List<String> occ = new ArrayList<>();
		List<Integer> indexes = new ArrayList<>();
		word = word.toLowerCase();
		preprocess(text, word, occ, indexes);
		Map<String, Integer> count = new HashMap<>();
		int size = occ.size();
		String cur = "";
		String prev = "";
		Set<String> curSet = new HashSet<>();

		for(int i: indexes) {
			curSet = new HashSet<>();
			if(occ.get(i).equals(word)) {
				cur = occ.get(i);
				for(int j = i - n; j >= 0 && j <= i + n && j < size; ++j) {
					prev = occ.get(j);
					if(j == i || prev.equals(cur) || curSet.contains(prev)) continue;

					curSet.add(prev);

					if(!count.containsKey(prev)) {
						count.put(prev, 0);
					}
					count.put(prev, count.get(prev) + 1);
				}
			}
		}

		int curMax = 0;
		int max = 0;
		String frequent = "";
		for(Map.Entry<String, Integer> entry: count.entrySet()) {
			cur = entry.getKey();
			curMax = entry.getValue();

			if((curMax > max) || (curMax == max && frequent.compareTo(cur) > 0)) {
				max = curMax;
				frequent = cur;
			}
		}

		return frequent == null || frequent.length() == 0 ? "N/A" : frequent;
	}

	public static void preprocess(String text, String word, List<String> occ, List<Integer> indexes) {
		if(text == null || text.length() == 0) return;
		StringBuilder sb = new StringBuilder();
		int length = text.length();
		char[] chars = text.toCharArray();
		int ascii = 0;

		for(int i = 0; i < length; ++i) {
			ascii = (int) chars[i];
			if(chars[i] == ' ' && sb != null && sb.toString().length() > 0) {
				occ.add(sb.toString());
				if(sb.toString().toLowerCase().equals(word)) {
					indexes.add(occ.size() - 1);
				}
				sb = new StringBuilder();
			} else if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
				if(ascii >= 65 && ascii <= 90) {
					ascii = (ascii + 32);
				}
				sb.append((char) ascii);
			}
		}
	}
}
