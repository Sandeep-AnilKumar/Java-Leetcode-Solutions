package DynamicProgramming;

public class RobberyAdjacentHouse {
	public static void main(String[] args)
	{
		int[] nums = {2,1,1,2};
		int bounty = rob(nums);
		System.out.println("Maximum bounty is " + bounty);
	}

	public static int rob(int[] nums) {
		Integer M[] = new Integer[nums.length];
		if(nums.length == 0)
		{
			return 0;
		}
		else if(nums.length == 1)
		{
			return nums[0];
		}
		else if(nums.length == 2)
		{
			return max(nums[0],nums[1]);
		}
		else
		{
			M[0] = nums[0];
			M[1] = max(nums[0],nums[1]);
			for(int i = 2; i<nums.length;i++)
			{
				M[i] = max(nums[i]+M[i-2],M[i-1]);
			}
		}
		return M[nums.length-1];
	}

	public static int max(int a, int b)
	{
		return (a>b ? a : b);
	}
}


