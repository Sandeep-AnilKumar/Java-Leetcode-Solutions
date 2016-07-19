package Arrays;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args)
	{
		int[] nums = new int[]{-1,0,1,2,4,-5,6};
		int target = 4;
		int result = threeSumClosest(nums, target);
		System.out.print("The number nearest to target :"+target+" is : "+ result);
	}

	public static int threeSumClosest(int[] nums, int target)
	{
		if(nums == null || nums.length < 3)
			return -1;
		int length = nums.length;
		int diff = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(nums);

		for(int i = 0; i < length; i++)
		{
			if(i > 0 && nums[i] == nums[i-1]) continue;
			int j = i + 1; int k = length - 1;

			while(j < k)
			{
				int sum = nums[i] + nums[j] + nums[k];
				if(diff > Math.abs(target - sum))
				{
					result = sum;
					diff = Math.abs(target - sum);
				}
				else if(sum == target)
				{
					return sum;
				}
				else if(sum < target)
					j++;
				else
					k--;
			}

		}
		return result;
	}
}
