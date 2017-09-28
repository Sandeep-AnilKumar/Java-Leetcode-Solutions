package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sandeepa
 */

public class LeastTaskInterval {

	public static void main(String[] args) {
		char[] tasks = {'A', 'B', 'A', 'B', 'A', 'B', 'A'};
		int n = 2;

		System.out.println("The least task interval required is := " + new LeastTaskInterval().leastInterval(tasks, n));
	}

	private static class charCounts {
		char c;
		int count;

		public charCounts(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}

	public int leastInterval(char[] tasks, int n) {
		if(tasks == null || tasks.length == 0) return 0;

		int[] counts = new int[26];

		for(char c: tasks) {
			counts[c - 'A']++;
		}

		PriorityQueue<charCounts> pq = new PriorityQueue<>((a, b) -> (b.count - a.count));

		for(int i = 0; i < 26; ++i) {
			if(counts[i] != 0) {
				pq.offer(new charCounts((char)('A' + i), counts[i]));
			}
		}

		List<charCounts> cur = new ArrayList<>();
		charCounts temp = null;
		List<Character> order = new ArrayList<>();
		int interval = 0;
		int idle = 0;

		while(!pq.isEmpty()) {
			interval += idle;

			while(idle-- > 0) {
				order.add('_');
			}

			idle = 0;

			cur = new ArrayList<>();
			for(int i = 0; i <= n; ++i) {
				if(!pq.isEmpty()) {
					temp = pq.poll();
					interval++;

					order.add(temp.c);
					cur.add(temp);
				} else {
					idle++;
				}
			}

			for(charCounts prev: cur) {
				if(--prev.count > 0) {
					pq.offer(prev);
				}
			}
		}

		System.out.println("The order is := " + order);
		return interval;
	}
}