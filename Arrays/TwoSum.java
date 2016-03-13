package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		int nums[] = new int[]{0,4,2,0};
		int target = 0;
		int indices[] = twoSum(nums,target);
		System.out.println("The two indices of numbers that add up to the target are : ");
		for(int i : indices)
		{
			System.out.println(i);
		}
	}
	
	public static int[] twoSum(int[] nums, int target)
	{
		int length = nums.length;
		List<Integer> numbers = new ArrayList<Integer>(nums.length);
		int indices[] = new int[2];
		
		for(int i = 0; i < length; i++)
		{
			numbers.add(nums[i]);
		}
		
		for(int i = 0; i < length; i++)
		{
			int difference = target - nums[i];
			if(numbers.contains(difference) && numbers.indexOf(difference) != i)
			{
				indices[0] = i + 1;
				indices[1] = numbers.indexOf(difference) + 1;
				
				if(indices[0] > indices[1])
				{
					int temp = indices[0];
					indices[0] = indices[1];
					indices[1] = temp;
				}
				break;
			}
		}
		return indices;
	}
}
