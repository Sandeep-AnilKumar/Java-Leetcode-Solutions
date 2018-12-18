package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class SlidingPuzzle {

	public static void main(String[] args) {
		SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
		int[][] board = {{1, 2, 3}, {4, 0, 5}};
		System.out.println("The number of steps required to complete the puzzle is := "
				+ slidingPuzzle.slidingPuzzle(board));
	}

	public int slidingPuzzle(int[][] board) {
		if (board == null || board.length == 0) return 0;
		Deque<State> dq = new ArrayDeque<>();
		Set<State> visited = new HashSet<>();
		int res = 0, size = 0, i = 0, j = 0, temp = 0;
		State cur, next;
		int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		int[][] other = {{1, 2, 3}, {4, 5, 0}};
		boolean found = false;
		State target = new State(other, 1, 2);

		for (; i < 2; ++i) {
			j = 0;
			for (; j < 3; ++j) {
				if (board[i][j] == 0) {
					found = true;
					break;
				}
			}
			if (found) break;
		}

		cur = new State(board, i, j);
		dq.offer(cur);
		visited.add(cur);

		while (!dq.isEmpty()) {
			for (size = dq.size(); size > 0; --size) {
				cur = dq.poll();
				//System.out.println(cur + ", res= " + res);

				//check target
				if (cur.equals(target)) return res;

				for (int[] d : dir) {
					i = cur.i + d[0];
					j = cur.j + d[1];

					if (i < 0 || j < 0 || i >= 2 || j >= 3) continue;
					other = new int[2][3];
					for (int k = 0; k < board.length; ++k) {
						System.arraycopy(cur.board[k], 0, other[k], 0, cur.board[k].length);
					}

					//swap
					temp = other[cur.i][cur.j];
					other[cur.i][cur.j] = other[i][j];
					other[i][j] = temp;
					next = new State(other, i, j);
					if (visited.add(next)) dq.offer(next);
				}
			}

			res++;
		}

		return -1;
	}

	static class State {
		int[][] board;
		int i;
		int j;

		public State(int[][] board, int i, int j) {
			this.board = new int[board.length][board[0].length];
			for (int k = 0; k < board.length; ++k) {
				System.arraycopy(board[k], 0, this.board[k], 0, board[k].length);
			}
			this.i = i;
			this.j = j;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			State other = (State) o;
			return Arrays.deepEquals(board, other.board) && i == other.i && j == other.j;
		}

		@Override
		public int hashCode() {
			int result = 31 * Objects.hash(i, j);
			for (int[] b : board) {
				result = 31 * result + Arrays.hashCode(b);
			}
			return result;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("i=" + i + ", j=" + j + ", board={");
			for (int[] b : board) {
				for (int n : b) sb.append(n + ",");
			}
			return sb.deleteCharAt(sb.length() - 1).append("}").toString();
		}
	}
}