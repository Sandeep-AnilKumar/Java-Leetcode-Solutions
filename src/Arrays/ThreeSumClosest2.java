package Arrays;

import java.util.Arrays;

public class ThreeSumClosest2 {

	public static void main(String[] args) {
		ThreeSumClosest2 tsc2 = new ThreeSumClosest2();
		int[] nums = {0, 2, 1, -3};
		int target = 1;
		System.out.println("The closest sum is := " + tsc2.threeSumClosest(nums, target));
	}

	public int threeSumClosest(int[] nums, int target) {
		if(nums == null || nums.length <= 2) {
			return 0;
		}

		int length = nums.length;
		int cur = 0;
		int prev = 0;
		int result = 0;
		int min = Integer.MAX_VALUE;
		int j = 0;
		int k = 0;

		Arrays.sort(nums);

		for(int i = 0; i < length; ++i) {
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			prev = nums[i];
			j = i + 1;
			k = length - 1;

			while(j < k) {
				cur = nums[j] + nums[k];

				if(Math.abs((cur + prev) - target) < min) {
					min = Math.abs((cur + prev) - target);
					result = cur + prev;
				}

				j++;
				k--;
				while(j < k && nums[j] == nums[j - 1]) j++;
				while(k > j && nums[k] == nums[k + 1]) k--;

			}
		}
		return result;
	}
}
