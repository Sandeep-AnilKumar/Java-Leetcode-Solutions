package DynamicProgramming;

/**
 * @author sandeepa
 */

public class PaintHouse2 {

	public static void main(String[] args) {
		int[][] costs = {{2, 3, 4, 6}, 
				{2, 4, 5, 2}, 
				{3, 5, 3, 4}, 
				{4, 5, 6, 3}, 
				{1, 6, 3, 6}};

		System.out.println("The minimum cost to paint adjacent houses with different colors is := " + new PaintHouse().minCost(costs));
	}

	public int minCostII(int[][] costs) {
		if(costs == null || costs.length == 0) {
			return 0;
		}

		int houses = costs.length;
		int colors = costs[0].length;
		int totalCost = 0;
		int curCost = 0;

		for(int house = houses - 2; house >= 0; --house) {
			for(int color = 0; color < colors; ++color) {
				curCost = Integer.MAX_VALUE;
				for(int otherColor = 0; otherColor < colors; ++otherColor) {
					if(color != otherColor) {
						curCost = Math.min(curCost, costs[house][color] + costs[house + 1][otherColor]);
					}
				}
				costs[house][color] = curCost;
			}
		}

		totalCost = costs[0][0];
		for(int color = 1; color < colors; ++color) {
			totalCost = Math.min(totalCost, costs[0][color]);
		}

		return totalCost;
	}
}
