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

	/*
	 * public static int longestIncreasingSubSequence(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int len = 0;
		int length = nums.length;
		int j = 0;
		int[] dp = new int[length];
		for(int i = 0; i < length; ++i) {
			j = binarySearch(dp, 0, len, nums[i]);
			if(j < 0) {
				j = -(j + 1);
			}

			dp[j] = nums[i];

			if(j == len) {
				len++;
			}
		}
		//sequence of numbers is in dp, till you encounter the first zero;
		return len;
	}

	public static int binarySearch(int[] array, int low, int high, int num) {
		if(low > high) {
			return -1;
		}

		high = high - 1;
		int mid = 0;
		while(low <= high) {
			mid = low + (high - low)/2;
			if(array[mid] == num) {
				return mid;
			}
			else if(array[mid] < num){
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return -(low + 1);
	}
	 * */
}