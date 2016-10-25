package DynamicProgramming;

public class MaximalSquare {

    public static void main(String[] args) {
        char [][]array = new char[][]{{'1','0','0','0','1'},
            {'1','0','1','1','1'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','1','1','1','1'}};

            int area = maximalSquare(array);
            System.out.println("The area of the maximum sqaure is :"+ area);
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][]dp = new int[row][col];
        int maxArea = 0;
        for(int i = 0; i < row; ++i) {
            if(matrix[i][0] == '1') {
                dp[i][0] = matrix[i][0] - '0';
                maxArea = dp[i][0];
            }
        }

        for(int i = 0; i < col; ++i) {
            if(matrix[0][i] == '1') {
                dp[0][i] = matrix[0][i] - '0';
                maxArea = dp[0][i];
            }
        }

        for(int i = 1; i < row; ++i) {
            for(int j = 1; j < col; ++j) {
                if(matrix[i][j] - '0'== 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxArea = Math.max(maxArea, dp[i][j]*dp[i][j]);
                }
            }
        }
        return maxArea;
    }
}