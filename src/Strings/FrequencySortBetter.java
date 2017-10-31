package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sandeepa
 */

public class FrequencySortBetter {

	public static void main(String[] args) {
		String s = "tree";
		System.out.println("The frequency sorted string is := " + new FrequencySortBetter().frequencySort(s));
	}

	static class Node {
		int count;
		char c;

		public Node() {
			this.count = 0;
		}

		public Node(char c) {
			this.c = c;
			this.count = 0;
		}

		@Override
		public String toString() {
			return this.c + "," + this.count;
		}
	}

	public String frequencySort(String s) {
		if(s == null || s.length() == 0) return s;

		int length = s.length();
		char c;
		Node[] count = new Node[256];

		for(int i = 0; i < 256; ++i) {
			count[i] = new Node();
		}

		for(int i = 0; i < length; ++i) {
			c = s.charAt(i);
			if(count[(int) c].count == 0) {
				count[(int) c] = new Node(c);
			}
			count[(int) c].count++;
		}

		Arrays.sort(count, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n2.count - n1.count;
			}
		});

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < 256; ++i) {
			if(count[i].count == 0) break;

			while(count[i].count > 0) {
				sb.append(count[i].c);
				count[i].count--;
			}
		}
		return sb.toString();
	}

	public String frequencySortBetter(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
				new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
						return b.getValue() - a.getValue();
					}
				});

		pq.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> e = pq.poll();
			for (int i = 0; i < (int)e.getValue(); i++) {
				sb.append(e.getKey());
			}
		}
		return sb.toString();
	}

	public String frequencySortBest(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		List<Character> [] bucket = new ArrayList[s.length() + 1];
		for (char key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >=0; pos--) {
			if (bucket[pos] != null) {
				for (char num : bucket[pos]) {
					for (int i = 0; i < map.get(num); i++) {
						sb.append(num);
					}
				}
			}
		}
		return sb.toString();
	}
}
