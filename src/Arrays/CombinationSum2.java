package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
		int target = 8;

		List<List<Integer>> subset = subsets1(nums,target);
		System.out.println("The combination sums are: \n[");
		for(Iterator<List<Integer>> i = subset.iterator(); i.hasNext();)
		{
			System.out.print("[");
			List<Integer> j = i.next();
			for(Iterator<Integer> k = j.iterator(); k.hasNext();)
				System.out.print(k.next() + " ");
			System.out.println("]");
		}
		System.out.println("]");
	}

	public static List<List<Integer>> subsets(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int length = nums.length;
		List<Integer> sub = new ArrayList<>();
		result.add(sub);
		int begin = 0;
		int count = 0;
		List<List<Integer>> comboResult = new ArrayList<>();

		for(int i = 0; i < length; ++i) {
			count = 0;
			int size = result.size();
			if(i == 0 || nums[i] != nums[i-1]) {
				begin = 0;
			}
			for(int j = begin; j < size; ++j) {
				List<Integer> prev = new ArrayList<>(result.get(j));
				prev.add(nums[i]);
				result.add(prev);
				count = 0;
				for(int num : prev) {
					count += num;
					if(count > target) {
						break;
					}
				}
				if(count == target) {
					if(!comboResult.contains(prev)) {
						comboResult.add(prev);
					}
				}
			}
			begin = size;
		}
		return comboResult;
	}// TLE Version.

	//Better one.

	public static List<List<Integer>> subsets1(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		List<Integer> curPath = new ArrayList<>();
		dfs(nums, target, curPath, 0, result);
		return result;
	}

	public static void dfs(int[] nums, int target, List<Integer> curPath, int start, List<List<Integer>> result) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(curPath));
			return;
		}
		if(target < 0) {
			return;
		}

		for(int i = start; i < nums.length; ++i) {
			if (i > start && nums[i] == nums[i-1]) {
				continue;
			}
			curPath.add(nums[i]);
			dfs(nums, target - nums[i], curPath, i+1, result);
			curPath.remove(curPath.size() - 1);
		}
	}
}
