package Arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author sandeepa
 */

public class MyCalendar2 {
	Map<Integer, Integer> delta;

	public static void main(String[] args) {
		MyCalendar2 calendar = new MyCalendar2();
		System.out.println(calendar.book(10, 20));
		System.out.println(calendar.book(50, 60));
		System.out.println(calendar.book(10, 40));
		System.out.println(calendar.book(5, 15));
		System.out.println(calendar.book(5, 10));
		System.out.println(calendar.book(25, 55));
	}

	public MyCalendar2() {
		delta = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		delta.put(start, delta.getOrDefault(start, 0) + 1);
		delta.put(end, delta.getOrDefault(end, 0) - 1);

		int active = 0;
		for (int d: delta.values()) {
			active += d;
			if (active >= 3) {
				delta.put(start, delta.get(start) - 1);
				delta.put(end, delta.get(end) + 1);
				if (delta.get(start) == 0)
					delta.remove(start);
				return false;
			}
		}
		return true;
	}
}
