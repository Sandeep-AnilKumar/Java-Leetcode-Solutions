package Arrays;

public class NumberOfIslands {
	public static void main(String[] args) {
		char matrix[][] = new char[][]{{'1','1','0','0'},
			{'1','1','0','0'},
			{'0','0','1','0'},
			{'0','1','0','0'}};
			System.out.println(numberOfIslands(matrix));
	}

	public static int numberOfIslands(char grid[][]) {
		if(grid == null)
			return 0;

		int n = grid.length;
		if(n == 0)
			return 0;

		int m = grid[0].length;
		int count = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == '1') {
					count++;
					sinkTheIsland(grid, i , j);
				}
			}
		}
		return count;
	}

	public static void sinkTheIsland(char matrix[][], int i, int j) {
		if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return;
		}

		if(matrix[i][j] == '0')
			return;

		matrix[i][j] = '0';

		sinkTheIsland(matrix, i+1, j);
		sinkTheIsland(matrix, i-1, j);
		sinkTheIsland(matrix, i, j+1);
		sinkTheIsland(matrix, i, j-1);
	}
}
