package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Arrays.MeetingRooms.Interval;

public class MergeIntervals {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>(4);
		MeetingRooms m = new MeetingRooms();
		intervals.add(m.new Interval(8,10));
		intervals.add(m.new Interval(1,3));
		intervals.add(m.new Interval(2,6));
		intervals.add(m.new Interval(15,18));
		System.out.println("Merged Intervals are := " + new MergeIntervals().merge(intervals));
	}

	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			} 
		});

		PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.size(), new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.end - i2.end;
			} 
		});

		heap.offer(intervals.get(0));
		for(int i = 1; i < intervals.size(); ++i) {
			Interval interval = heap.poll();
			if(intervals.get(i).start < interval.end) {
				interval.end = intervals.get(i).end;
			} else {
				heap.offer(intervals.get(i));
			}
			heap.offer(interval);
		}

		List<Interval> result = new ArrayList<>(heap.size());
		while(heap.size() > 0) {
			result.add(heap.poll());
		}
		return result;
	}
}
