package Arrays;

/**
 * @author sandeepa
 */

public class NumberOfIslands2 {

	public static void main(String[] args) {
		char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		System.out.println("The number of islands in grid is := " + new NumberOfIslands2().numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;

		int row = grid.length;
		int col = grid[0].length;
		int count = 0;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j) {
				if(grid[i][j] == '1') {
					visitLands(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public void visitLands(char[][] grid, int i, int j) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')  return;
		grid[i][j] = '*';

		visitLands(grid, i + 1, j);
		visitLands(grid, i, j + 1);
		visitLands(grid, i - 1, j);
		visitLands(grid, i, j - 1);
		return;
	}
}
