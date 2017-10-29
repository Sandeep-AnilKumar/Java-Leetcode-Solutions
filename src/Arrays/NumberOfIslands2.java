package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class NumberOfIslands2 {

	public static void main(String[] args) {
		char[][] grid = new char[][]{{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},{'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},{'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
		System.out.println("The number of islands in grid is := " + new NumberOfIslands2().numIslandsIterative(grid));
	}

	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;

		int row = grid.length;
		int col = grid[0].length;
		int count = 0;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j) {
				if(grid[i][j] == '1') {
					visitLands(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public void visitLands(char[][] grid, int i, int j) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')  return;
		grid[i][j] = '*';

		visitLands(grid, i + 1, j);
		visitLands(grid, i, j + 1);
		visitLands(grid, i - 1, j);
		visitLands(grid, i, j - 1);
		return;
	}

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public String toString() {
			return this.i + "," + this. j;
		}
	}

	//Iterative version
	public int numIslandsIterative(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;

		int row = grid.length;
		int col = grid[0].length;
		int count = 0;
		Deque<Node> next = new ArrayDeque<>();
		Node cur = null;

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j) {
				if(grid[i][j] == '1') {
					next = new ArrayDeque<>();
					next.offer(new Node(i, j));

					while(!next.isEmpty()) {
						cur = next.poll();
						if(grid[cur.i][cur.j] != '1') continue;
						grid[cur.i][cur.j] = '*';

						if(cur.i + 1 >= 0 && cur.i + 1 < row && grid[cur.i + 1][cur.j] == '1') next.offer(new Node(cur.i + 1, cur.j));
						if(cur.i - 1 >= 0 && cur.i - 1 < row && grid[cur.i - 1][cur.j] == '1') next.offer(new Node(cur.i - 1, cur.j));
						if(cur.j + 1 >= 0 && cur.j + 1 < col && grid[cur.i][cur.j + 1] == '1') next.offer(new Node(cur.i, cur.j + 1));
						if(cur.j - 1 >= 0 && cur.j - 1 < col && grid[cur.i][cur.j - 1] == '1') next.offer(new Node(cur.i, cur.j - 1));
					}
					count++;
				}
			}
		}
		return count;
	}
}
