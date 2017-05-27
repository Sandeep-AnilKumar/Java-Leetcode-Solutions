package Arrays;

import java.util.ArrayList;
import java.util.List;

public class GetPermutations {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		GetPermutations perms = new GetPermutations();
		System.out.println(perms.findPermutations(nums));
	}

	public List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return result;
		}

		permute(result, 0, new ArrayList<Integer>(), nums);
		return result;
	}

	public void permute(List<List<Integer>> result, int position, List<Integer> permutation, int[] nums) {
		if(permutation.size() == nums.length) {
			result.add(permutation);
			return;
		}

		for(int i = 0; i <= permutation.size(); ++i) {
			List<Integer> newPermutation = new ArrayList<>(permutation);
			newPermutation.add(i, nums[position]);
			permute(result, position + 1, newPermutation, nums);
		}
	}
}
