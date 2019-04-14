package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
	public static void main(String[] args) {
		OptimalAccountBalancing optimalAccountBalancing = new OptimalAccountBalancing();
		int[][] transactions = {{0, 6, 10}, {6, 0, 14}, {6, 1, 10}, {0, 3, 3}, {2, 0, 4}, {2, 5, 5}, {4, 2, 5},
				{5, 4, 3}, {4, 3, 2}};
		System.out.println(optimalAccountBalancing.minTransfers(transactions));
	}

	public int minTransfers(int[][] transactions) {
		int[] debt = buildDebtArray(transactions);
		int[] max = new int[2];
		max[1] = Integer.MAX_VALUE;
		List<List<String>> t = new ArrayList<>();
		getMinTransfersAfter(0, debt, max, t, new ArrayList<String>());
		System.out.println(t.get(t.size() - 1));
		return max[1];
	}

	private void getMinTransfersAfter(int curId, int[] debt, int[] max, List<List<String>> t, List<String> cur) {
		while (curId < debt.length && debt[curId] == 0) curId++;
		if (curId == debt.length) {
			if (max[1] > max[0]) {
				t.add(new ArrayList<>(cur));
				max[1] = max[0];
			}
			return;
		}

		for (int i = curId + 1; i < debt.length; i++) {
			if (debt[i] * debt[curId] < 0) {
				debt[i] += debt[curId];
				max[0]++;
				cur.add(curId + "->" + i);
				getMinTransfersAfter(curId + 1, debt, max, t, cur);
				max[0]--;
				debt[i] -= debt[curId];
				cur.remove(cur.size() - 1);
			}
		}
	}

	private int[] buildDebtArray(int[][] transactions) {
		Map<Integer, Integer> debtMap = new HashMap<>();

		for (int[] transaction : transactions) {
			int giver = transaction[0];
			int taker = transaction[1];
			int amount = transaction[2];
			debtMap.put(giver, debtMap.getOrDefault(giver, 0) - amount);
			debtMap.put(taker, debtMap.getOrDefault(taker, 0) + amount);
		}

		int[] debt = new int[debtMap.size()];
		int i = 0;
		for (int amount : debtMap.values()) {
			debt[i++] = amount;
		}

		return debt;
	}
}
