package Arrays;

public class NumberofArithmeticSlices {

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};
        System.out.println("Number of arithmetic slices :=" + numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int ans = 0, n = A.length;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; ++i) {
            for (int j = 1; j < i; ++j) {
                long diff = (long)A[i] - A[j];
                for (int k = 0; k < j; ++k) {
                    if ((long)A[j] - A[k] == diff) {
                        dp[i][j] += dp[j][k] + 1;
                    }
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
