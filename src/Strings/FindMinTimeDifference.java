package Strings;

import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class FindMinTimeDifference {

	public static void main(String[] args) {
		List<String> timePoints = Arrays.asList("23:59", "00:00");
		System.out.println("The minimum time difference is := " + new FindMinTimeDifference().findMinDifference(timePoints));
	}

	public int findMinDifference(List<String> timePoints) {
		if(timePoints == null || timePoints.size() == 0) return 0;

		int size = timePoints.size();
		int[] times = new int[size];
		int index = 0, hour = 0, min = 0;
		String[] parts;

		for(String time: timePoints) {
			parts = time.split(":");
			hour = Integer.parseInt(parts[0]);
			min = Integer.parseInt(parts[1]);
			times[index++] = hour * 60 + min;
		}

		Arrays.sort(times);

		int minDiff = Integer.MAX_VALUE;

		for(int i = 1; i < size; ++i) {
			minDiff = Math.min(minDiff, times[i] - times[i - 1]);
		}

		minDiff = Math.min(minDiff, 1440 + times[0] - times[size - 1]);
		return minDiff;
	}
}
