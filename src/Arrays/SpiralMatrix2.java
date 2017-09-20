package Arrays;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		SpiralMatrix2 spiral = new SpiralMatrix2();
		int n = 5;
		System.out.println("The matrix for n := " + n + " is := ");
		int[][] matrix = spiral.generateMatrix(n);
		for(int[] rows: matrix) {
			for(int i: rows) {
				System.out.print(i + ", \t");
			}
			System.out.println("");
		}
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int [n][n];
		boolean[][] visited = new boolean[n][n];

		int start = 1, offset = 0;

		while(offset < n && !visited[offset][offset]) {
			start = fillMatrix(matrix, visited, start, n, offset);
			offset++;
		}
		return matrix;
	}

	public int fillMatrix(int[][] matrix, boolean[][] visited, int start, int n, int offset) {
		int i = offset;
		int j = offset;
		for(; j < n - offset && !visited[i][j];) {
			matrix[i][j] = start++;
			visited[i][j] = true;
			if(j < n - 1 - offset) ++j;
		}

		for(i = offset + 1; i < n - offset && !visited[i][j];) {
			matrix[i][j] = start++;
			visited[i][j] = true;
			if(i < n - 1 - offset) ++i;
		}

		for(j = n - offset - 2, i = n - offset - 1; j >= offset && !visited[i][j];) {
			matrix[i][j] = start++;
			visited[i][j] = true;
			if(j >= offset + 1) --j;
		}

		for(i = n - offset - 2; i >= offset && !visited[i][j];) {
			matrix[i][j] = start++;
			visited[i][j] = true;
			if(i >= offset + 1) --i;
		}
		return start;
	}

	//Easy solution.

	public int[][] generateMatrixBetter(int n) {
		int top = 0, bottom = n - 1, left = 0, right = n - 1;
		int[][] result = new int[n][n];
		int start = 1;

		while(left <= right && top <= bottom) {
			for(int j = left, i = top; j <= right; ++j) {
				result[i][j] = start++;
			}

			for(int i = top + 1, j = right; i <= bottom; ++i) {
				result[i][j] = start++;
			}

			if(left < right && top < bottom) {
				for(int j = right - 1, i = bottom; j >= left; --j) {
					result[i][j] = start++;
				}

				for(int i = bottom - 1, j = left; i >= top + 1; --i) {
					result[i][j] = start++;
				}
			}

			top++; bottom--; left++; right--;
		}
		return result;
	}
}