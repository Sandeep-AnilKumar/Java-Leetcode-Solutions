package Arrays;

public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
		int[] nums = {2, 3, 1, 2, 4, 3};
		System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, nums));
	}

	public int minSubArrayLen(int s, int[] nums) {
		int[] sums = new int[nums.length + 1];
		for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < sums.length; i++) {
			int end = binarySearch(i + 1, sums[i] + s, sums);
			if (end == sums.length) break;
			if (end - i < minLen) minLen = end - i;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	private int binarySearch(int lo, int key, int[] sums) {
		int hi = sums.length - 1, mid = 0;
		while (lo <= hi) {
			mid = lo + ((hi - lo) >>> 1);
			if (sums[mid] >= key) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
}
