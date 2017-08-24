package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		TaskScheduler task = new TaskScheduler();
		char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		int n = 2;
		System.out.println("Least Interval to schedule all tasks is := " + task.leastInterval(tasks, n));
	}

	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> counts = new HashMap<Character, Integer>();
		for (char t : tasks) {
			counts.put(t, counts.getOrDefault(t, 0) + 1);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
		pq.addAll(counts.values());

		int alltime = 0;
		int cycle = n + 1;
		while (!pq.isEmpty()) {
			int worktime = 0;
			List<Integer> tmp = new ArrayList<Integer>();
			for (int i = 0; i < cycle; i++) {
				if (!pq.isEmpty()) {
					tmp.add(pq.poll());
					worktime++;
				}
			}
			for (int cnt : tmp) {
				if (--cnt > 0) {
					pq.offer(cnt);
				}
			}
			alltime += !pq.isEmpty() ? cycle : worktime;
		}
		return alltime;
	}

	public int leastIntervalBetter(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c: tasks)
			map[c - 'A']++;
		Arrays.sort(map);
		int max_val = map[25] - 1, idle_slots = max_val * n;
		for (int i = 24; i >= 0 && map[i] > 0; i--) {
			idle_slots -= Math.min(map[i], max_val);
		}
		return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
	}
}
