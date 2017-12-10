package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sandeepa
 */

public class NetworkDelayTime {

	public static void main(String[] args) {
		int[][] times = {{1,2,1},{2,3,7},{1,3,4},{2,1,2}};
		int N = 3;
		int K = 2;

		System.out.println("The total network delay time is := " + new NetworkDelayTime().networkDelayTime(times, N, K));
	}

	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		Deque<Integer> dq = new ArrayDeque<>();
		Map<String, Integer> w = new HashMap<>();
		List<Integer> cur = new ArrayList<>();
		int[] dur = new int[N + 1];

		Arrays.fill(dur, Integer.MAX_VALUE);

		dur[K] = 0;
		int max = 0;
		int node = 0;
		int temp = 0;

		for(int[] time : times) {
			cur = new ArrayList<>();

			if(adj.containsKey(time[0])) {
				cur = adj.get(time[0]);
			}

			cur.add(time[1]);
			adj.put(time[0], cur);

			w.put(time[0] + "," + time[1], time[2]);
		}

		dq.offer(K);

		while(!dq.isEmpty()) {
			node = dq.poll();
			temp = dur[node];
			cur = adj.get(node);

			if(cur != null && cur.size() > 0) {
				for(int next : cur) {
					if(dur[next] > w.get(node + "," + next) + temp) {
						dur[next] = w.get(node + "," + next) + temp;
						dq.offer(next);
					}
				}
			}
		}

		for(int i = 1; i <= N; ++i) {
			if(dur[i] == Integer.MAX_VALUE) {
				return -1;
			}

			max = Math.max(max, dur[i]);
		}

		return max;
	}
}
