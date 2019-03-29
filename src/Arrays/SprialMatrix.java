package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
	public static void main(String[] args) {
		SprialMatrix sprialMatrix = new SprialMatrix();
		int[][] matrix = {{1, 2, 3, 4, 5},
				{5, 6, 7, 8, 9},
				{9, 10, 11, 12, 13},
				{14, 15, 16, 17, 18}};
		System.out.println(sprialMatrix.spiralOrder(matrix));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int top = 0, left = 0, right = matrix[0].length - 1, down = matrix.length - 1, count = (right + 1) * (down + 1);

		while (count > 0) {
			for (int i = left; i <= right && count > 0; ++i) {
				list.add(matrix[top][i]);
				count--;
			}
			top++;

			for (int i = top; i <= down && count > 0; ++i) {
				list.add(matrix[i][right]);
				count--;
			}
			right--;

			for (int i = right; i >= left && count > 0; --i) {
				list.add(matrix[down][i]);
				count--;
			}
			down--;

			for (int i = down; i >= top && count > 0; --i) {
				list.add(matrix[i][left]);
				count--;
			}
			left++;
		}

		return list;
	}
}
