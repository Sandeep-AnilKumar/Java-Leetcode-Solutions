package Arrays;

public class ConvertMatrix {

	//If the matrix has a zero, convert all its row and column elements to zero.
	public static void main(String[] args) {
		int[][] matrix = {{20, 0, 15, 45},
				{9, 3, 0, 9}, 
				{8, 0, 0, 2}, 
				{22, 10, 190, 12}};

		matrix = convertMatrix(matrix);
		System.out.println("The converted matrix is := ");
		System.out.print("[");
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[i].length; ++j) {
				System.out.print(matrix[i][j]);
				if(j != matrix[i].length - 1) {
					System.out.print(", ");
				}
			}
			if(i != matrix.length - 1) {
				System.out.print("\n");
			}
		}
		System.out.println("]");
	}

	public static int[][] convertMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return matrix;
		}

		int row = matrix.length;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < matrix[i].length; ++j) {
				if(matrix[i][j] == 0) {
					matrix = convertRowAndColumns(i, j, matrix);
				}
			}
		}

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < matrix[i].length; ++j) {
				if(matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}

		return matrix;
	}

	public static int[][] convertRowAndColumns(int row, int col, int[][] matrix) {
		for(int j = 0; j < matrix[row].length; ++j) {
			if(matrix[row][j] != 0) {
				matrix[row][j] = -1;
			}
		}

		for(int i = 0; i < matrix.length; ++i) {
			if(matrix[i][col] != 0) {
				matrix[i][col] = -1;
			}
		}

		return matrix;
	}
}
