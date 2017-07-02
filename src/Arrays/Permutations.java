package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4};
		List<List<Integer>> result = orderedPermute(nums);
		for(List<Integer> r : result) {
			System.out.print("[");
			for(int num : r) {
				System.out.print(num + " ");
			}
			System.out.println("]");
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return result;
		}

		permute(result, 0, new ArrayList<Integer>(), nums);
		return result;
	}

	public static void permute(List<List<Integer>> result, int position, List<Integer> permutation, int[] nums) {
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

	public static List<List<Integer>> iterativePermute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return result;
		}

		List<Integer> permutation = new ArrayList<Integer>();
		permutation.add(nums[0]);
		result.add(permutation);
		int length = nums.length;
		int curSize = 0;

		for(int i = 1; i < length; ++i) {
			curSize = result.size();
			for(int j = 0; j < curSize; ++j) {
				for(int k = 0; k < result.get(j).size(); ++k) {
					permutation = new ArrayList<Integer>(result.get(j));
					permutation.add(k, nums[i]);
					result.add(permutation);
				}
				result.get(j).add(nums[i]);
			}
		}
		return result;
	}

	public static List<List<Integer>> orderedPermute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		perm(result,nums,0,nums.length-1);
		return result;
	}

	public static void perm(List<List<Integer>> result, int[] nums, int start, int end){
		if(start==end){
			result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		}
		else{
			for(int i=start; i<=end; i++){
				swap(nums, start, i);
				perm(result, nums,start+1,end);
				swap(nums, start, i);
			}
		}
	}

	public static void swap(int[] nums, int start, int i) {
		if(start != i) {
			nums[start] = nums[start] ^ nums[i];
			nums[i] = nums[start] ^ nums[i];
			nums[start] = nums[start] ^ nums[i];
		}
	}
}
