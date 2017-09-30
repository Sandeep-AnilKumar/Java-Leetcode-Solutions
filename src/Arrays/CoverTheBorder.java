package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sandeepa
 */

public class CoverTheBorder {

	public static void main(String[] args) {
		int l = 100;
		List<List<Integer>> radars = new ArrayList<>();
		radars.add(Arrays.asList(5, 10));
		radars.add(Arrays.asList(3, 25));
		radars.add(Arrays.asList(46, 99));
		radars.add(Arrays.asList(39, 40));
		radars.add(Arrays.asList(45, 50));

		System.out.println("The total border coverage is := " + border(l, radars));
	}

	public static int border(int l, List< List<Integer> > radars) {
		if(l <= 0 || radars == null || radars.size() == 0) return 0;

		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {

			if(a.get(0) != b.get(0)) {
				return a.get(0) - b.get(0);
			}
			return b.get(1) - a.get(1);
		});

		int coverage = 0;

		for(List<Integer> radar: radars) {
			pq.offer(radar);
		}

		List<Integer> prev = null;
		List<Integer> cur = null;

		while(!pq.isEmpty()) {
			cur = pq.poll();

			if(prev == null || cur.get(0) > prev.get(1)) {
				coverage += cur.get(1) - cur.get(0);
				prev = cur;
			} else if(cur.get(1) > prev.get(1)){
				coverage += cur.get(1) - prev.get(1);
				prev.set(1, cur.get(1));
			}
		}

		return coverage;
	}
}
