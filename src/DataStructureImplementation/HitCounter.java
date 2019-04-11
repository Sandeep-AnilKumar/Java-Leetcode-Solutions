package DataStructureImplementation;

import java.util.TreeMap;

public class HitCounter {
	TreeMap<Integer, Integer> map;

	public HitCounter() {
		map = new TreeMap<>();
	}

	public void hit(int timestamp) {
		map.keySet().removeIf((key) -> (timestamp - 300 - key) >= 0);
		map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
	}

	public int getHits(int timestamp) {
		map.keySet().removeIf((key) -> (timestamp - 300 - key) >= 0);
		return map.values().stream().mapToInt(Integer::valueOf).sum();
	}
}
