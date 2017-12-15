package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class BinaryWatch2 {

	public static void main(String[] args) {
		int num = 2;
		System.out.println("The possible binary watch times are := " + new BinaryWatch2().readBinaryWatch(num));
	}

	public List<String> readBinaryWatch(int num) {
		List<String> times = new ArrayList<>();
		if(num == 0) {
			return times;
		}

		List<List<Integer>> parts = getParts(num);
		List<List<Integer>> hours = getBuckets(0, 11);
		List<List<Integer>> mins = getBuckets(0, 59);

		for(List<Integer> split : parts) {
			for(int hour : hours.get(split.get(0))) {
				for(int min : mins.get(split.get(1))) {
					if(min <= 9) {
						times.add(hour + ":0" + min);
					} else {
						times.add(hour + ":" + min);
					}
				}
			}
		}

		return times;
	}

	public List<List<Integer>> getParts(int num) {
		int start = 0;
		int end = num;
		List<List<Integer>> parts = new ArrayList<>();

		while(start <= end) {
			parts.add(Arrays.asList(start, end));
			if(start != end) {
				parts.add(Arrays.asList(end, start));
			}

			start++;
			end--;
		}

		return parts;
	}

	public List<List<Integer>> getBuckets(int start, int end) {
		List<List<Integer>> buckets = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();

		int count = 0;
		if(start == 0) {
			buckets.add(Arrays.asList(start));
			start++;
		}
		int cur = 0;
		for(int i = start; i <= end; ++i) {
			count = 0;
			cur = i;
			while(cur > 0) {
				count++;
				cur &= (cur - 1);
			}

			if(buckets.size() <= count) {
				bucket = new ArrayList<>();
				bucket.add(i);
				buckets.add(bucket);
			} else {
				buckets.get(count).add(i);
			}
		}

		return buckets;
	}
}
