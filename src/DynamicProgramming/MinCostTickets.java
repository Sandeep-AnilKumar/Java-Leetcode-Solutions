package DynamicProgramming;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MinCostTickets {
	public static void main(String[] args) {
		MinCostTickets minCostTickets = new MinCostTickets();
		int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
		int[] costs = {2, 7, 15};
		System.out.println("Min cost to buy tickets is := " + minCostTickets.mincostTickets(days, costs));
	}

	public int mincostTickets(int[] days, int[] costs) {
		int lastDay = days[days.length - 1];
		int[] dp = new int[lastDay + 1];
		Set<Integer> daySet = Arrays.stream(days).boxed().collect(Collectors.toSet());
		int[] da = {1, 7, 30};

		for (int day = 1; day <= lastDay; ++day) {
			dp[day] = Integer.MAX_VALUE;

			if (!daySet.contains(day)) {
				dp[day] = dp[day - 1];
				continue;
			}

			for (int i = 0; i < costs.length; ++i) {
				if (day - da[i] >= 0) {
					dp[day] = Math.min(dp[day], dp[day - da[i]] + costs[i]);
				} else {
					dp[day] = Math.min(dp[day], dp[0] + costs[i]);
				}
			}
		}

		return dp[lastDay] != Integer.MAX_VALUE ? dp[lastDay] : costs[0] * lastDay;
	}
}
