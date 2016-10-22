package DynamicProgramming;

public class RangeSumQuery2DImmutable {

    int[][] dp;
    int[][] data;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            dp = null;
            data = null;
            return;
        }
        data = matrix;
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        for(int i = 0; i < row; ++i) {
            dp[i][0] = matrix[i][0];
            for(int j = 1; j < col ; ++j) {
                dp[i][j] = dp[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; ++i) {
            sum += dp[i][col2] - dp[i][col1] + data[i][col1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        RangeSumQuery2DImmutable r = new RangeSumQuery2DImmutable(nums);
        System.out.println(r.sumRegion(0, 0, 2, 3));
        System.out.println(r.sumRegion(1, 3, 2, 4));
        System.out.println(r.sumRegion(2, 1, 4, 3));
        System.out.println(r.sumRegion(3, 3, 4, 4));
    }
}
