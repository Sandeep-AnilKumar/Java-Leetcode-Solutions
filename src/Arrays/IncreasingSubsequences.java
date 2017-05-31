package Arrays;

import java.util.ArrayList;
import java.util.Collections;
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

	//A faster solution.
	public List<List<Integer>> findSubsequencesBetter(int[] nums) {
		ArrayList<Integer> indices = new ArrayList<>();
		List<List<List<Integer>>> values = new ArrayList<>();

		for (int num : nums) {
			int index = Collections.binarySearch(indices, num);
			List<Integer> solo = new ArrayList<>();
			solo.add(num);

			if (index < 0) {
				index = -(index + 1);
				List<List<Integer>> next = new ArrayList<>();
				next.add(solo);
				values.add(index, next);
				indices.add(index, num);
			} else {
				for (List<Integer> list : values.get(index)) {
					list.add(num);
				}
				values.get(index).add(solo);
			}

			for (int i = index - 1; i >= 0; i--) {
				for (List<Integer> list : values.get(i)) {
					List<Integer> next = new ArrayList<>(list);
					next.add(num);
					values.get(index).add(next);
				}
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		for (List<List<Integer>> list : values) {
			for (List<Integer> tmp : list) {
				if (tmp.size() > 1) result.add(tmp);
			}
		}
		return result;
	}
}
