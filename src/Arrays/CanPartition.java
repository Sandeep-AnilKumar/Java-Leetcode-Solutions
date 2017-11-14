package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class CanPartition {

	public static void main(String[] args) {
		int[] nums = {1,5,11,5,1,5,11,5,1,5,11,5,1,5,11,5,1,5,11,5,1,5,11,5,1,5,11,5,1,5,11,5,1,5,11,5};
		System.out.println("Can the nums be partitioned to two equal sun subsets := " + new CanPartition().canPartition(nums));
	}

	public boolean canPartition(int[] nums) {
		if(nums == null || nums.length == 0) return true;

		Arrays.sort(nums);
		int sum = 0;

		for(int n: nums) {
			sum += n;
		}

		if(sum % 2 != 0) return false;

		sum /= 2;

		int length = nums.length;
		int total = 1 << length;
		List<Integer> parts = new ArrayList<>();
		int count = 0, curSum = 0;

		for(int i = 0; i < total; ++i) {
			curSum = 0;
			count = 0;

			for(int j = 0; j < length; ++j) {
				if(((1 << j) & i) != 0) {
					count++;
					curSum += nums[j];
				}
			}
			if(curSum == sum) parts.add(count);
		}

		if(parts == null || parts.size() != 2 || parts.get(0) + parts.get(1) != length) return false;
		return true;
	}
}
