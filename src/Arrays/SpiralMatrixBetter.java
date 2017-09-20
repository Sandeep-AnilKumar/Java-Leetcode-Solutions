package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixBetter {

	public static void main(String[] args) {
		SpiralMatrixBetter matrix = new SpiralMatrixBetter();
		int[][] m = {{2,5},{8,4},{0,-1}};
		System.out.println("The spiral order of the matrix is := " + matrix.spiralOrder(m));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiral = new ArrayList<>();
		if(matrix == null || matrix.length == 0) return spiral;

		int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

		while(left <= right && top <= bottom) {
			for(int j = left, i = top; j <= right; ++j) {
				spiral.add(matrix[i][j]);
			}

			for(int i = top + 1, j = right; i <= bottom; ++i) {
				spiral.add(matrix[i][j]);
			}

			if(left < right && top < bottom) {
				for(int j = right - 1, i = bottom; j > left; --j) {
					spiral.add(matrix[i][j]);
				}

				for(int i = bottom, j = left; i >= top + 1; --i) {
					spiral.add(matrix[i][j]);
				}
			}

			top++; bottom--; left++; right--;
		}
		return spiral;
	}
}
