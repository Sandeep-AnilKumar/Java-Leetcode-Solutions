package Arrays;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sandeepa
 */

public class MyCalendar1 {

	public static void main(String[] args) {
		MyCalendar1 myCalendar = new MyCalendar1();
		System.out.println(myCalendar.book(47, 50));
		System.out.println(myCalendar.book(33, 41));
		System.out.println(myCalendar.book(39, 45));
		System.out.println(myCalendar.book(33, 42));
		System.out.println(myCalendar.book(25, 32));
		System.out.println(myCalendar.book(26, 35));
		System.out.println(myCalendar.book(19, 25));
		System.out.println(myCalendar.book(3, 8));
		System.out.println(myCalendar.book(8, 13));
		System.out.println(myCalendar.book(18, 27));
	}

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return this.start + " - " + this.end;
		}
	}

	Set<Interval> intervals;
	public MyCalendar1() {
		intervals = new TreeSet<>(new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if(a.start == b.start) {
					return a.end - b.end;
				}
				return a.start - b.start;
			}
		});
	}

	public boolean book(int start, int end) {
		for(Interval interval: intervals) {
			if(end < interval.start) break;
			if(interval.start < end && start < interval.end) return false;
		}
		intervals.add(new Interval(start, end));
		return true;
	}
}
