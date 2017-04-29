package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
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

	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		MeetingRooms m = new MeetingRooms();
		intervals[0] = m.new Interval(5,6);
		intervals[1] = m.new Interval(6,8);
		intervals[2] = m.new Interval(15,20);
		System.out.println("Can I attend all the meetings? := " + m.canAttendMeetingsBetter(intervals));
	}

	//Will fail for huge numbers.
	public boolean canAttendMeetings(Interval[] intervals) {
		if(intervals == null || intervals.length <= 1) {
			return true;
		}
		int[] blocked = new int[998119];

		for(Interval interval: intervals) {
			for(int time = interval.start; time < interval.end; ++time) {
				if(blocked[time] != 0) {
					return false;
				}
				blocked[time] = 1;
			}
		}
		return true;
	}


	public boolean canAttendMeetingsBetter(Interval[] intervals) {
		if(intervals == null || intervals.length <= 1) {
			return true;
		}

		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			} 
		});

		int length = intervals.length;
		for(int i = 1; i < length; ++i) {
			if(intervals[i].start < intervals[i-1].end) {
				return false;
			}
		}
		return true;
	}
}
