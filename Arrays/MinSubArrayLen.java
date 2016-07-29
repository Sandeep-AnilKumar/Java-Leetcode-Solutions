package Arrays;

public class MinSubArrayLen {

	public static void main(String[] args) {
		int[] nums = new int[]{3,2,1,2,2,2,1,4,4,1,2,4,3};
		int s = 7;
		System.out.println("Minimum SubArray len is " + minSubArrayLen(nums, s));
	}

	public static int minSubArrayLen(int[] nums, int s) {
		if(nums == null || nums.length == 0 || s <= 0) {
			return 0;
		}

		int length = nums.length;
		int sum = 0;
		int start = 0;
		int max = Integer.MAX_VALUE;
		for(int i = 0; i < length; ++i) {
			sum += nums[i];
			if(sum >= s) {
				max = Math.min(max, i - start + 1);
			}
			while(sum > s && start <= i-1) {
				sum -= nums[start++];
				if(sum >= s) {
					max = Math.min(max, i - start + 1);
				}
			}
		}
		return max == Integer.MAX_VALUE ? 0 : max;
	}
}
