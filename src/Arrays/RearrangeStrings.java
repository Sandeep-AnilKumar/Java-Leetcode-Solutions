package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStrings {

	public static void main(String[] args) {
		RearrangeStrings rs = new RearrangeStrings();
		String s = "aaabc";
		int k = 3;
		System.out.println("The rearranged string is := " + rs.rearrangeString(s, k));
	}

	public String rearrangeString(String s, int k) {
		if(k <= 1) return s;

		Map<Character, Integer> map = new HashMap<>();
		for(char c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue() == 0 ? e1.getKey() - e2.getKey() : e2.getValue() - e1.getValue());

		pq.addAll(map.entrySet());
		int dist = k;
		StringBuffer sb = new StringBuffer();
		Map.Entry<Character, Integer> e;
		while(!pq.isEmpty()) {
			dist = k;
			List<Map.Entry<Character, Integer>> list = new ArrayList<>();
			for(int i = 0; i < dist; ++i) {
				if(!pq.isEmpty()) {
					e = pq.poll();
					list.add(e);

					if(e.getValue() == 1) {
						map.remove(e.getKey());
					} else {
						e.setValue(e.getValue() - 1);
					}

				} else if(!map.isEmpty()) {
					return "";
				}
			}

			for(Map.Entry<Character, Integer> entry: list) {
				sb.append(entry.getKey());
				if(map.containsKey(entry.getKey()) && entry.getValue() >= 1) {
					pq.add(entry);
				}
			}
		}
		return sb.toString();
	}
}
