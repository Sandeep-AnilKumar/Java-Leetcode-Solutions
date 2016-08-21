package Arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicates {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,1};
		int k = 2;
		System.out.println("Arrays contains nearby duplicates? " + containsNearbyDuplicate(nums, k));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		Set<Integer> numSet = new HashSet<>();
		int length = nums.length;

		for(int i = 0; i < length; ++i) {
			if(i > k) {
				numSet.remove(nums[i-k-1]);
			}
			if(!numSet.add(nums[i])) {
				return true;
			}
		}
		return false;
	}
}
