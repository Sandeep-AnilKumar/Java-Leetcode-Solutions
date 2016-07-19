package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence1 {

	public static void main(String[] args) 
	{
		int []nums = new int[]{1,3,4,2,5,6,10,8,9};
		int size = lengthOfLIS(nums);
		System.out.println("The length of the longest increasing subsequence is :" + size);
	}
	public static int lengthOfLIS(int[] nums) 
	{            
		int[] dp = new int[nums.length];
		int len = 0;

		for(int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if(i < 0)
				i = -(i + 1);
			dp[i] = x;
			if(i == len) len++;
		}

		return len;
	}
}