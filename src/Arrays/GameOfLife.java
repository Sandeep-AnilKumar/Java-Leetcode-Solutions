package Arrays;

/**
 * @author sandeepa
 */

public class GameOfLife {

	public static void main(String[] args) {

		GameOfLife game = new GameOfLife();
		int[][] board = {{1}};
		System.out.println("The updated board is := ");
		game.gameOfLife(board);
	}

	public void gameOfLife(int[][] board) {
		if(board == null || board.length == 0) {
			return;
		}

		int rows = board.length;
		int cols = board[0].length;
		int[][] update = new int[rows][cols];

		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < cols; ++j) {
				updateBoard(i, j, update, board);
			}
		}

		board = update;
		return;
	}

	public void updateBoard(int i, int j, int[][] update, int[][] board) {
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}

		int count = 0;
		int cur = board[i][j];

		if(i > 0) {
			count += board[i - 1][j];
		}

		if(j > 0) {
			count += board[i][j - 1];
		}

		if(i > 0 && j > 0) {
			count += board[i - 1][j - 1];
		}

		if(i < board.length - 1) {
			count += board[i + 1][j];
		}

		if(j < board[0].length - 1) {
			count += board[i][j + 1];
		}

		if(i < board.length - 1 && j < board[0].length - 1) {
			count += board[i + 1][j + 1];
		}

		if(i > 0 && j < board[0].length - 1) {
			count += board[i - 1][j + 1];
		}

		if(i < board.length - 1 && j > 0) {
			count += board[i + 1][j - 1];
		}

		if(cur == 1) {
			if(count < 2 || count > 3) {
				update[i][j] = 0;
			}
		} else {
			if(count == 3) {
				update[i][j] = 1;
			}
		}

		return;
	}
}
