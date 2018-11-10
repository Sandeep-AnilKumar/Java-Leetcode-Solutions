package Graphs;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length, max = 0;
        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int[][] memo = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                max = Integer.max(max, dfs(matrix, i, j, memo, dir));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo, int[][] dir) {
        if (memo[i][j] != 0) return memo[i][j];
        int res = 0, x = 0, y = 0;
        for (int[] d : dir) {
            x = i + d[0];
            y = j + d[1];
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[x].length && matrix[x][y] > matrix[i][j]) {
                res = Math.max(res, dfs(matrix, x, y, memo, dir));
            }
        }
        memo[i][j] = res + 1;
        return memo[i][j];
    }

    public static void main(String[] args) {
        LongestIncreasingPath path = new LongestIncreasingPath();
        int[][] matrix = {{9,9,4},
                {6,6,8},
                {2,1,1}};
        System.out.println("The count of longest increasing path is := " + path.longestIncreasingPath(matrix));
        matrix = new int[][] {{4,4,5},
                {3,2,6},
                {2,2,1}};
        System.out.println("The count of longest increasing path is := " + path.longestIncreasingPath(matrix));
    }
}
