package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public static void main(String[] args) {
		int[] nums = {-2147483648,-2147483648,0,2147483647,2147483647};
		int lower = Integer.MIN_VALUE;
		int upper = Integer.MAX_VALUE;
		System.out.println("The missing ranges are := \n" + findMissingRanges(nums, lower, upper));
	}

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> ranges = new ArrayList<>();
		long cur = lower;
		int length = nums.length;

		for(int i = 0; i < length; ++i) {
			if(cur == nums[i] || (i > 0 && nums[i] == nums[i - 1])) {
				if(nums[i] == Integer.MAX_VALUE) {
					cur = 2147483648L;
				} else {
					cur = nums[i] + 1;
				}
				continue;
			}

			if(nums[i] == cur + 1) {
				ranges.add(String.valueOf(cur));
			} else {
				ranges.add(String.valueOf(cur) + "->" + String.valueOf(nums[i] - 1));
			}
			if(nums[i] == Integer.MAX_VALUE) {
				cur = 2147483648L;
			} else {
				cur = nums[i] + 1;
			}
		}

		if(cur == upper) {
			ranges.add(String.valueOf(cur));
		} else if(cur < upper){                                                         
			ranges.add(String.valueOf(cur) + "->" + String.valueOf(upper));
		}

		return ranges;
	}
}
