package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Exam {

	public static void main(String[] args) {
		int[] nums = {-1,2,3,4,5};
		subsets(nums);
	}

	public static List<String> subsets(int[] nums) {
		List<String> range = new ArrayList<String>();
		if(nums.length == 0)
			return range;

		if(nums.length == 1)
		{
			String s = "\"" + nums[0] + "\"";
			range.add(s);
			return range;
		}

		else
		{
			int i = 0, j = 0;
			int length = nums.length;
			for(i = 1; i < length; i++)
			{
				while(i < length && nums[i] - nums[i - 1] == 1)
					i++;
				if(i - j > 1)
				{
					String s = "\"" + nums[j] + "\"->" + "\"" + nums[i-1] + "\"" ;
					range.add(s);
				}

				else
				{
					String s = "\"" + nums[j] + "\"";
					range.add(s);
					i++;
				}

				j = i;
				i--;
			}
		}
		return range;
	}
}
