package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestDistanceBetweenBuildings {
	public static void main(String[] args) {
		ShortestDistanceBetweenBuildings sdb = new ShortestDistanceBetweenBuildings();
		int[][] grid = {{1, 0, 2, 0, 1},
				{0, 0, 0, 0, 0}, 
				{0, 0, 1, 0, 0}};
		System.out.println("The shortesr distance between buildings is := " + sdb.shortestDistance(grid));
	}


	class Tuple {
		int x;
		int y;
		int dist;

		public Tuple(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

	}

	public int shortestDistance(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}

		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		int[][] distance = new int[row][col];
		int[][] reach = new int[row][col];
		int totalBuildings = 0;
		Deque<Tuple> q = new ArrayDeque<>();
		Tuple cur = null;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j) {
				if(grid[i][j] == 1) {
					totalBuildings++;
					visited = new boolean[row][col];
					q = new ArrayDeque<>();
					q.offerLast(new Tuple(i, j, 0));
					while(!q.isEmpty()) {
						cur = q.pollFirst();
						propogate(cur.x + 1, cur.y, grid, distance, visited, reach, q, cur.dist + 1);
						propogate(cur.x, cur.y + 1, grid, distance, visited, reach, q, cur.dist + 1);
						propogate(cur.x - 1, cur.y, grid, distance, visited, reach, q, cur.dist + 1);
						propogate(cur.x, cur.y - 1, grid, distance, visited, reach, q, cur.dist + 1);
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j) {
				if(grid[i][j] == 0 && reach[i][j] == totalBuildings) {
					min = Math.min(min, distance[i][j]);
				}
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public void propogate(int i, int j, int[][] grid, int[][] distance, boolean[][] visited, int[][] reach, Deque<Tuple> q, int dist) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 1 || grid[i][j] == 2 || visited[i][j]) {
			return;
		}
		q.offerLast(new Tuple(i, j, dist));
		visited[i][j] = true;
		distance[i][j] += dist;
		reach[i][j]++;
		return;
	}
}
