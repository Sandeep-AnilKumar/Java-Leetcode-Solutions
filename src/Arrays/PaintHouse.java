package Arrays;

public class PaintHouse {
	static int min = 0;
	public static void main(String[] args) {
		int[][] costs = {{20,2,1},{100,1000,980},{100,2,2}};
		System.out.println("The minimum cost to paint the house are := " + minCost(costs));
	}

	public static int minCost(int[][] costs) {
		if (costs.length == 0) {
			return 0;
		}
		int min1 = 0, min2 = 0, index1 = -1;

		for (int i = 0; i < costs.length; i++) {
			int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx1 = -1;

			for (int j = 0; j < costs[0].length; j++) {
				int cost = costs[i][j] + (j != index1 ? min1 : min2);

				if (cost < m1) {
					m2 = m1; m1 = cost; idx1 = j; 

				} else if (cost < m2) {
					m2 = cost;
				}
			}

			min1 = m1; min2 = m2; index1 = idx1;
		}
		return min1;
	}
}
