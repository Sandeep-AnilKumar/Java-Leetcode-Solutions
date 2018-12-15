package DynamicProgramming;

public class PredictWinner {
	public static void main(String[] args) {
		PredictWinner predictWinner = new PredictWinner();
		int[] nums = {1, 2, 99};
		System.out.println("Is player 1 the winner := " + predictWinner.PredictTheWinnerMemo(nums));
	}

	public boolean PredictTheWinner(int[] nums) {
		return helper(nums, 0, nums.length - 1, 0, 0, 0);
	}

	private boolean helper(int[] nums, int i, int j, int turn, int sum1, int sum2) {
		if (i < 0 || i >= nums.length || j < 0 || j >= nums.length || i > j) return false;
		if (i == j) {
			if (turn == 0) {
				sum1 += nums[i];
			} else {
				sum2 += nums[i];
			}
			return sum1 >= sum2;
		}

		if (turn == 0) {
			return helper(nums, i + 1, j, turn ^ 1, sum1 + nums[i], sum2) ||
					helper(nums, i, j - 1, turn ^ 1, sum1 + nums[j], sum2);
		} else {
			return helper(nums, i + 1, j, turn ^ 1, sum1, sum2 + nums[i]) &&
					helper(nums, i, j - 1, turn ^ 1, sum1, sum2 + nums[j]);
		}
	}

	//Memoized
	public boolean PredictTheWinnerMemo(int[] nums) {
		Integer[][] memo = new Integer[nums.length][nums.length];
		return helper(nums, memo, 0, nums.length - 1) >= 0;
	}

	private int helper(int[] nums, Integer[][] memo, int i, int j) {
		if (i < 0 || j < 0 || i >= nums.length || j >= nums.length) return 0;
		if (memo[i][j] != null) return memo[i][j];
		if (i == j) {
			memo[i][j] = nums[i];
			return memo[i][j];
		}

		int left = nums[i] - helper(nums, memo, i + 1, j);
		int right = nums[j] - helper(nums, memo, i, j - 1);
		memo[i][j] = Math.max(left, right);
		return memo[i][j];
	}
}
