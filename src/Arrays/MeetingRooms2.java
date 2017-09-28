package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sandeepa
 */

public class MeetingRooms2 {

	public static void main(String[] args) {
		Interval[] intervals = new Interval[6];
		intervals[0] = new Interval(1293,2986);
		intervals[1] = new Interval(848,3846);
		intervals[2] = new Interval(4284,5907);
		intervals[3] = new Interval(4466,4781);
		intervals[4] = new Interval(518,2918);
		intervals[5] = new Interval(300,5870);

		System.out.println("The number of meeting rooms required is := " + new MeetingRooms2().minMeetingRooms(intervals));
	}

	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return 0;

		PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.start - b.start));

		for(Interval interval: intervals) {
			pq.offer(interval);
		}

		List<Interval> rooms = new ArrayList<>();
		Interval cur = null;
		boolean found = false;

		while(!pq.isEmpty()) {
			cur = pq.poll();
			found = false;

			for(Interval interval: rooms) {
				if(interval.end <= cur.start) {
					interval.start = cur.start;
					interval.end = cur.end;
					found = true;
					break;
				}
			}

			if(!found) {
				rooms.add(cur);
			}
		}
		return rooms.size();
	}
}
