package DynamicProgramming;

public class MaximumProduct {

	public static void main(String[] args) {
		int nums[] = new int[]{0,-2,-3,-1,12};
		int product = maxProduct(nums);
		System.out.println("Max Product sub array: "+product);
	}
	public static int maxProduct(int[] nums) {
		int prod = nums[0], max = prod, min = prod;
		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i]>=0)
			{
				max = Math.max(nums[i],nums[i]*max);
				min = Math.min(nums[i],nums[i]*min);
			}
			else
			{
				int tmp = max;
				max = Math.max(nums[i],nums[i]*min);
				min = Math.min(nums[i],nums[i]*tmp);
			}
			prod = Math.max(prod,max);
		}
		return prod;
	}
}