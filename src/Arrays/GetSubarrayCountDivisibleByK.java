package Arrays;

public class GetSubarrayCountDivisibleByK {

	public static void main(String[] args) {
		int[] nums = new int[]{4, 5, 0, -2, -3, 1};
		int k = 5;
		System.out.println("Total subarrays divisible by k are: " + getSubArraysCount(nums, k));
	}

	/*
	 * Solution: -
	 *  {4, 5, 0, -2, -3, 1}
		{5}
		{5, 0}
		{5, 0, -2, -3}
		{0}
		{0, -2, -3}
		{-2, -3}
	 * 
	 * */

	private static int getSubArraysCount(int[] nums, int K) {
		int length = nums.length;
		int[] tempArray = new int[K];
		tempArray[0]++;
		int s = 0;
		for (int i = 0; i < length; i++) {
			s = (s + nums[i]) % K;
			while (s < 0) {
				s += K;
			}
			tempArray[s]++;
		}
		int ans = 0;
		for (int i = 0; i <= K - 1; i++) {
			ans += tempArray[i] * (tempArray[i] - 1) / 2;
		}
		return ans;
	}
}
