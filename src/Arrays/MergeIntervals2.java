package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals2 {

	class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }

		@Override
		public String toString() {
			return "[" + this.start + ", " + this.end + "]"; 
		}
	}

	public static void main(String[] args) {
		MergeIntervals2 mi = new MergeIntervals2();
		Interval i1 = mi.new Interval(2, 3);
		Interval i2 = mi.new Interval(4, 5);
		Interval i3 = mi.new Interval(6, 7);
		Interval i4 = mi.new Interval(8, 9);
		Interval i5 = mi.new Interval(1, 10);
		List<Interval> l = new ArrayList<>();
		l.add(i1);
		l.add(i2);
		l.add(i3);
		l.add(i4);
		l.add(i5);
		System.out.println("The merged intervals are := ");
		l = mi.merge(l);
		for(Interval i: l) {
			System.out.print(i);
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> merge = new ArrayList<>();
		if(intervals == null || intervals.size() == 0) {
			return merge;
		}

		PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.size(), new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		for(Interval i: intervals) {
			pq.offer(i);
		}

		Interval cur = null;
		Interval prev = null;
		Interval temp = null;

		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(prev != null && cur.start <= prev.end) {
				if(merge != null && merge.size() > 0) {
					temp = merge.get(merge.size() - 1);
					temp.end = Math.max(temp.end, cur.end);
					prev = temp;
				}
			} else {
				merge.add(cur);
				prev = cur;
			}
		}
		return merge;
	}
}
