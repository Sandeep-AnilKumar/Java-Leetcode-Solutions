package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ThreeSumSolution {

	public static void main(String[] args)
	{
		int[] nums = new int[]{-1,0,1,-5,6,4};
		List<List<Integer>> solution = threeSum(nums);
		System.out.println("The solution is: ");
		for(Iterator<List<Integer>> i = solution.iterator(); i.hasNext();)
		{
			List<Integer> j = i.next();
			System.out.print("[");
			for(Iterator<Integer> k = j.iterator(); k.hasNext();)
			{
				System.out.print(k.next() + ",");
			}
			System.out.println("],");
		}
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length < 3) return result;
		Arrays.sort(nums);

		int len = nums.length;
		for(int i = 0; i < len; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) continue;        // Skip same results
			int target = 0 - nums[i];
			int j = i + 1, k = len - 1;
			while(j < k) {
				if(nums[j] + nums[k] == target) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while(j < k && nums[j] == nums[j + 1]) j++;  // Skip same results
					while(j < k && nums[k] == nums[k - 1]) k--;  // Skip same results
					j++; k--;
				} else if(nums[j] + nums[k] < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}
}
