package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiagonalTraversal {
	public static void main(String[] args) {
		DiagonalTraversal diagonalTraversal = new DiagonalTraversal();

		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[] order = diagonalTraversal.findDiagonalOrder(matrix);
		System.out.print("The diagonal order is := ");
		for (int n : order) System.out.print(n + ", ");
		System.out.println();

		matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		order = diagonalTraversal.findDiagonalOrder(matrix);
		System.out.print("The diagonal order is := ");
		for (int n : order) System.out.print(n + ", ");
		System.out.println();

		matrix = new int[][]{{1}, {2}, {3}, {4}};
		order = diagonalTraversal.findDiagonalOrder(matrix);
		System.out.print("The diagonal order is := ");
		for (int n : order) System.out.print(n + ", ");
		System.out.println();

		matrix = new int[][]{{1, 2, 3, 4}};
		order = diagonalTraversal.findDiagonalOrder(matrix);
		System.out.print("The diagonal order is := ");
		for (int n : order) System.out.print(n + ", ");
		System.out.println();

		matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		order = diagonalTraversal.findDiagonalOrder(matrix);
		System.out.print("The diagonal order is := ");
		for (int n : order) System.out.print(n + ", ");
		System.out.println();
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return new int[0];

		int m = matrix.length, n = matrix[0].length, nI = 0, nJ = 0, index = 0;

		int[] d = new int[m * n];
		Deque<Num> dq = new ArrayDeque<>();

		int[][] dir = {{0, 1}, {1, 0}};

		dq.offer(new Num(0, 0, new int[]{-1, 1}));
		Num cur;

		while (!dq.isEmpty()) {
			cur = dq.pollLast();
			nI = cur.i + cur.dir[0];
			nJ = cur.j + cur.dir[1];

			d[index++] = matrix[cur.i][cur.j];

			if (cur.dir[0] == -1 && cur.dir[1] == 1) {
				if (isInLimit(nI, nJ, m, n)) {
					dq.offer(new Num(nI, nJ, cur.dir));
				} else {
					for (int i = 0; i < dir.length; ++i) {
						nI = cur.i + dir[i][0];
						nJ = cur.j + dir[i][1];

						if (isInLimit(nI, nJ, m, n)) {
							dq.offer(new Num(nI, nJ, new int[]{1, -1}));
							break;
						}
					}
				}
			} else {
				if (isInLimit(nI, nJ, m, n)) {
					dq.offer(new Num(nI, nJ, cur.dir));
				} else {
					for (int i = dir.length - 1; i >= 0; --i) {
						nI = cur.i + dir[i][0];
						nJ = cur.j + dir[i][1];

						if (isInLimit(nI, nJ, m, n)) {
							dq.offer(new Num(nI, nJ, new int[]{-1, 1}));
							break;
						}
					}
				}
			}
		}

		return d;
	}

	private boolean isInLimit(int i, int j, int m, int n) {
		return (i >= 0 && j >= 0 && i < m && j < n);
	}

	class Num {
		int i;
		int j;
		int[] dir;

		public Num(int i, int j, int[] dir) {
			this.i = i;
			this.j = j;
			this.dir = new int[2];
			System.arraycopy(dir, 0, this.dir, 0, dir.length);
		}
	}
}
