package Strings;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		PalindromicSubstrings ps = new PalindromicSubstrings();
		System.out.println(ps.countSubstrings("abc"));
	}

	public int countSubstrings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		int length = s.length();

		int start = 0;
		int end = length - 1;
		char[] chars = s.toCharArray();
		int count = length;

		for(int i = 0; i < length; ++i) {
			start = i;
			end = length - 1;

			while(start < end) {
				if(checkPalindrome(chars, start, end)) {
					count++;
				}
				end--;
			}
		}
		return count;
	}

	public boolean checkPalindrome(char[] chars, int start, int end) {
		while(start < end) {
			if(chars[start++] != chars[end--]) {
				return false;
			}
		}
		return true;
	}

	public int countSubstringsDP(String s) {
		int n=s.length();
		int[][] dp=new int[n][n];
		char[] sc=s.toCharArray();
		int res=0;
		for (int i=0;i<n;++i){
			dp[i][i]=1;
			res++;
			for (int j=i-1;j>=0;--j){
				if (sc[i]==sc[j] && ((i-j<3)||dp[i-1][j+1]==1)){
					dp[i][j]=1;
				}
				if (dp[i][j]==1) res++;
			}

		}

		return res;
	}
}
