package DynamicProgramming;

public class PathsToEnd {

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][] {{true, true, true, true, true},
            {true, true, false, true, false},
            {true, true, false, true, true},
            {true, false, false, true, true},
            {true, true, true, true, true}};
            System.out.println(endPaths(grid));
    }

    public static int endPaths(boolean[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        count = isEnd(0, 0, grid, count);
        return count;
    }

    public static int isEnd(int i, int j, boolean[][] grid, int count) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return count;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1 && grid[i][j]) {
            count++;
            return count;
        }

        if(i != grid.length -1 && grid[i+1][j]) {
            count = isEnd(i+1, j, grid, count);
        }
        if(j != grid.length -1 && grid[i][j+1]) {
            count = isEnd(i, j+1, grid, count);
        }
        return count;
    }
}
