package Arrays;

import java.util.PriorityQueue;

public class EraseOverlapIntervals {

	public static void main(String[] args) {
		EraseOverlapIntervals intervals = new EraseOverlapIntervals();
		Interval[] ints = new Interval[5];
		ints[0] = new Interval(0, 2);
		ints[1] = new Interval(1, 3);
		ints[2] = new Interval(2, 4);
		ints[3] = new Interval(3, 5);
		ints[4] = new Interval(4, 6);

		System.out.println("Number of intervals that should be removed in order to make it non-overlapping intervals is := " + intervals.eraseOverlapIntervals(ints));
	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return 0;

		PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

		for(Interval in: intervals) {
			pq.offer(in);
		}

		Interval prev = pq.poll();
		int count = 0;
		Interval cur = null;

		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(cur.start < prev.end) {
				count++;
				if(prev.end > cur.end) {
					prev.end = cur.end;
				}
			} else {
				prev.end = Math.max(prev.end, cur.end);
			}
		}
		return count;
	}
}
