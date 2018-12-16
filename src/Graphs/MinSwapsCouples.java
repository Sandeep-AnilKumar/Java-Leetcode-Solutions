package Graphs;

import java.util.HashMap;
import java.util.Map;

public class MinSwapsCouples {
	public static void main(String[] args) {
		MinSwapsCouples minSwapsCouples = new MinSwapsCouples();
		int[] row = {10, 7, 4, 2, 3, 0, 9, 11, 1, 5, 6, 8};
		System.out.println("The number of swaps required are := " + minSwapsCouples.minSwapsCouples(row));
	}

	public int minSwapsCouples(int[] row) {
		int swap = 0, next = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < row.length; ++i) {
			map.put(row[i], i);
		}

		for (int i = 0; i < row.length - 2; i += 2) {
			next = row[i] ^ 1;
			if (next == row[i + 1]) continue;
			row[map.get(next)] = row[i + 1];
			map.put(row[i + 1], map.get(next));
			swap++;
		}
		return swap;
	}
}
