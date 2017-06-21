package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestMeetingPoint {

	public static void main(String[] args) {
		BestMeetingPoint bmp = new BestMeetingPoint();
		int[][] grid = {{1, 0, 0, 0, 1},
				{0, 0, 0, 0, 0}, 
				{0, 0, 1, 0, 0}};

		System.out.println("The best meeting point is := " + bmp.minTotalDistance(grid));
	}


	public int minTotalDistance(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}

		List<List<Integer>> points = new ArrayList<>();
		int row = grid.length;
		int col = 0;
		for(int i = 0; i < row; ++i) {
			col = grid[i].length;
			for(int j = 0; j < col; ++j) {
				if(grid[i][j] == 1) {
					points.add(Arrays.asList(i, j));
					grid[i][j] = 0;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < row; ++i) {
			col = grid[i].length;
			for(int j = 0; j < col; ++j) {
				for(List<Integer> point: points) {
					grid[i][j] += Math.abs(point.get(0) - i) + Math.abs(point.get(1) - j);
				}
				min = Math.min(grid[i][j], min);
			}
		}
		return min;
	}
}
