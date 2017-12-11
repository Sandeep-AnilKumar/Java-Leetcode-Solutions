package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class MissingRanges2 {

	public static void main(String[] args) {
		int[] nums = {2147483647};
		int lower = 0;
		int upper = 2147483647;

		System.out.println("The missing ranges are := " + new MissingRanges2().findMissingRanges(nums, lower, upper));
	}

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> ranges = new ArrayList<>();
		int length = nums.length;
		long cur = lower;

		for(int i = 0; i < length; ++i) {
			if(cur == nums[i]) {
				cur++;
			} else {
				if(nums[i] == cur + 1) {
					ranges.add(String.valueOf(cur));
				} else if(nums[i] > cur){
					ranges.add(cur + "->" + String.valueOf((nums[i] - 1)));
				}

				cur = nums[i];
				cur++;
			}
		}

		if(cur < upper) {
			ranges.add(cur + "->" + upper);
		} else if(cur == upper){
			ranges.add(String.valueOf(cur));
		}

		return ranges;
	}
}
