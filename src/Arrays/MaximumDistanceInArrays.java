package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {

	class Num {
		int max;
		int min;

		public Num(int min, int max) {
			this.max = max;
			this.min = min;
		}

		public String toString() {
			return "min := " + this.min + ", max := " + this.max; 
		}
	}

	public static void main(String[] args) {
		MaximumDistanceInArrays max = new MaximumDistanceInArrays();
		List<List<Integer>> arrays = new ArrayList<>();

		//Arrays: [[-10,-9,-9,-3,-1,-1,0],[4],[-5],[-8],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]] 

		arrays.add(Arrays.asList(-10,-9,-9,-3,-1,-1,0));
		arrays.add(Arrays.asList(-5));
		arrays.add(Arrays.asList(4));
		arrays.add(Arrays.asList(-8));
		arrays.add(Arrays.asList(-9,-6,-5,-4,-2,2,3));
		arrays.add(Arrays.asList(-3,-3,-2,-1,0));

		System.out.println("Maximum Difference is := " + max.maxDistance(arrays));
	}

	public int maxDistance(List<List<Integer>> arrays) {
		int length = arrays.size();
		Num[] nums = new Num[length];

		int index = 0;
		for(List<Integer> l: arrays) {
			nums[index++] = new Num(l.get(0), l.get(l.size() - 1));
		}

		int diff = 0;

		int min = nums[0].min;
		int max = nums[0].max;

		for(index = 1; index < length; ++index) {
			diff = Math.max(diff, Math.max(Math.abs(max - nums[index].min), Math.abs(nums[index].max - min)));
			min = Math.min(min, nums[index].min);
			max = Math.max(max, nums[index].max);
		}
		return diff;
	}
}
