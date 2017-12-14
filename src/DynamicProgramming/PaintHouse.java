package DynamicProgramming;

/**
 * @author sandeepa
 */

public class PaintHouse {

	public static void main(String[] args) {
		int[][] costs = {{2, 3, 1}, 
				{2, 4, 5}, 
				{3, 1, 3}, 
				{4, 5, 6}};

		System.out.println("The minimum cost to paint adjacent houses with different colors is := " + new PaintHouse().minCost(costs));
	}

	public int minCost(int[][] costs) {
		if(costs == null || costs.length == 0) {
			return 0;
		}

		int houses = costs.length;
		int colors = costs[0].length;
		int totalCost = 0;

		for(int house = houses - 2; house >= 0; --house) {
			for(int color = 0; color < colors; ++color) {
				costs[house][color] += Math.min(costs[house + 1][(color + 1) % colors], costs[house + 1][(color + 2) % colors]);
			}
		}

		totalCost = costs[0][0];
		for(int color = 1; color < colors; ++color) {
			totalCost = Math.min(totalCost, costs[0][color]);
		}

		return totalCost;
	}
}
