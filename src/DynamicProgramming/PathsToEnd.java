package DynamicProgramming;

public class PathsToEnd {

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][] {{true, true, true, true, true},
            {true, true, false, true, false},
            {true, true, false, true, true},
            {true, false, false, true, true},
            {true, true, true, true, true}};

            //The duration does not give much of an idea of the runtime, since the input is of very small size. But DFS takes O(2pown2),
            //Recursion takes O(2n) and memoized version takes O(n2).

            long startTime = System.nanoTime();
            System.out.print(endPaths(grid) + " by DFS -> :");
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println(duration);

            startTime = System.nanoTime();
            System.out.print(countPaths(grid, 0, 0) + " by Recursion & not memoization -> :");
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println(duration);

            int[][] paths = new int[grid.length][grid[0].length];
            startTime = System.nanoTime();
            System.out.print(countPathsMemoization(grid, 0, 0, paths) + " by Recursion & memoization -> :");
            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println(duration);
    }

    //DFS
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

    //Recursion and No Memoization
    public static int countPaths(boolean[][] grid, int row, int col) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length) {
            if(!grid[row][col]) {
                return 0;
            }
            if(row == grid.length - 1 && col == grid[0].length - 1) return 1;
            return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
        }
        return 0;
    }

    //Memoization
    public static int countPathsMemoization(boolean[][] grid, int row, int col, int[][] paths) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length) {
            if(!grid[row][col]) {
                return 0;
            }
            if(row == grid.length - 1 && col == grid[0].length - 1) return 1;
            if(paths[row][col] == 0) {
                paths[row][col] = countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
            }
            return paths[row][col];
        }
        return 0;
    }
}
