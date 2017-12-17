package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class MaximalRectangle {

	public static void main(String[] args) {
		char[][] matrix = {{'0','0','1','1','0'}, 
				{'0','1','0','1','0'},
				{'0','1','1','1','0'},
				{'0','1','1','1','0'}};
		System.out.println("The largest rectangle is of size := " + new MaximalRectangle().maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int cols = matrix[0].length;
		int rows = matrix.length;
		int[] heights = new int[cols];
		int max = 0;

		for (int row = 0; row < rows; row++) {
			for (int i = 0; i < cols; i++) {
				heights[i] = matrix[row][i] == '1' ? heights[i] + 1 : 0;
			}
			max = Math.max(max, largestRectangleArea(heights));
		}

		return max;
	}

	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) {
			return 0;
		}

		Deque<Integer> stack = new ArrayDeque<>();
		stack.offerLast(-1);
		int length = heights.length;
		int max = 0;

		for(int i = 0; i <= length; ++i) {
			while(stack.peekLast() != -1 && (i == length || heights[i] <= heights[stack.peekLast()])) {
				max = Math.max(max, heights[stack.pollLast()] * (i - (stack.peekLast()) - 1));
			}
			stack.offerLast(i);
		}

		return max;
	}
}
