package Arrays;

public class CountOfLIS {

	public static void main(String[] args) {
		CountOfLIS count = new CountOfLIS();
		int[] nums = {1,3,5,4,7};
		System.out.println("the count of longest increasing subsequence is := " + count.findNumberOfLIS(nums));
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

	public int findNumberOfLIS(int[] nums) {
		int length = nums.length;
		int[] dp = new int[length];
		int len = 0;
		int index = 0;
		int count = 0;
		for(int i = 0; i < length; ++i) {
			index = binarySearch(dp, 0, len, nums[i]);

			if(index < 0) {
				index = -(index + 1);
			}

			dp[index] = nums[i];

			if(index == len - 1) {
				count++;
			}

			if(index == len) {
				count = 0;
				len++;
			}
		}
		return count;
	}
}
