package DynamicProgramming;

public class MaximumSubArray {

	public static void main(String[] args) {
		int nums[] = new int[]{-1,2,3-4,5,-6,-10};
		int sum = maxSubArray(nums);
		System.out.println("The maximum subarray is: "+ sum);
	}

	public static int maxSubArray(int[] nums) {
		int sum = nums[0], max = sum;
		for(int i = 1; i< nums.length; i++)
		{
			max = Math.max(nums[i],nums[i]+max);
			sum = Math.max(sum,max);
		}
		return sum;
	}//O(1) space.

	//better understanding dp solution.
	public static int maxSubArray1(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int length = nums.length;
		int[] dp = new int[length];
		dp[0] = nums[0];
		int max = nums[0];
		for(int i = 1; i < length; ++i) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}//O(n) space.
}