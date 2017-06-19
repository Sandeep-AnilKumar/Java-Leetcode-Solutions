package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum2 {

	public static void main(String[] args) {
		ThreeSum2 ts = new ThreeSum2();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> triplets = ts.threeSum(nums);
		System.out.println(triplets);
	}


	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if(nums == null || nums.length <= 2) {
			return list;
		}

		Arrays.sort(nums);
		int length = nums.length;

		int cur = 0;
		int prev = 0;
		int j = 0;
		int k = 0;

		for(int i = 0; i + 2 < length; ++i) {
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			prev = nums[i];
			j = i + 1;
			k = length - 1;
			while(j < k) {
				cur = nums[j] + nums[k];
				if(cur == -prev) {
					list.add(Arrays.asList(prev, nums[j], nums[k]));
					j++;
					while(j < k && nums[j] == nums[j - 1]) {
						j++;
					}
					k--;
					while(k > j && nums[k] == nums[k + 1]) {
						k--;
					}
					continue;
				}

				if(cur > -prev) {
					k--;
				} else if(cur < -prev) {
					j++;
				}
			}
		}
		return list;
	}
}
