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
	}
}