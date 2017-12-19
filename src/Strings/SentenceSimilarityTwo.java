package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sandeepa
 */

public class SentenceSimilarityTwo {

	public static void main(String[] args) {
		String[] words1 = {"great","acting","skills"};
		String[] words2 = {"fine","drama","talent"};
		String[][] pairs = {{"great","good"},{"fine","good"},{"drama","acting"},{"skills","talent"}};
		System.out.println("Are the two sentences similar? := " + new SentenceSimilarityTwo().areSentencesSimilarTwo(words1, words2, pairs));
	}

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if(words1 == null || words1.length == 0) return words2 == null || words2.length == 0;
		if(words2 == null || words2.length == 0) return words1 == null || words1.length == 0;

		if(words1.length != words2.length) return false;

		Map<String, List<String>> map = new HashMap<>();
		List<String> sim = new ArrayList<>();

		for(String[] pair: pairs) {
			if(!map.containsKey(pair[0])) {
				sim = new ArrayList<>();
			} else {
				sim = map.get(pair[0]);
			}
			sim.add(pair[1]);
			map.put(pair[0], sim);

			for(String trans: sim) {
				if(!trans.equals(pair[1])) {
					map.get(trans).add(pair[1]);
				}
			}

			if(!map.containsKey(pair[1])) {
				sim = new ArrayList<>();
			} else {
				sim = map.get(pair[1]);
			}
			sim.add(pair[0]);
			map.put(pair[1], sim);

			for(String trans: sim) {
				if(!trans.equals(pair[0])) {
					map.get(trans).add(pair[0]);
				}
			}
		}

		int length = words1.length;

		for(int index = 0; index < length; ++index) {

			if(words1[index].equals(words2[index])) continue;
			if(map == null || map.get(words1[index]) == null || !map.get(words1[index]).contains(words2[index])) return false;

		}
		return true;
	}
}
