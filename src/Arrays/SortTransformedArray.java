package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class SortTransformedArray {

	public static void main(String[] args) {
		int[] nums = {-4, -2, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		int a = 1;
		int b = 3;
		int c = 5;
		System.out.println("The sorted tranformed array is := ");
		int[] result = new SortTransformedArray().sortTransformedArray(nums, a, b, c);
		for(int n : result) {
			System.out.print(n + ", ");
		}
	}

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		if(nums == null || nums.length == 0) {
			return nums;
		}

		int length = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int cur = 0;

		for(int i = 0; i < length; ++i) {
			cur = (int) (a * Math.pow(nums[i], 2)) + b * nums[i] + c;
			if(cur < min) {
				min = cur;
			}

			if(cur > max) {
				max = cur;
			}

			nums[i] = cur;
		}

		List<Integer>[] buckets = new List[max - min + 1];
		for(int i = 0; i < length; ++i) {
			if(buckets[nums[i] - min] == null) {
				buckets[nums[i] - min] = new ArrayList<>();
			}
			buckets[nums[i] - min].add(nums[i]);
		}

		int[] result = new int[length];
		int index = 0;
		for(int i = 0; i <= max - min; ++i) {
			if(buckets[i] != null) {
				for(int num : buckets[i]) {
					result[index++] = num;
				}
			}
		}

		return result;
	}
}
