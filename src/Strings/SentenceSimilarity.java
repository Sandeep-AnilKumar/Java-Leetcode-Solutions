package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sandeepa
 */

public class SentenceSimilarity {

	public static void main(String[] args) {
		String[] words1 = {"a","very","delicious","meal"};
		String[] words2 = {"one","really","good","dinner"};
		String[][] pairs = {{"great","good"},{"extraordinary","good"},
				{"well","good"},{"wonderful","good"},{"excellent","good"},{"fine","good"},{"nice","good"},
				{"any","one"},{"some","one"},{"unique","one"},{"the","one"},{"an","one"},{"single","one"},
				{"a","one"},{"truck","car"},{"wagon","car"},{"automobile","car"},{"auto","car"},
				{"vehicle","car"},{"entertain","have"},{"drink","have"},{"eat","have"},{"take","have"},
				{"fruits","meal"},{"brunch","meal"},{"breakfast","meal"},{"food","meal"},{"dinner","meal"},
				{"super","meal"},{"lunch","meal"},{"possess","own"},{"keep","own"},{"have","own"},{"extremely","very"},
				{"actually","very"},{"really","very"},{"super","very"}};

		System.out.println("Are the two sentences similar? := " + new SentenceSimilarity().areSentencesSimilar(words1, words2, pairs));
	}

	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
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

			if(!map.containsKey(pair[1])) {
				sim = new ArrayList<>();
			} else {
				sim = map.get(pair[1]);
			}
			sim.add(pair[0]);
			map.put(pair[1], sim);
		}

		int length = words1.length;

		for(int index = 0; index < length; ++index) {

			if(words1[index].equals(words2[index])) continue;
			if(map == null || map.get(words1[index]) == null || !map.get(words1[index]).contains(words2[index])) return false;

		}
		return true;
	}

	//A better solution.
	public boolean areSentencesSimilarBetter(String[] words1, String[] words2, String[][] pairs) {
		if(words1 == null || words1.length == 0) return words2 == null || words2.length == 0;
		if(words2 == null || words2.length == 0) return words1 == null || words1.length == 0;

		if(words1.length != words2.length) return false;

		int length = words1.length;
		Set<String> set = new HashSet<>();

		for(String[] pair: pairs) {
			set.add(pair[0] + "#" + pair[1]);
		}

		for(int index = 0; index < length; ++index) {
			if(!words1[index].equals(words2[index]) && set != null && !set.contains(words1[index] + "#" + words2[index]) && !set.contains(words2[index] + "#" + words1[index])) return false;
		}
		return true;
	}
}
