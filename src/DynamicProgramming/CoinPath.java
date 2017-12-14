package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class CoinPath {

	public static void main(String[] args) {
		int[] A = {1, 2, 4, -1, 2};
		int B = 2;
		System.out.println("The minimum coin path is := " + new CoinPath().cheapestJump(A, B));
	}

	public List<Integer> cheapestJump(int[] A, int B) {
		List<Integer> jumps = new ArrayList<>();

		if(A == null || A.length == 0) {
			return jumps;
		}

		int length = A.length;
		int[] jump = new int[length];
		int[] cost = new int[length];
		int curMin = Integer.MAX_VALUE;
		Arrays.fill(cost, -1);
		cost[0] = A[0];
		jump[0] = 1;

		for(int i = 1; i < length; ++i) {
			if(A[i] != -1) {
				curMin = Integer.MAX_VALUE;
				for(int j = 1; j <= B; ++j) {
					if(i - j >= 0 && cost[i - j] >= 0) {
						if(cost[i - j] + A[i] <= curMin) {
							curMin = cost[i - j] + A[i];
							jump[i] = i - j + 1;
						}
					}
				}

				cost[i] = curMin != Integer.MAX_VALUE ? curMin : cost[i];
			}
		}

		if(cost[length - 1] == -1) {
			return jumps;
		}

		jumps.add(length);
		for(int i = length - 1; i > 0 ;) {
			jumps.add(0, jump[i]);
			i = jump[i] - 1;
		}

		return jumps;
	}
}
