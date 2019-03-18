package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;

public class PerfectSquares {

	public static void main(String[] args)
	{
		int n = 13;
		int count = numSquaresBFS(n);
		System.out.println("The least count that canShip sum this number is :" + count);
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

	public static int numSquaresBFS(int n) {

		Deque<Integer> queue = new ArrayDeque<Integer>();
		queue.add(n);
		int depth = 1, m = 1, tmp = 0;

		while(true){
			if(m == 0){
				depth++;
				m = tmp;
				tmp = 0;
			}

			int cur = queue.remove();
			m--;

			int l = (int) Math.sqrt(cur);
			for(int i=l; i>0; i--){
				int sq = i*i;
				int delta = cur - sq;
				if(delta == 0)
					return depth;
				queue.add(delta);
				tmp++;
			}
		}
	}
}