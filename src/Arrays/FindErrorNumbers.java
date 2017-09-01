package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindErrorNumbers {

	public static void main(String[] args) {
		int[] nums = {1,2,2,4};
		System.out.println("The mssing int and duplicated one is := " + new FindErrorNumbers().findErrorNums(nums));
	}

	public int[] findErrorNums(int[] nums) {
		int length = nums.length;
		int[] count = new int[length];
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < length; ++i) {
			if(count[nums[i] - 1] != 0) {
				result.add(nums[i]);
			}
			count[nums[i] - 1]++;
		}

		for(int i = 0; i < length; ++i) {
			if(count[i] == 0) {
				result.add(i + 1);
			}
		}
		int[] dupAndMissing = new int[result.size()];
		int index = 0;
		for(int i: result) {
			dupAndMissing[index++] = i;
		}
		return dupAndMissing;
	}
}
