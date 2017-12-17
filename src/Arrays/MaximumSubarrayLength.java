package Arrays;

/**
 * @author sandeepa
 */

public class MaximumSubarrayLength {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 2, 1};
		int[] B = {3, 2, 1, 4, 7};
		System.out.println("The maximum length of subarray common in both arrays is := " + new MaximumSubarrayLength().findLength(A, B));
	}

	public int findLength(int[] A, int[] B) {
		if(A == null || A.length == 0 || B == null || B.length == 0) {
			return 0;
		}

		int m = A.length;
		int n = B.length;
		int max = 0;
		int[][] dp = new int[m + 1][n + 1];

		for(int i = 1; i <= m; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max;
	}
}
