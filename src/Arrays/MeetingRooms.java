package Arrays;

import java.util.HashSet;
import java.util.Set;

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
	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		MeetingRooms m = new MeetingRooms();
		intervals[0] = m.new Interval(0, 30);
		intervals[1] = m.new Interval(5, 10);
		intervals[2] = m.new Interval(15,20);
		System.out.println("Can I attend all the meetings? := " + m.canAttendMeetings(intervals));
	}

	public boolean canAttendMeetings(Interval[] intervals) {
		if(intervals == null || intervals.length <= 1) {
			return true;
		}
		Set<Integer> blocked = new HashSet<>();

		for(Interval interval: intervals) {
			for(int time = interval.start; time < interval.end; ++time) {
				if(blocked.contains(time)) {
					return false;
				}
				blocked.add(time);
			}
		}
		return true;
	}
}
