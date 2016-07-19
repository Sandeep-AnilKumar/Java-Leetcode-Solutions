package DynamicProgramming;

import java.util.Stack;

public class LongestParentheses {

	public static void main(String[] args) {
		String s = "((())";
		int size = longestValidParentheses(s);
		System.out.println("The size of the longest valid parentheses is :"+ size);
	}

	public static int longestValidParentheses(String s)
	{
		if( s.equals(null) || s.length() == 0 || s.length() == 1 )
			return 0;
		int []dp = new int[s.length()+1];
		int max = 0;
		for( int i = 1; i<s.length(); i++ )
		{
			if( s.charAt(i) == ')' && i - dp[i] >= 1 && s.charAt(i - dp[i] - 1) == '(' )
			{
				dp[i+1] = dp[i-dp[i]-1] + dp[i] + 2;
			}
		}
		for( int i = 0; i<dp.length;i++ )
		{
			max = Math.max( max, dp[i] );
		}
		return max;
	}
}