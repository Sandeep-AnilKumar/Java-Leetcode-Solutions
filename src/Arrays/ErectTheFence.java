package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErectTheFence {

	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }

		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}

	}

	public static void main(String[] args) {
		ErectTheFence fence = new ErectTheFence();

		Point[] points = new Point[6];

		//[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]

		points[0] = new Point(1,1);
		points[1] = new Point(2,2);
		points[2] = new Point(2,0);
		points[3] = new Point(2,4);
		points[4] = new Point(3,3);
		points[5] = new Point(4,2);

		System.out.println(fence.outerTrees(points));
	}

	//Using Gift Wrapping / Jarvis March

	public List<Point> outerTrees(Point[] points) {
		Set<Point> result = new HashSet<>();

		// Find the leftmost point
		Point first = points[0];
		int firstIndex = 0;
		for (int i = 1; i < points.length; i++) {
			if (points[i].x < first.x) {
				first = points[i];
				firstIndex = i;
			}
		}
		result.add(first);

		Point cur = first;
		int curIndex = firstIndex;
		do {
			Point next = points[0];
			int nextIndex = 0;
			for (int i = 1; i < points.length; i++) {
				if (i == curIndex) continue;
				int cross = crossProductLength(cur, points[i], next);
				if (nextIndex == curIndex || cross > 0 ||
						// Handle collinear points
						(cross == 0 && distance(points[i], cur) > distance(next, cur))) {
					next = points[i];
					nextIndex = i;
				}
			}

			// Handle collinear points
			for (int i = 0; i < points.length; i++) {
				if (i == curIndex) continue;
				int cross = crossProductLength(cur, points[i], next);
				if (cross == 0) {
					result.add(points[i]);
				}
			}

			cur = next;
			curIndex = nextIndex;

		} while (curIndex != firstIndex);

		return new ArrayList<Point>(result);
	}

	private int crossProductLength(Point A, Point B, Point C) {
		// Get the vectors' coordinates.
		int BAx = A.x - B.x;
		int BAy = A.y - B.y;
		int BCx = C.x - B.x;
		int BCy = C.y - B.y;

		// Calculate the Z coordinate of the cross product.
		return (BAx * BCy - BAy * BCx);
	}

	private int distance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
}
