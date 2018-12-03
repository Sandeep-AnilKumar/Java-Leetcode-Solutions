package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestIsland {
    private int max = 0;
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length, cur;
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    cur = dfs(grid, i, j, dir);
                    propagate(grid, i, j, cur, dir);
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, changeZeroToOne(grid, i, j, dir));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int[][] dir) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int res = 1;
        for (int[] d : dir) {
            res += dfs(grid, i + d[0], j + d[1], dir);
        }
        grid[i][j] = 1;
        return res;
    }

    private void propagate(int[][] grid, int i, int j, int cur, int[][] dir) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || grid[i][j] == cur) return;
        grid[i][j] = cur;
        for (int[] d : dir) {
            propagate(grid, i + d[0], j + d[1], cur, dir);
        }
    }

    private int changeZeroToOne(int[][] grid, int i, int j, int[][] dir) {
        int res = 0, cR, cC;
        for (int[] d : dir) {
            cR = i + d[0];
            cC = j + d[1];
            if (cR >= 0 && cC >= 0 && cR < grid.length && cC < grid[cR].length && grid[cR][cC] != 0) {
                res += grid[cR][cC];
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        LargestIsland largestIsland = new LargestIsland();
        int[][] grid = {{1, 0}, {0, 1}};
//        System.out.println("The largest island after changing at most one zero to one is := " + largestIsland.largestIsland(grid));

//        grid = new int[][]{{1, 1}, {1, 0}};
//        System.out.println("The largest island after changing at most one zero to one is := " + largestIsland.largestIsland(grid));

//        grid = new int[][]{{1, 1}, {1, 1}};
//        System.out.println("The largest island after changing at most one zero to one is := " + largestIsland.largestIsland(grid));
    }
}
