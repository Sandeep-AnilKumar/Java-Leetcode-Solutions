package Google;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = {1,1,0,0,1,1,0,0,0,1,1,1};
		System.out.println("The maximum number of consecutive ones in the array are := " + findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int length = nums.length;
		int max = Integer.MIN_VALUE;
		int count = 0;

		for(int i = 0; i < length; ++i) {
			if(nums[i] == 1) {
				count++;
			} else {
				max = Math.max(max, count);
				count = 0;
				while(i < length && nums[i] != 1) {
					i++;
				}
				--i;
			}
		}
		max = Math.max(max, count);
		return max;
	}
}