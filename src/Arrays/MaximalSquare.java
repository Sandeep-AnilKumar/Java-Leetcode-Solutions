package Arrays;

/**
 * @author sandeepa
 */

public class MaximalSquare {

	public static void main(String[] args) {
		char[][] matrix = {{'0','1','1','0','1'},
				{'1','1','0','1','0'},
				{'0','1','1','1','0'},
				{'1','1','1','1','0'},
				{'1','1','1','1','1'},
				{'0','0','0','0','0'}};
		System.out.println("The maximum square area is := " + new MaximalSquare().maximalSquare(matrix));
	}

	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return 0;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] heights = new int[cols];
		int maxArea = 0;

		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < cols; ++j) {
				heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
			}

			maxArea = Math.max(maxArea, largestSquareArea(heights));
		}

		return maxArea;
	}

	public int largestSquareArea(int[] heights) {
		if(heights == null || heights.length == 0) {
			return 0;
		}

		int length = heights.length;
		int curMin = Integer.MAX_VALUE;
		int curIndex = 1;
		int maxArea = 0;
		int curMinIndex = 0;
		int i = 0;
		int j = 0;

		while(i < length) {
			j = i;
			curIndex = 1;
			curMinIndex = j;
			curMin = heights[i];
			while(curMin >= curIndex && j < length) {
				if(heights[j] < curMin) {
					curMin = heights[j];
					curMinIndex = j;
				}

				if(curMin >= curIndex) {
					curIndex++;
				}

				j++;
			}

			maxArea = Math.max(maxArea, (curIndex - 1) * (curIndex - 1));
			i = curMinIndex + 1;
		}

		return maxArea;
	}

	public int maximalSquareBest(char[][] matrix) {
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
		int[] dp = new int[cols + 1];
		int maxsqlen = 0, prev = 0;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				int temp = dp[j];
				if (matrix[i - 1][j - 1] == '1') {
					dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
					maxsqlen = Math.max(maxsqlen, dp[j]);
				} else {
					dp[j] = 0;
				}
				prev = temp;
			}
		}
		
		return maxsqlen * maxsqlen;
	}
}
