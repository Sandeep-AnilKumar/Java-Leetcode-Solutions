package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sandeepa
 */

public class NumberDistinctIslands {

	public static void main(String[] args) {
		int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
		NumberDistinctIslands islands = new NumberDistinctIslands();
		System.out.println("The number of distinct islands are := " + islands.numDistinctIslands(grid));
	}

	int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public int numDistinctIslands(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;

		int row = grid.length;
		int col = grid[0].length;

		Set<List<List<Integer>>> set = new HashSet<>();
		List<List<Integer>> cur = new ArrayList<>();

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j) {
				if(grid[i][j] == 1) {
					cur = new ArrayList<>();
					getIslandCoordinates(i, j, i, j, cur, grid);
					set.add(cur);
				}
			}
		}
		return set.size();
	}

	public void getIslandCoordinates(int originI, int originJ, int i, int j, List<List<Integer>> cur, int[][] grid) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;

		grid[i][j] = -1;
		cur.add(Arrays.asList(i - originI, j - originJ));

		for(int[] d: dir) {
			getIslandCoordinates(originI, originJ, i + d[0], j + d[1], cur, grid);
		}
		return;
	}
}
