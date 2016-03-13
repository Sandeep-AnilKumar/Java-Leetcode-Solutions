/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 * 
 * 
 */


public class DistinctSubsequence {

	public static void main(String[] args) {
		String s = "ruthjgh";
		String t = "ruh";
		int n = numDistinct(s,t);
		System.out.println(n);
	}

	public static int numDistinct(String s, String t)
	{
		if (s == null || t == null || t.length() == 0)
			return 0;

		int[] arr = new int[t.length()];        
		for (int i = 0; i < s.length(); i++) {
			for (int j = arr.length-1; j >= 0; j--)
				if (s.charAt(i) == t.charAt(j))
					arr[j] = j != 0 ? arr[j] + arr[j-1] : arr[j]+1;
		}
		return arr[arr.length-1];
	}
}
