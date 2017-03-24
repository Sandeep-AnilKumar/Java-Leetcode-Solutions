package Google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {

	public static void main(String[] args) {
		int[] nums = {5,4,3,2,1};
		String[] result = findRelativeRanks(nums);
		for(String s : result) {
			System.out.println(s + " , ");
		}
	}

	public static String[] findRelativeRanks(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new String[0];
		}

		Map<Integer, Integer> indexMap = new HashMap<>();
		int i = 0;
		for(int n : nums) {
			indexMap.put(n, i++);
		}

		Arrays.sort(nums);
		String[] result = new String[nums.length];

		int length = nums.length;
		for(int j = length - 1; j >= 0; --j) {
			if(j == length - 1) {
				result[indexMap.get(nums[j])] = "Gold Medal";
			} else if(j == length - 2) {
				result[indexMap.get(nums[j])] = "Silver Medal";
			} else if(j == length - 3) {
				result[indexMap.get(nums[j])] = "Bronze Medal";
			} else {
				result[indexMap.get(nums[j])] = String.valueOf(length - j);
			}
		}
		return result;	
	}
}
