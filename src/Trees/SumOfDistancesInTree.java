package Trees;

import java.util.Arrays;

public class SumOfDistancesInTree {
	public static void main(String[] args) {
		SumOfDistancesInTree distancesInTree = new SumOfDistancesInTree();
		int[][] edges = {{1, 2}, {2, 0}, {0, 3}};
		int[] distances = distancesInTree.sumOfDistancesInTree(4, edges);
		for (int d : distances) System.out.println(d);
	}

	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		int[][] dist = new int[N][N];
		for (int[] a : dist) Arrays.fill(a, Integer.MAX_VALUE);
		for (int i = 0; i < N; ++i) dist[i][i] = 0;
		for (int[] e : edges) {
			dist[e[0]][e[1]] = 1;
			dist[e[1]][e[0]] = 1;
		}

		int[] total = new int[N];

		for (int i = 0; i < N; ++i) {
			for (int k = 0; k < N; ++k) {
				for (int j = 0; j < N; ++j) {
					if (i != j && j != k && i != k &&
							dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
						if (dist[i][k] + dist[k][j] < dist[i][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
							dist[j][i] = dist[i][j];
						}
					}
				}
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				total[i] += dist[i][j];
			}
		}
		return total;
	}
}
