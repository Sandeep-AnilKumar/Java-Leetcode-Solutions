package Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OnlineElection {

	Map<Integer, Integer> counts;
	TreeMap<Integer, Integer> v;

	public OnlineElection(int[] persons, int[] times) {
		counts = new HashMap<>();
		v = new TreeMap<>();

		int max = -1, curMax = 0, winner = 0;
		for (int i = 0; i < persons.length; ++i) {
			counts.put(persons[i], counts.getOrDefault(persons[i], 0) + 1);
			curMax = counts.get(persons[i]);

			if (max <= curMax) {
				max = curMax;
				winner = persons[i];
			}
			v.put(times[i], winner);
		}
	}

	public static void main(String[] args) {
		int[] persons = {4, 5, 5, 4, 5, 5, 4};
		int[] times = {0, 5, 10, 15, 20, 25, 30};
		OnlineElection onlineElection = new OnlineElection(persons, times);
		System.out.println(onlineElection.q(18));
	}

	public int q(int t) {
		return v.floorEntry(t).getValue();
	}
}
