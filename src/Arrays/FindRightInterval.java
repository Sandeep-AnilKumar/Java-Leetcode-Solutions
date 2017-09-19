package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {

	public static void main(String[] args) {
		Interval[] intervals = new Interval[7];
		intervals[0] = new Interval(1, 7);
		intervals[1] = new Interval(8, 12);
		intervals[2] = new Interval(6, 7);
		intervals[3] = new Interval(4, 6);
		intervals[4] = new Interval(9, 11);
		intervals[5] = new Interval(10, 20);
		intervals[6] = new Interval(12, 19);

		FindRightInterval interval = new FindRightInterval();

		System.out.println("The right intervals are := ");
		int[] right = interval.findRightInterval(intervals);
		for(int r: right) {
			System.out.print(r + ", ");
		}
	}

	public int[] findRightInterval(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return new int[0];

		int length = intervals.length;
		int[] starts = new int[length];
		int[] right = new int[length];
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < length; ++i) {
			starts[i] = intervals[i].start;
			map.put(intervals[i].start, i);
		}

		Arrays.sort(starts);
		int index = 0;
		for(int i = 0; i < length; ++i) {
			index = findStart(starts, intervals[i].end);

			right[i] = index == length || intervals[i].end > starts[index] ? -1 : map.get(starts[index]);
		}

		return right;
	}

	public int findStart(int[] starts, int start) {
		int low = 0;
		int high = starts.length - 1;
		int mid = 0;

		while(low < high) {
			mid = low + ((high - low) >>> 1);

			if(starts[mid] == start) return mid;
			else if(starts[mid] < start) low = mid + 1;
			else high = mid;
		}
		return low;
	}
}
