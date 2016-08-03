package Arrays;

public class NumberOfIslands {
	public static void main(String[] args) {
		char matrix[][] = new char[][]{{'1','1','0','0'},
				{'1','1','0','0'},
				{'0','0','1','0'},
				{'0','1','0','0'}};
		System.out.println(numIslands(matrix));
	}

	public static int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}

		int row = grid.length;
		int column =grid[0].length;
		int sum = 0;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < column; ++j) {
				if(grid[i][j] == '1') {
					sum ++;
					findIslands(grid, i, j);
				}
			}
		}
		return sum;
	}

	public static void findIslands(char[][] grid, int i , int j) {
		if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
			return;
		}

		if(grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		findIslands(grid, i+1, j);
		findIslands(grid, i-1, j);
		findIslands(grid, i, j+1);
		findIslands(grid, i, j-1);

	}
}
