package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TimePairs {
	public static void main(String[] args) {
		TimePairs timePairs = new TimePairs();
		int[] time = {15, 63, 451, 213, 37, 209, 343, 319};
		System.out.println("Total pairs := " + timePairs.numPairsDivisibleBy60(time));
	}

	public int numPairsDivisibleBy60(int[] time) {
		Arrays.sort(time);
		Map<Integer, Integer> map = new HashMap<>();
		int key = 0, total = 0;
		for (int t : time) {
			key = 60 - (t % 60);
			if (map.containsKey(key)) {
				total += map.get(key);
			}
			if (t % 60 == 0) {
				map.put(60, map.getOrDefault(60, 0) + 1);
			} else {
				map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
			}
		}
		return total;
	}
}
