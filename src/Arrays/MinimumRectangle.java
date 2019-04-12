package Arrays;

import java.util.TreeSet;

public class MinimumRectangle {
	public static void main(String[] args) {
		MinimumRectangle minimumRectangle = new MinimumRectangle();
		int[][] points = {{0, 1}, {1, 3}, {3, 3}, {4, 4}, {1, 4}, {2, 3}, {1, 0}, {3, 4}};
		System.out.println(minimumRectangle.minAreaRect(points));
	}

	public int minAreaRect(int[][] points) {
		TreeSet<int[]> x = new TreeSet<>((a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		TreeSet<int[]> y = new TreeSet<>((a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		for (int[] point : points) {
			x.add(point);
			y.add(point);
		}

		int[] nextX, nextY, diag;
		int min = Integer.MAX_VALUE;

		for (int[] point : points) {
			nextX = x.higher(point);
			nextY = y.higher(point);

			if (nextX != null && nextY != null && nextX != nextY && nextX[0] == point[0] && nextY[1] == point[1]) {

				diag = new int[]{nextY[0], nextX[1]};
				if (x.contains(diag)) {
					min = Math.min(min, (nextX[1] - point[1]) * (nextY[0] - point[0]));
				}
			}

			nextX = x.lower(point);
			nextY = y.lower(point);

			if (nextX != null && nextY != null && nextX != nextY && nextX[0] == point[0] && nextY[1] == point[1]) {

				diag = new int[]{nextY[0], nextX[1]};
				if (x.contains(diag)) {
					min = Math.min(min, (nextX[1] - point[1]) * (nextY[0] - point[0]));
				}
			}

			nextX = x.lower(point);
			nextY = y.higher(point);

			if (nextX != null && nextY != null && nextX != nextY && nextX[0] == point[0] && nextY[1] == point[1]) {

				diag = new int[]{nextY[0], nextX[1]};
				if (x.contains(diag)) {
					min = Math.min(min, (nextX[1] - point[1]) * (nextY[0] - point[0]));
				}
			}

			nextX = x.higher(point);
			nextY = y.lower(point);

			if (nextX != null && nextY != null && nextX != nextY && nextX[0] == point[0] && nextY[1] == point[1]) {

				diag = new int[]{nextY[0], nextX[1]};
				if (x.contains(diag)) {
					min = Math.min(min, (nextX[1] - point[1]) * (nextY[0] - point[0]));
				}
			}

			if (min < 0) {
				min = -min;
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
