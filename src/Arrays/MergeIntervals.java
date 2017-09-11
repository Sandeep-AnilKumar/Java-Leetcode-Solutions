package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}

public class MergeIntervals {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>(4);
		intervals.add(new Interval(2,3));
		intervals.add(new Interval(2,2));
		intervals.add(new Interval(3,3));
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(5,7));
		intervals.add(new Interval(2,2));
		intervals.add(new Interval(4,6));
		System.out.println("Merged Intervals are := " + new MergeIntervals().mergeBetter(intervals));
	}

	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if(i1.start == i2.start) {
					return i1.end - i2.end;
				}
				return i1.start - i2.start;
			} 
		});

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		List<Interval> result = new ArrayList<>();
		for(int i = 1; i < intervals.size(); ++i) {
			if(intervals.get(i).start <= end) {
				end = Math.max(intervals.get(i).end, end);
			} else {
				result.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}

		result.add(new Interval(start, end));
		return result;
	}

	public List<Interval> mergeBetter(List<Interval> intervals) {
		List<Interval> merged = new ArrayList<>();
		if(intervals == null || intervals.size() == 0) return merged;

		PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if(i1.start < i2.start) {
					return -1;
				} else if(i1.start > i2.start) {
					return 1;
				} else {
					return i1.end - i2.end;
				}
			}
		});

		for(Interval i: intervals) {
			pq.offer(i);
		}

		Interval cur = null;
		Interval prev = null;

		while(!pq.isEmpty()) {
			cur = pq.poll();

			if(merged.size() == 0) {
				merged.add(new Interval(cur.start, cur.end));
			} else {
				prev = merged.get(merged.size() - 1);
				if(cur.start <= prev.end) {
					prev.end = Math.max(prev.end, cur.end);
				} else {
					merged.add(new Interval(cur.start, cur.end));
				}
			}
		}
		return merged;
	}
}
