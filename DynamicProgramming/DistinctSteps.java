package DynamicProgramming;

public class DistinctSteps {

	public static void main(String[] args) {
		int steps = climbStairs(5);
		System.out.println("Number of distinct steps "+ steps);
	}

	public static int climbStairs(int n) {
		Integer M[] = new Integer[n+1];
		if(n == 0)
			return 0 ;
		else if(n == 1)
			return 1;
		else
		{
			M[0] = 0;
			M[1] = 1;
			M[2] = 2;
			for (int i = 3; i <= n; i++)
			{
				M[i] = M[i-1]+M[i-2];
			}
		}
		return M[n];
	}
}