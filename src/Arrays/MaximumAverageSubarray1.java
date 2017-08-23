package Arrays;

public class MaximumAverageSubarray1 {

	public static void main(String[] args) {

		MaximumAverageSubarray1 max = new MaximumAverageSubarray1();
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		System.out.println("The maximum average subarray of length := " + k + " is := " + max.findMaxAverage(nums, k));
	}

	public double findMaxAverage(int[] nums, int k) {
		double sum = 0;
		for(int i = 0; i < k; ++i) {
			sum += nums[i];
		}

		double maxSum = sum;
		int length = nums.length;
		for(int i = k; i < length; ++i) {
			sum = sum - nums[i - k] + nums[i];
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum/k;
	}
}
