package Arrays;

import java.util.Arrays;
import java.util.Comparator;

import Arrays.MeetingRooms.Interval;

public class MinimumMeetingRooms {

	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		MeetingRooms m = new MeetingRooms();
		intervals[0] = m.new Interval(5,6);
		intervals[1] = m.new Interval(6,8);
		intervals[2] = m.new Interval(8,9);
		System.out.println("Minimum number of rooms to attend all the meetings? := " + new MinimumMeetingRooms().minMeetingRooms(intervals));
	}
	//Will not work for all cases.
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) {
			return 0;
		}

		int rooms = 1;
		int length = intervals.length;

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if(i1.end == i2.end) {
					return i2.start - i1.start;
				}
				return i1.end - i2.end;
			} 
		});

		for(Interval interval: intervals) {
			System.out.println(interval.toString());
		}

		for(int i = 1; i < length; ++i) {
			if(intervals[i].start < intervals[i - 1].end) {
				rooms += 1;
			}
		}
		return rooms;
	}
}
