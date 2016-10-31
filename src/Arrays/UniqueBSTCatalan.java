package Arrays;

public class UniqueBSTCatalan {

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of binary search tree for n = " + n + " is " + numTrees(n));
    }

    //C(n) = Sum of (C(i - 1) + C(n - i)) for all i from 1 to n.
    public static int numTrees(int n) {
        if(n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; ++i) {
            for(int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
