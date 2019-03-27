package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolveSudoku {
	boolean solved = false;

	public static void main(String[] args) {
		SolveSudoku solveSudoku = new SolveSudoku();
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

		System.out.println("The solved sudoku is := ");
		solveSudoku.solveSudoku(board);
		for (char[] b : board) {
			for (char c : b) {
				System.out.print(c + ", ");
			}
			System.out.println();
		}
	}

	public void solveSudoku(char[][] board) {
		Set<Integer> nums = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		Set<Integer>[] rows = new HashSet[9];
		Set<Integer>[] cols = new HashSet[9];
		Set<Integer>[] grids = new HashSet[9];

		for (int i = 0; i < 9; ++i) {
			rows[i] = new HashSet<>(nums);
			cols[i] = new HashSet<>(nums);
			grids[i] = new HashSet<>(nums);
		}

		int cur = 0;

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] != '.') {
					cur = board[i][j] - '0';
					rows[i].remove(cur);
					cols[j].remove(cur);
					grids[(i / 3) * 3 + (j / 3)].remove(cur);
				}
			}
		}


		solve(board, rows, cols, grids, 0, 0);
	}

	private void solve(char[][] board, Set<Integer>[] rows,
					   Set<Integer>[] cols, Set<Integer>[] grids, int i, int j) {

		if (solved || (i == 8 && j == 9)) {
			solved = true;
			return;
		}

		if (j == 9) {
			solve(board, rows, cols, grids, i + 1, 0);
			return;
		}

		if (board[i][j] != '.') {
			solve(board, rows, cols, grids, i, j + 1);
			return;
		}

		for (int p = 1; p < 10; ++p) {
			int k = (i / 3) * 3 + (j / 3);
			if (rows[i].contains(p) && cols[j].contains(p) && grids[k].contains(p)) {
				board[i][j] = (char) (p + 48);
				rows[i].remove(p);
				cols[j].remove(p);
				grids[k].remove(p);

				solve(board, rows, cols, grids, i, j + 1);

				if (!solved) {
					rows[i].add(p);
					cols[j].add(p);
					grids[k].add(p);
					board[i][j] = '.';
				}
			}
		}
	}
}
