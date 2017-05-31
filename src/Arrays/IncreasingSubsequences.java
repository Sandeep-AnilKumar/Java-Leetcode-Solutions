package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {

	public static void main(String[] args) {
		int[] nums = {4, 6, 7, 7, 5, 12, 14, 15};
		System.out.println("The increasing subsequences are := ");
		IncreasingSubsequences is = new IncreasingSubsequences();
		List<List<Integer>> result = is.findSubsequences(nums);
		System.out.println(result);
	}


	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> sub = new HashSet<>();
		subsequences(nums, sub, new ArrayList<>(), 0);
		List<List<Integer>> res = new ArrayList<>(sub);
		return res;
	}

	public void subsequences(int[] nums, Set<List<Integer>> sub, List<Integer> cur, int index) {
		if(cur.size() >= 2) {
			sub.add(new ArrayList<>(cur));
		}

		for(int j = index; j < nums.length; ++j) {
			if(cur == null || cur.size() == 0 || cur.get(cur.size() - 1) <= nums[j]) {
				cur.add(nums[j]);
				subsequences(nums, sub, cur, j + 1);
				cur.remove(cur.size() - 1);
			}
		}
	}
}
