package Arrays;

/**
 * @author sandeepa
 */

public class Minesweeper {

	public static void main(String[] args) {
		char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
		int[] click = {3,0};

		System.out.println("The minsweeper status after click " + click[0] + "," + click[1] + " is := ");
		char[][] result = new Minesweeper().updateBoard(board, click);
		for(char[] r: result) {
			for(char c: r) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}

	public char[][] updateBoard(char[][] board, int[] click) {
		if(click == null || click.length < 2 || board == null || board.length == 0) return board;

		if(board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X'; 
			return board;
		}

		int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		char[][] result = board;

		propogateBoard(board, result, visited, click[0], click[1], rows, cols, dir);
		return result;
	}

	public void propogateBoard(char[][] board, char[][] result, boolean[][] visited, int i, int j, int rows, int cols, int[][] dir) {
		if(!isValidPos(i, j, rows, cols) || visited[i][j]) return;

		visited[i][j] = true;
		int count = 0;

		for(int[] d: dir) {
			if(isValidPos(i + d[0], j + d[1], rows, cols)) {
				if(board[i + d[0]][j + d[1]] == 'M') count++;
			}
		}

		if(count > 0) {
			result[i][j] = (char) (count + '0');
			return;
		}

		result[i][j] = 'B';

		for(int[] d: dir) {
			propogateBoard(board, result, visited, i + d[0], j + d[1], rows, cols, dir);
		}
		return;
	}

	public boolean isValidPos(int i, int j, int rows, int cols) {
		if(i < 0 || i >= rows || j < 0 || j >= cols) return false;
		return true;
	}
}
