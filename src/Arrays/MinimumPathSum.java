package Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,2,2,1},
                {2,1,1,2},
                {3,1,4,5},
                {4,4,5,6}};
        System.out.println("Minimum Path from top start to bottom end is : " + minPathSum(grid));
    }


    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[row - 1][column - 1] = grid[row - 1][column - 1];

        for(int i = row - 2; i >= 0; --i) {
            dp[i][column - 1] = dp[i + 1][column - 1] + grid[i][column - 1];
        }

        for(int i = column - 2; i >= 0; --i) {
            dp[row - 1][i] = dp[row - 1][i + 1] + grid[row - 1][i];
        }

        for(int i = row - 2; i >= 0; --i) {
            for(int j = column - 2; j >= 0; --j) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
