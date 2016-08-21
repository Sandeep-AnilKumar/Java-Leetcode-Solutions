package Arrays;

public class ClimbingStairs {

	public static void main(String[] args) {
		int target = 4;
		System.out.println("Number of possible steps : " + climbStairs(target));
	}

	public static int climbStairs(int n) {
		if(n <= 0) {
			return 0;
		}

		int[] nums = new int[]{1,2};
		return combinationSum4(nums, n);
	}

	public static int combinationSum4(int[] nums, int target) {
		if(nums == null || nums.length == 0 || target < 0) {
			return 0;
		}
		//Arrays.sort(nums); //Not required, but can help in exit out of loop early.
		int[] combinations = new int[target + 1];
		combinations[0] = 1;
		int length = nums.length; // so that length is not calculated every time.
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < length; j++) {
				if(i - nums[j] < 0) {
					break;
				}
				if( i == nums[j]) {
					combinations[i] += 1;
				}
				else if (i - nums[j] >= 0) {
					combinations[i] += combinations[i - nums[j]];
				}
			}
		}
		return combinations[target];
	}
}
