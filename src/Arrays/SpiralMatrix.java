package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix sp = new SpiralMatrix();
		int[][] matrix = {{1},
				{5},
				{9},{4},{3},{2},{7},{10}};

		List<Integer> order = sp.spiralOrder(matrix);
		System.out.println(order);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean[][] visited = new boolean[rows][cols];

		int right = cols - 1;
		int bottom = rows - 1;
		int left = 0;
		int top = 1;
		int curI = 0;
		int curJ = 0;

		List<Integer> order = new ArrayList<>();

		while(curI <= rows - 1 && curJ <= cols - 1) {
			spiral(curI, curJ, right, bottom, left, top, matrix, order, visited);
			curI++;
			curJ++;
			right--;
			bottom--;
			left++;
			top++;
		}
		return order;
	}

	public void spiral(int curI, int curJ, int right, int bottom, int left, int top, int[][] matrix, List<Integer> order, boolean[][] visited) {
		int i = curI;
		int j = curJ;

		for(; j <= right; ++j) {
			if(!visited[i][j]) {
				order.add(matrix[i][j]);
				visited[i][j] = true;
			}
		}

		--j; ++i;

		for(; i <= bottom; ++i) {
			if(!visited[i][j]) {
				order.add(matrix[i][j]);
				visited[i][j] = true;
			}
		}

		--i; --j;

		for(; j >= left; --j) {
			if(!visited[i][j]) {
				order.add(matrix[i][j]);
				visited[i][j] = true;
			}
		}

		++j; --i;

		for(; i >= top; --i) {
			if(!visited[i][j]) {
				order.add(matrix[i][j]);
				visited[i][j] = true;
			}
		}
	}

	//An easier version.

}
