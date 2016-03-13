package DynamicProgramming;

import java.util.Arrays;

public class RobberyAdjacentHouse2 {

	public static void main(String[] args) {
		int houses[] = new int[]{8,2,5,6,7,8};
		int bounty = rob(houses);
		System.out.println("Maximum bounty is: " + bounty);
	}

	public static int rob(int[] nums)
	{
		if(nums.length == 0)
			return 0;
		else if(nums.length == 1)
			return nums[0];
		else if(nums.length == 2)
			return Math.max(nums[0],nums[1]);
		else
		{
			return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));   
		}
	}

	public static int rob(int[]nums, int low, int high)
	{
		int cloneHouses[] = Arrays.copyOfRange(nums, low, high+1);
		int dynamicHouses[] = new int[high-low+1];
		dynamicHouses[0] = cloneHouses[0];
		dynamicHouses[1] = Math.max(cloneHouses[0],cloneHouses[1]);
		for(int i = 2; i<dynamicHouses.length; i++)
		{
			dynamicHouses[i] = Math.max(dynamicHouses[i-2]+cloneHouses[i],dynamicHouses[i-1]);
		}
		return dynamicHouses[dynamicHouses.length-1];
	}
}