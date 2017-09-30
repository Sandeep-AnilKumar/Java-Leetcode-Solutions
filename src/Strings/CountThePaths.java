package Strings;

import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class CountThePaths {

	public static void main(String[] args) {
		List<String> grid = Arrays.asList("0100","1111", "0111", "0110", "0111");
		System.out.println("The number of paths from bottom-left to top-right are := " + new CountThePaths().count_the_paths(grid));
	}

	public int count_the_paths(List<String> grid) {
		if(grid == null || grid.size() == 0) return 0;

		int rows = grid.size();
		int cols = grid.get(0).length();
		int[][] count = new int[rows][cols];
		count[rows - 1][0] = 1;
		String top = grid.get(0);
		String bottom = grid.get(rows - 1);

		if(rows != 1) {
			top = new String(top.substring(0, top.length() - 1) + '1');
			bottom = new String('1' + bottom.substring(1));
			grid.set(0, top);
			grid.set(rows - 1, bottom);
		} else {
			top = new String(top.substring(0, top.length() - 1) + '1');
			grid.set(0, top);
		}

		for(int i = rows - 2; i >= 0; --i) {
			count[i][0] = grid.get(i).charAt(0) - '0' & count[i + 1][0];
		}

		for(int j = 1; j < cols; ++j) {
			count[rows - 1][j] = grid.get(rows - 1).charAt(j) - '0' & count[rows - 1][j - 1];
		}

		for(int i = rows - 2; i >= 0; --i) {
			for(int j = 1; j < cols; ++j) {
				if((i == 0 && j == cols - 1) || grid.get(i).charAt(j) == '1') {
					count[i][j] = count[i + 1][j] + count[i][j - 1];
				}
			}
		}

		return count[0][cols - 1];
	}
}