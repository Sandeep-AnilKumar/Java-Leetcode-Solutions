package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CoinPath {
	class Path {
		int cost;
		List<Integer> indices;

		public Path(int cost, List<Integer> indices) {
			this.cost = cost;
			this.indices = indices;
		}

		public String toString() {
			return this.cost + " -> " + this.indices;
		}
	}

	public static void main(String[] args) {
		CoinPath path = new CoinPath();
		int[] A = {1,2,4,1,2};
		int B = 2;
		System.out.println("The cheapest jump is := " + path.cheapestJumpBetter(A, B));
	}

	//Some odd cases fail and causes TLE for hugs input.
	public List<Integer> cheapestJump(int[] A, int B) {
		if(A[A.length - 1] == -1) return new ArrayList<Integer>();

		PriorityQueue<Path> pq = new PriorityQueue<>(new Comparator<Path>() {
			@Override
			public int compare(Path a, Path b) {
				if(a.cost < b.cost) return -1;
				else if(a.cost > b.cost) return 1;
				else {
					int sum1 = 0;
					int sum2 = 0;

					for(int i: a.indices) {
						sum1 = sum1 * 10 + i;
					}

					for(int j: b.indices) {
						sum2 = sum2 * 10 + j;
					}

					String lex1 = String.valueOf(sum1);
					String lex2 = String.valueOf(sum2);

					return lex1.compareTo(lex2);
				}
			}
		});

		jump(A, B, 1, 0, pq, new ArrayList<Integer>());
		return pq.isEmpty() ? new ArrayList<Integer>() : pq.poll().indices;
	}

	public void jump(int[] cost, int max, int curStep, int curCost, PriorityQueue<Path> pq, List<Integer> indices) {
		if(curStep > cost.length || cost[curStep - 1] == -1) return;

		List<Integer> curIndices = new ArrayList<>(indices);
		if(curStep == cost.length) {
			curIndices.add(curStep);
			curCost += cost[curStep - 1];
			pq.offer(new Path(curCost, curIndices));
			return;
		}

		curIndices.add(curStep);
		curCost += cost[curStep - 1];

		for(int i = 1; i <= max; ++i) {
			jump(cost, max, curStep + i, curCost, pq, curIndices);
		}
		return;
	}

	public List<Integer> cheapestJumpBetter(int[] A, int B) {
		int[] next = new int[A.length];
		Arrays.fill(next, -1);
		long[] memo = new long[A.length];
		jump(A, B, 0, next, memo);
		List <Integer> res = new ArrayList<>();
		int i;
		for (i = 0; i < A.length && next[i] > 0; i = next[i])
			res.add(i + 1);
		if (i == A.length - 1 && A[i] >= 0)
			res.add(A.length);
		else
			return new ArrayList < Integer > ();
		return res;
	}

	public long jump(int[] A, int B, int i, int[] next, long[] memo) {
		if (memo[i] > 0)
			return memo[i];
		if (i == A.length - 1 && A[i] >= 0)
			return A[i];
		long min_cost = Integer.MAX_VALUE;
		for (int j = i + 1; j <= i + B && j < A.length; j++) {
			if (A[j] >= 0) {
				long cost = A[i] + jump(A, B, j, next, memo);
				if (cost < min_cost) {
					min_cost = cost;
					next[i] = j;
				}
			}
		}
		memo[i] = min_cost;
		return min_cost;
	}
}