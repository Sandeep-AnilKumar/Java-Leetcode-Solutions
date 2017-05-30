package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 4, 5, 7, 9, 10, 11, 12, 13, 14, 17, 21, 24};
		System.out.println(summaryRanges(nums));
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> ranges = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return ranges;
		}

		int start = nums[0];
		int next = start + 1;

		for(int i = 1; i < nums.length; ++i) {
			if(next != nums[i]) {
				if(start + 1 != next) {
					ranges.add(String.valueOf(start) + "->" + String.valueOf(next - 1));
				} else {
					ranges.add(String.valueOf(start));
				}
				start = nums[i];
			}
			next = nums[i] + 1;
		}

		if(start == nums[nums.length - 1]) {
			ranges.add(String.valueOf(start));
		} else if(next != start + 1){
			ranges.add(String.valueOf(start) + "->" + String.valueOf(next - 1));
		}
		return ranges;
	}

	//A much easier version.
	public static List<String> summaryRangesBetter(int[] nums) {
		List<String> summary = new ArrayList<>();
		for (int i = 0, j = 0; j < nums.length; ++j) {
			if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
				continue;
			if (i == j)
				summary.add(nums[i] + "");
			else
				summary.add(nums[i] + "->" + nums[j]);
			i = j + 1;
		}
		return summary;
	}	
}
