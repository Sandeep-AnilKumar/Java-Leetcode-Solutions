package Strings;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * 
 * 
 */

public class NumDecodings {

	public static void main(String[] args) {
		String s = "26";	
		System.out.println("Number of decodings possible :-\t" + numDecodingsBetter(s));
	}

	public static int numDecodings(String s)
	{
		if(s.length() == 0 || s.equals(""))
			return 0;
		int n = s.length();
		int[]A = new int[n+1];
		A[n] = 1;
		A[n-1] = s.charAt(n-1) == '0' ? 0 : 1;
		for(int i = n-2; i>=0 ; i--)
		{
			if(s.charAt(i) != '0')
			{
				A[i] = A[i+1];
				int val = Integer.parseInt(s.substring(i,i+2));
				if(val > 0 && val <= 26)
					A[i] += A[i+2];
			}
		}
		return A[0];
	}

	public static int numDecodingsBetter(String s) {
		if(s == null || s.length() == 0) return 0;

		int length = s.length();
		int[] dp = new int[length + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		for(int i = 2; i <= length; ++i) {
			if(s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
			if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[length];
	}
}
