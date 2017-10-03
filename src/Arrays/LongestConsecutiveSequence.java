package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sandeepa
 */

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = {100, 200, 1, 4, 3, 2};
		System.out.println("The number of consecutive elements are := " + new LongestConsecutiveSequence().longestConsecutive(nums));
	}

	public int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0) return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int left = 0, right = 0, sum = 0, max = 0;

		for(int n: nums) {
			if(!map.containsKey(n)) {
				left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
				right = map.containsKey(n + 1) ? map.get(n + 1) : 0;

				sum = 1 + left + right;
				max = Math.max(sum, max);

				map.put(n, sum);
				map.put(n + right, sum);
				map.put(n - left, sum);
			}
		}
		return max;
	}
}
