package DynamicProgramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) 
	{
		int []nums = new int[]{1,3,6,7,9,4,10,5,6};
		int size = lengthOfLIS(nums);
		System.out.println("The length of the longest increasing subsequence is :" + size);
	}
	public static int lengthOfLIS(int[] nums)
	{
		if (nums.length == 0)
			return 0;
		else if(nums.length == 1)
			return 1;
		else{
			int []dp = new int[nums.length];
			int ans = 0;
			dp[nums.length-1] = 1;
			for(int i = nums.length-1; i>=0;--i)
			{
				int max = 1;
				for(int j = i+1; j < nums.length;++j)
				{
					if(nums[i] < nums[j])
					{
						max = Math.max(max,1+dp[j]);
					}
				}
				dp[i] = max;
				ans = Math.max(ans,max);
			}
			return ans;
		}
	}
}