package Graphs;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length, peri = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    return islandPerimeter(grid, i, j, visited);
                }
            }
        }
        return peri;
    }

    private int islandPerimeter(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int res = 0;
        for (int[] d : dir) {
            if (i + d[0] < 0 || i + d[0] >= grid.length || j + d[1] < 0 || j + d[1] >= grid[i].length ||
                    grid[i + d[0]][j + d[1]] == 0) {
                res++;
            } else if (!visited[i + d[0]][j + d[1]]) {
                res += islandPerimeter(grid, i + d[0], j + d[1], visited);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println("The total perimeter of the island is := " + new IslandPerimeter().islandPerimeter(grid));
    }
}
