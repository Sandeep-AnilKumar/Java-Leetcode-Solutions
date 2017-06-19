package Arrays;

import java.util.Arrays;

public class Combination4 {
	int max = 0;

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int target = 32;

		Combination4 c4 = new Combination4();
		int totalCombinations = c4.combinationSum4(nums, target);
		System.out.println("The total combinations are := " + totalCombinations);
	}

	public int combinationSum4(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		combine(nums, target, 0);
		return max;
	}

	public void combine(int[] nums, int target, int sum) {
		if(sum == target) {
			max++;
			return;
		}

		if(sum > target) {
			return;
		}

		for(int i = 0; i < nums.length; ++i) {
			combine(nums, target, sum + nums[i]);
		}
		return;
	}
}
