package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4 {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,4};
		int target = 32;
		System.out.println(combinationSum41(nums, target));
	}

	public static int combinationSum4(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		List<Integer> curPath = new ArrayList<>();
		dfs(nums, target, curPath, 0, result);
		return result.size();
	}

	public static void dfs(int[] nums, int target, List<Integer> curPath, int start, List<List<Integer>> result) {
		if(target == 0) {
			if(!result.contains(curPath)) {
				result.add(new ArrayList<Integer>(curPath));
			}
			return;
		}
		if(target < 0) {
			return;
		}

		for(int i = start; i < nums.length; ++i) {
			curPath.add(nums[i]);
			dfs(nums, target - nums[i], curPath, 0, result);
			curPath.remove(curPath.size() - 1);
		}
	}//TLE version.

	//A better solution. Similar to Climbing stairs problem. But in that we have only two choices, 1 and 2. Here the choices are
	//numbers in the nums array.
	public static int combinationSum41(int[] nums, int target) {
		if(nums == null || nums.length == 0 || target < 0) {
			return 0;
		}
		Arrays.sort(nums); //Not required, but can help in exit out of loop early.
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