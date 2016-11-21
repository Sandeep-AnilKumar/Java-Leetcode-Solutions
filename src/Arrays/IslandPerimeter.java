package Arrays;

public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        System.out.println("Perimeter of the island is := " + islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    
    public static int dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = -1;
        int result = 0;
        result += (i - 1 < 0 || grid[i - 1][j] == 0 ? 1 : 0) + 
        (j - 1 < 0 || grid[i][j - 1] == 0 ? 1 : 0) +
        (i + 1 >= grid.length || grid[i + 1][j] == 0 ? 1 : 0) +
        (j + 1 >= grid[i].length || grid[i][j + 1] == 0 ? 1 : 0);
        
        result += dfs(grid, i + 1, j);
        result += dfs(grid, i - 1, j);
        result += dfs(grid, i, j + 1);
        result += dfs(grid, i, j - 1);
        
        return result;
    }
}
