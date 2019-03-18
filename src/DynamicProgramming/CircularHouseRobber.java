package DynamicProgramming;

/**
 * @author sandeepa
 */

public class CircularHouseRobber {

	public static void main(String[] args) {
		int[] nums = {7, 4, 5, 2, 1, 7};
		System.out.println("The maximum amount that canShip be robbed from circular houses are := " + new CircularHouseRobber().rob(nums));
	}

	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		if(nums.length == 1) {
			return nums[0];
		}

		int length = nums.length;
		int[] firstDp = new int[length];
		int[] lastDp = new int[length];
		firstDp[1] = nums[0];
		lastDp[1] = nums[1];

		for(int i = 2; i <= length - 1; ++i) {
			firstDp[i] = Math.max(firstDp[i - 1], nums[i - 1] + firstDp[i - 2]);
		}

		for(int i = 3; i <= length; ++i) {
			lastDp[i - 1] = Math.max(lastDp[i - 2], nums[i - 1] + lastDp[i - 3]);
		}

		return Math.max(firstDp[length - 1], lastDp[length - 1]);
	}
}
