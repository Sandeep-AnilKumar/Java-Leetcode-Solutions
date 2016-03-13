package Arrays;

public class SurroundedRegions {
	public static void main(String[] args) {
		char matrix[][] = new char[][]{{'x','x','x','x'},
			{'x','x','o','x'},
			{'x','o','o','x'},
			{'x','o','x','x'}};
			System.out.println(numberOfIslands(matrix));
	}

	public static char[][] numberOfIslands(char board[][]) {
		if(board == null)
			return board;

		int n = board.length;
		if(n == 0)
			return board;

		int m = board[0].length;

		for(int i = 1; i < n - 1; i++) {
			for(int j = 1; j < m - 1; j++) {
				if(board[i][j] == 'o') {
					surroundedPart(board, i , j);
				}
			}
		}
		return board;
	}

	public static void surroundedPart(char matrix[][], int i, int j) {
		if(i < 1 || j < 1 || i >= matrix.length - 1 || j >= matrix[0].length - 1) {
			return;
		}

		if(matrix[i][j] == 'x')
			return;

		matrix[i][j] = 'x';

		surroundedPart(matrix, i+1, j);
		surroundedPart(matrix, i-1, j);
		surroundedPart(matrix, i, j+1);
		surroundedPart(matrix, i, j-1);
	}
}
