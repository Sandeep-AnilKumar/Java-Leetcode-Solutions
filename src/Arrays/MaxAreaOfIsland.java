package Arrays;

/**
 * @author sandeepa
 */

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println("The maximum area of island in the grid is := " + new MaxAreaOfIsland().maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;

		int max = 0, rows = grid.length, cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < cols; ++j) {
				if(grid[i][j] == 1) {
					max = Math.max(max, calculateArea(grid, i, j, visited, 0, dirs));
				}
			}
		}
		return max;
	}

	public int calculateArea(int[][] grid, int i, int j, boolean[][] visited, int area, int[][] dirs) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return area;

		visited[i][j] = true;
		area++;

		for(int[] dir: dirs) {
			area = calculateArea(grid, i + dir[0], j + dir[1], visited, area, dirs);
		}

		return area;
	}
}
