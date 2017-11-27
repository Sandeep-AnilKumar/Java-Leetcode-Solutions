package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class FloodFillImage {

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1, sc = 1, newColor = 2;

		System.out.println("The flood filled image is := ");
		image = new FloodFillImage().floodFill(image, sr, sc, newColor);
		for(int[] row: image) {
			System.out.print("[");
			for(int n: row) {
				System.out.print(n);
			}
			System.out.println("]");
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int rows = image.length, cols = image[0].length, val = image[sr][sc], cur = 0;
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		boolean[][] visited = new boolean[rows][cols];
		Deque<int[]> dq = new ArrayDeque<>();
		int[] next = new int[2];

		dq.offer(new int[]{sr, sc});

		while(!dq.isEmpty()) {
			next = dq.poll();

			if(next[0] >= 0 && next[0] < rows && next[1] >= 0 && next[1] < cols && !visited[next[0]][next[1]]) {

				cur = image[next[0]][next[1]];

				if(cur == val) {
					image[next[0]][next[1]] = newColor;
					visited[next[0]][next[1]] = true;

					for(int[] dir: dirs) {
						dq.offer(new int[]{next[0] + dir[0], next[1] + dir[1]});
					}
				}
			}
		}
		return image;
	}
}
