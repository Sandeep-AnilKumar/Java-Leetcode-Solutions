package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int nums[] = {0,0,0,0};
		threeSum(nums);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length < 3)
			return result;

		if(nums.length == 3)
		{
			if(nums[0] + nums[1] + nums[2] == 0)
			{
				result.add(Arrays.asList(nums[0], nums[1], nums[2]));
			}

			return result;
		}

		Arrays.sort(nums);
		int length = nums.length;

		for(int i = 0; i < length; i++)
		{
			if(i > 0 && nums[i] == nums[i-1]) continue;
			int target = -nums[i];
			int j = i + 1;
			int k = length - 1;

			while(j < k)
			{
				if(nums[j] + nums[k] == target)
				{
					result.add(Arrays.asList(nums[i],nums[j],nums[k]));
					while(j < k && nums[j] == nums[j + 1]) j++;
					while(j < k && nums[k] == nums[k - 1]) k--;
					j++;
					k--;
				}

				else if(nums[j] + nums[k] < target)
					j++;
				else
					k--;
			}
		}

		return result;
	}
}

