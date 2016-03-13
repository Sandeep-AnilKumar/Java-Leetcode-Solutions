package DynamicProgramming;

public class PerfectSquares {

	public static void main(String[] args)
	{
		int n = 13;
		int count = numSquares(n);
		System.out.println("The least count that can sum this number is :" + count);
	}
	public static int numSquares(int n)
	{
		int []dp = new int[n+1];
		for(int i = 1; i<=n; i++)
		{
			int min = Integer.MAX_VALUE;
			int j = 1; 
			while(i - j*j >= 0)
			{
				min = Math.min(min, dp[i - j*j] + 1);
				j++;
			}
			dp[i] = min;
		}
		return dp[n];
	}
}