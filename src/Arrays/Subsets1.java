package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class Subsets1 {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println("The subsets are := " + new Subsets1().subsets(nums));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		if(nums == null || nums.length == 0) return subsets;

		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> inter = new ArrayList<>();
		subsets.add(new ArrayList<>());

		for(int n: nums) {
			inter = new ArrayList<>();
			for(List<Integer> set: subsets) {
				cur = new ArrayList<>(set);
				cur.add(n);
				inter.add(cur);
			}
			subsets.addAll(inter);
		}
		return subsets;
	}
}
