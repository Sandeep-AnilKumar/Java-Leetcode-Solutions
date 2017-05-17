package Google;

public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},
				{1,1,1,0},
				{0,1,0,0},
				{1,1,0,0}};
		System.out.println("The island perimeter is := " + islandPerimeterBetter(grid));
	}

	public static int islandPerimeter(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}

		int row = grid.length;
		int sum = 0;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < grid[i].length; ++j) {
				if(grid[i][j] == 1) {
					sum = getPerimeter(i, j, grid, sum);
				}
			}
		}
		return sum;
	}

	public static int getPerimeter(int i, int j, int[][] grid, int sum) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
			return sum;
		}

		grid[i][j] = -1;
		sum += (i - 1 < 0 || grid[i - 1][j] == 0 ? 1 : 0) + 
				(j - 1 < 0 || grid[i][j - 1] == 0 ? 1 : 0) +
				(i + 1 >= grid.length || grid[i + 1][j] == 0 ? 1 : 0) +
				(j + 1 >= grid[i].length || grid[i][j + 1] == 0 ? 1 : 0);

		sum = getPerimeter(i + 1, j, grid, sum);
		sum = getPerimeter(i, j + 1, grid, sum);
		sum = getPerimeter(i - 1, j, grid, sum);
		sum = getPerimeter(i, j - 1, grid, sum);

		return sum;
	}

	//A much better implementation.

	public static int islandPerimeterBetter(int[][] grid) {
		int m = grid.length, n = grid[0].length, perimeter = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					continue;
				}
				if (i - 1 < 0 || grid[i - 1][j] == 0) {
					perimeter++;
				}
				if (j - 1 < 0 || grid[i][j - 1] == 0) {
					perimeter++;
				}
				if (i + 1 == m || grid[i + 1][j] == 0) {
					perimeter++;
				}
				if (j + 1 == n || grid[i][j + 1] == 0) {
					perimeter++;
				}
			}
		}
		return perimeter;
	}
}
