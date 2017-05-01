package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {

	public static void main(String[] args) {
		int nums[] = {1,3,2,1,5,6,8};
		int k = 2;
		System.out.println("Total number of K-diff pairs with k := " + k + " is := " + findPairsBetter(nums, k));
	}

	public static int findPairs(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k < 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;

		for(int i: nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for(int j: map.keySet()) {
			if(k == 0) {
				if(map.get(j) >= 2) {
					count++;
				}
			} else {
				if(map.containsKey(j + k)) {
					count++;
				}
			}
		}
		return count;
	}

	public static int findPairsBetter(int[] nums, int k) {
		if (k < 0) {
			return 0;
		}
		Arrays.sort(nums);
		int res = 0;
		int i = 0, j = 1;
		while (j < nums.length) {
			if (i >= j || nums[j] - nums[i] < k) {
				j++;
			} else if (nums[j] - nums[i] > k) {
				i++;
			} else {
				res++;
				i++;
				j++;
				while (i < nums.length && nums[i] == nums[i - 1]) {
					i++;
				}
			}
		}
		return res;
	}
}
