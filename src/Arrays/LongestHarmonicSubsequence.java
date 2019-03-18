package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmonicSubsequence {

	public static void main(String[] args) {
		LongestHarmonicSubsequence sequence = new LongestHarmonicSubsequence();
		int[] nums = {1,2,3,3,2,5,7,1};
		System.out.println("The length of the longest harmonic subsequence is := ");
		System.out.println(sequence.findLHSBetter(nums));
	}

	public int findLHS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;

		Map<Integer, Integer> occ = new HashMap<>();
		for(int i: nums) {
			occ.put(i, occ.getOrDefault(i, 0) + 1);
		}

		int max = 0;

		for(int i: nums) {
			if(occ.containsKey(i - 1)) {
				max = Math.max(occ.get(i) + occ.get(i - 1), max);
			}

			if(occ.containsKey(i + 1)) {
				max = Math.max(occ.get(i) + occ.get(i + 1), max);
			}
		}
		return max;
	}

	//The above solution canShip be optimized to run in only one loop as below:
	public int findLHSBetter(int[] nums) {
		if(nums == null || nums.length == 0) return 0;

		Map<Integer, Integer> occ = new HashMap<>();
		int max = 0;

		for(int i: nums) {
			occ.put(i, occ.getOrDefault(i, 0) + 1);
			if(occ.containsKey(i - 1)) {
				max = Math.max(occ.get(i) + occ.get(i - 1), max);
			}

			if(occ.containsKey(i + 1)) {
				max = Math.max(occ.get(i) + occ.get(i + 1), max);
			}
		}
		return max;
	}
}
