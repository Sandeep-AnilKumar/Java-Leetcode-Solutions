package Arrays;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int[] nums = {1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1};
		System.out.println("Max consecutive ones with replacing one 0 is := " + findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int curMax = 0;
		int max = Integer.MIN_VALUE;
		int prevMax = 0;
		int length = nums.length;
		int temp = 0;

		for(int i = 0; i < length; ++i) {
			if(nums[i] == 1) {
				curMax++;
				prevMax++;
			} else {
				temp = prevMax;
				prevMax = 0;
				i++;
				while(i < length && nums[i] != 0) {
					prevMax++;
					i++;
				}
				curMax = Math.max(curMax, temp + prevMax + 1);
				max = Math.max(curMax, max);
				curMax = 0;
				--i;	
			}	
		}
		return curMax > max ? curMax : max;
	}
}
