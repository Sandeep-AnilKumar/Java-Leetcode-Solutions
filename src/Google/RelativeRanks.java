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

	//A better version.
	public static String[] findRelativeRanksBetter(int[] nums) {
		int[][] pair = new int[nums.length][2];

		for (int i = 0; i < nums.length; i++) {
			pair[i][0] = nums[i];
			pair[i][1] = i;
		}

		Arrays.sort(pair, (a, b) -> (b[0] - a[0]));

		String[] result = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				result[pair[i][1]] = "Gold Medal";
			}
			else if (i == 1) {
				result[pair[i][1]] = "Silver Medal";
			}
			else if (i == 2) {
				result[pair[i][1]] = "Bronze Medal";
			}
			else {
				result[pair[i][1]] = (i + 1) + "";
			}
		}
		return result;
	}

	//Best version.
	public static String[] findRelativeRanksBest(int[] nums) {
		Integer[] index = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			index[i] = i;
		}

		Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

		String[] result = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				result[index[i]] = "Gold Medal";
			}
			else if (i == 1) {
				result[index[i]] = "Silver Medal";
			}
			else if (i == 2) {
				result[index[i]] = "Bronze Medal";
			}
			else {
				result[index[i]] = (i + 1) + "";
			}
		}
		return result;
	}
}
