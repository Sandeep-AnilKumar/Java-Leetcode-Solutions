package Arrays;

public class LengthOfLongestIncreasingSubsequence {

	public static void main(String[] args) {
		LengthOfLongestIncreasingSubsequence lis = new LengthOfLongestIncreasingSubsequence();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println("the length of longest increasing subsequence is := " + lis.lengthOfLIS(nums));
	}

	public int binarySearch(int[] nums, int start, int end, int key) {
		if(start < 0 || end > nums.length) return -1;
		end = end - 1;
		int mid = 0;
		while(start <= end) {
			mid = start + ((end - start) >>> 1);
			if(nums[mid] == key) return mid;
			else if(nums[mid] < key) start = mid + 1;
			else end = mid - 1;
		}
		return -(start + 1);
	}

	public int lengthOfLIS(int[] nums) {
		int length = nums.length;
		int[] dp = new int[length];
		int len = 0;
		int index = 0;
		for(int i = 0; i < length; ++i) {
			index = binarySearch(dp, 0, len, nums[i]);

			if(index < 0) {
				index = -(index + 1);
			}

			dp[index] = nums[i];

			if(index == len) {
				len++;
			}
		}
		return len;
	}
}
