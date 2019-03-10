package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class GridIllumination {

	Set<Pair> on;
	Map<Pair, List<Pair>> dep;
	Map<Pair, Integer> in;
	int size = 0;
	int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {1, -1}, {0, 1}, {1, 0}, {1, 1}};

	public static void main(String[] args) {
		GridIllumination gridIllumination = new GridIllumination();
		int N = 5;
		int[][] lamps = {{0, 0}, {4, 4}};
		int[][] queries = {{1, 1}, {1, 0}, {0, 0}, {2, 2}, {1, 2}, {1, 4}, {4, 1}};
		System.out.print("The results are := ");
		int[] r = gridIllumination.gridIllumination(N, lamps, queries);
		for (int n : r) {
			System.out.print(n + ", ");
		}
	}

	public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
		on = new HashSet<>();
		dep = new HashMap<>();
		in = new HashMap<>();
		size = N;
		if (lamps == null || lamps.length == 0) {
			if (queries == null || queries.length == 0) return new int[0];
			return new int[queries.length];
		}

		for (int[] lamp : lamps) illuminate(lamp);
		int[] result = new int[queries.length];
		int index = 0;
		for (int[] query : queries) {
			if (on.contains(new Pair(query[0], query[1]))) result[index++] = 1;
			off(query);
		}
		return result;
	}

	private void illuminate(int[] l) {
		Pair lamp = new Pair(l[0], l[1]);
		on.add(lamp);
		if (!dep.containsKey(lamp)) dep.put(lamp, new ArrayList<>());
		in.put(lamp, in.getOrDefault(lamp, 0) + 1);
		Pair next;
		for (int[] d : dir) {
			next = new Pair(lamp.i + d[0], lamp.j + d[1]);
			while (next.i >= 0 && next.j >= 0 && next.i < size && next.j < size) {
				in.put(next, in.getOrDefault(next, 0) + 1);
				dep.get(lamp).add(next);
				on.add(next);
				next = new Pair(next.i + d[0], next.j + d[1]);
			}
		}
	}

	private void off(int[] q) {
		Pair query = new Pair(q[0], q[1]);
		if (dep.containsKey(query)) {
			for (Pair d : dep.get(query)) {
				in.put(d, in.get(d) - 1);
				if (in.get(d) <= 0) {
					on.remove(d);
					in.remove(d);
				}
			}
			dep.remove(query);
		}

		if (in.containsKey(query)) {
			in.put(query, in.get(query) - 1);
			if (in.get(query) <= 0) {
				on.remove(query);
				in.remove(query);
			}
		}

		Pair next;
		for (int[] d : dir) {
			next = new Pair(query.i + d[0], query.j + d[1]);
			if (next.i >= 0 && next.j >= 0 && next.i < size && next.j < size) {
				if (dep.containsKey(next)) {
					for (Pair de : dep.get(next)) {
						in.put(de, in.get(de) - 1);
						if (in.get(de) <= 0) {
							on.remove(de);
							in.remove(de);
						}
					}
					dep.remove(next);
				}
				if (in.containsKey(query)) {
					in.put(query, in.get(query) - 1);
					if (in.get(query) <= 0) {
						on.remove(query);
						in.remove(query);
					}
				}
			}
		}
	}

	class Pair {
		int i;
		int j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public boolean equals(Object other) {
			if (this == other) return true;
			if (other == null || other.getClass() != getClass()) return false;
			Pair o = (Pair) other;
			return this.i == o.i && this.j == o.j;
		}

		@Override
		public int hashCode() {
			return Objects.hash(i, j);
		}
	}
}
