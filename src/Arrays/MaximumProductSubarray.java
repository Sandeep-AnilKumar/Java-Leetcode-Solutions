package Arrays;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums = {1, 2, -2, 4, 2, 3, 1, -1 , -10, 5};
		System.out.println("The maximum product subarray is := " + maxProduct(nums));
	}

	public static int maxProductSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0], min = nums[0], result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);	
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			if (max > result) {
				result = max;
			}
		}
		return result;
	}

	public static int maxProduct(int[] A) {
		// edge case
		if (A == null || A.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int product = 1;
		// first go from start to end
		for (int i = 0; i < A.length; i++) {
			product *= A[i];
			if (product > max)
				max = product;
			if (product == 0)
				product = 1; // reset if encounter 0
		}

		// then go from end to start
		product = 1;
		for (int i = A.length - 1; i >= 0; i--) {
			product *= A[i];
			if (product > max)
				max = product;
			if (product == 0)
				product = 1; // reset if encounter 0
		}
		return max;
	}
}
