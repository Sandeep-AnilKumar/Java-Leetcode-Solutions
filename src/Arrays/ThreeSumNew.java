package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class ThreeSumNew {

	public static void main(String[] args) {
		int[] nums = {-1, 0, -1, 2, 1, 4};
		System.out.println("The different triplets are := " + new ThreeSumNew().threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> triplets = new ArrayList<>();

		if (nums == null || nums.length == 0) return triplets;

		int length = nums.length;
		Arrays.sort(nums);

		int j = 0;
		int k = 0;
		int cur = 0;

		for (int i = 0; i < length - 2; ++i) {
			j = i + 1;
			k = length - 1;

			while (j < k) {
				cur = nums[j] + nums[k];
				if (cur == -nums[i]) {
					triplets.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
					j++; k--;
					while (j < length && nums[j] == nums[j - 1]) j++;
					while (k >= 0 && nums[k] == nums[k + 1]) k--;
				} else if (nums[j] + nums[k] > -nums[i]) {
					--k;
				} else {
					++j;
				}
			}

			++i;
			while (i < length && nums[i] == nums[i - 1]) ++i;
			--i;
		}
		return triplets;
	}
}
