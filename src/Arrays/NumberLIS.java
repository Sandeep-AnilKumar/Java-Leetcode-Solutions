package Arrays;

/**
 * @author sandeepa
 */

public class NumberLIS {

	public static void main(String[] args) {
		int[] nums = {1,3,5,4,7};
		NumberLIS count = new NumberLIS();
		System.out.println("The number of LIS is := " + count.findNumberOfLIS(nums));
	}

	public int findNumberOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;

		int length = nums.length;
		Integer[][] dp = new Integer[length][length];
		int[] status = {1, 1};
		bfs(nums, dp, status, 0);
		return status[1];
	}

	public int bfs(int[] nums, Integer[][] dp, int[] status, int i) {
		if(i >= nums.length - 1) return 0;

		if(dp[i][i + 1] != null) return dp[i][i + 1];

		int count = 1;
		int maxCount = 1;
		int next = 0;

		for(int cur = i; cur < nums.length; ++cur) {
			next = cur + 1;
			for(; next < nums.length; ++next) {
				count = 1;
				if(nums[next] > nums[cur]) {
					count += bfs(nums, dp, status, next);
				}
				dp[cur][next] = count;

				if(dp[cur][next] == status[0]) {
					status[1]++;
				} else if(dp[cur][next] > status[0]) {
					status[0] = dp[cur][next];
					status[1] = 1;
				}
				maxCount = Math.max(maxCount, count);
			}
			next = cur;
			while(next < nums.length - 1 && nums[next] <= nums[next + 1]) {
				next++;
			}
			if(next == nums.length - 1) break;
			cur = next;
		}
		return maxCount;
	}
}