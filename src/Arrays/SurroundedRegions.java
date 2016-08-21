package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		char matrix[][] = new char[][]{{'X','O','X'},
				{'X','O','X'},
				{'X','O','X'}};
		System.out.println(solve1(matrix));
	}


	public static char[][] solve(char[][] board) {
		if(board == null || board.length <= 2 || board[0].length <= 2) {
			return board;
		}

		int row = board.length;
		int column = board[0].length;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < column; ++j) {
				if((i == 0 || j == 0 || i == row - 1 || j == column - 1) && board[i][j] == 'O') {
					DFS(board, i, j);
				}
			}
		}

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < column; ++j) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				else if(board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
		return board;
	}

	public static void DFS(char[][] board, int i, int j) {
		board[i][j] = '*';
		if(i > 1 && board[i-1][j] == 'O') {
			DFS(board, i-1, j);
		}
		if(i < board.length - 2 && board[i+1][j] == 'O') {
			DFS(board, i+1, j);
		}
		if(j > 1 && board[i][j-1] == 'O') {
			DFS(board, i, j-1);
		}
		if(j < board[0].length - 2 && board[i][j+1] == 'O') {
			DFS(board, i, j+1);
		}  
	}

	//BFS version
	public static char[][] solve1(char[][] board) {
		if (board == null || board.length == 0)
			return board;
		int rows = board.length, columns = board[0].length;
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++) {
				if ((i == 0 || i == rows - 1 || j == 0 || j == columns - 1) && board[i][j] == 'O') {
					Queue<Point> queue = new LinkedList<>();
					board[i][j] = 'B';
					queue.offer((new SurroundedRegions()).new Point(i, j));
					while (!queue.isEmpty()) {
						Point point = queue.poll();
						for (int k = 0; k < 4; k++) {
							int x = direction[k][0] + point.x;
							int y = direction[k][1] + point.y;
							if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O') {
								board[x][y] = 'B';
								queue.offer((new SurroundedRegions()).new Point(x, y));
							}
						}
					}
				}
			}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (board[i][j] == 'B')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
		return board;
	}
}
