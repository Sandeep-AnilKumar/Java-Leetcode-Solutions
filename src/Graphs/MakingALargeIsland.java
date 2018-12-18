package Graphs;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
	private int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	private int rows = 0, cols = 0;
	private int[][] g;
	private String[][] s;

	public static void main(String[] args) {
		MakingALargeIsland makingALargeIsland = new MakingALargeIsland();
		int[][] grid = {{1, 1}, {1, 0}};
		System.out.println("The largest island by turning at most one 0 to 1 is := " + makingALargeIsland.largestIsland(grid));
	}

	public int largestIsland(int[][] grid) {
		g = grid;
		rows = grid.length;
		cols = grid[0].length;
		s = new String[rows][cols];
		boolean[][] visited = new boolean[rows][cols];
		int total, nextI, nextJ;
		String cur;
		Set<String> seen;
		String[] parts;
		int max = 0;

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					cur = i * cols + j + "";
					total = dfs(i, j, visited);
					max = Math.max(max, total);
					propagate(i, j, cur + "," + total, new boolean[rows][cols]);
				}
			}
		}

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (grid[i][j] == 0) {
					total = 1;
					seen = new HashSet<>();
					for (int[] d : dir) {
						nextI = i + d[0];
						nextJ = j + d[1];
						if (isValid(nextI, nextJ) && s[nextI][nextJ] != null && !seen.contains(s[nextI][nextJ])) {
							parts = s[nextI][nextJ].split(",");
							total += Integer.parseInt(parts[1]);
							seen.add(s[nextI][nextJ]);
						}
					}
					max = Math.max(max, total);
				}
			}
		}
		return max;
	}

	private boolean isValid(int i, int j) {
		return i >= 0 && j >= 0 && i <= rows - 1 && j <= cols - 1;
	}

	private int dfs(int i, int j, boolean[][] visited) {
		if (!isValid(i, j)) return 0;
		if (g[i][j] == 0 || visited[i][j]) return 0;
		int res = 1;
		visited[i][j] = true;

		for (int[] d : dir) {
			res += dfs(i + d[0], j + d[1], visited);
		}
		return res;
	}

	private void propagate(int i, int j, String cur, boolean[][] visited) {
		if (!isValid(i, j)) return;
		if (g[i][j] == 0 || visited[i][j]) return;
		visited[i][j] = true;
		s[i][j] = cur;

		for (int[] d : dir) {
			propagate(i + d[0], j + d[1], cur, visited);
		}
	}
}
