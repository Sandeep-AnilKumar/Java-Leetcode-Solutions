package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

class ShortestBridge {
	int rows = 0;
	int cols = 0;
	int[][] N;
	int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

	public static void main(String[] args) {
		ShortestBridge shortestBridge = new ShortestBridge();
		int[][] A = {{0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 0, 0}};
		System.out.println("The shortest bridge is := " + shortestBridge.shortestBridge(A));
	}

	public int shortestBridge(int[][] A) {
		N = A;
		rows = A.length;
		cols = A[0].length;
		Deque<int[]> dq = new ArrayDeque<>();
		int i = 0, j = 0, nI = 0, nJ = 0, res = 0;
		int[] cur;
		boolean found = false;
		while (i < rows) {
			found = false;
			j = 0;
			while (j < cols) {
				if (A[i][j] == 1) {
					found = true;
					break;
				}
				++j;
			}
			if (found) break;
			++i;
		}

		propagate(A, i, j, dq);

		while (!dq.isEmpty()) {
			for (int size = dq.size(); size > 0; --size) {
				cur = dq.poll();
				if (A[cur[0]][cur[1]] == 1) return res;
				for (int[] d : dir) {
					nI = cur[0] + d[0];
					nJ = cur[1] + d[1];
					if (check(nI, nJ)) {
						if (A[nI][nJ] == 1) return res;
						dq.offer(new int[]{nI, nJ});
						A[nI][nJ] = -1;
					}
				}
			}
			res++;
		}
		return res;
	}

	private boolean check(int i, int j) {
		return i >= 0 && j >= 0 && i < rows && j < cols && N[i][j] != -1;
	}

	private void propagate(int[][] nums, int i, int j, Deque<int[]> dq) {
		if (i < 0 || j < 0 || i >= rows || j >= cols || N[i][j] != 1) return;
		nums[i][j] = -1;
		dq.offer(new int[]{i, j});
		for (int[] d : dir) {
			propagate(nums, i + d[0], j + d[1], dq);
		}
	}
}
