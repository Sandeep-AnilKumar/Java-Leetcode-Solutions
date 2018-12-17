package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class ShortestPathToAllKeys {
	public static void main(String[] args) {
		ShortestPathToAllKeys shortestPathToAllKeys = new ShortestPathToAllKeys();
		String[] grid = {"@.a.A", "###.#", "b...B", "##.Cc"};
		System.out.println("The shortest path to all keys is := " + shortestPathToAllKeys.shortestPathAllKeys(grid));
	}

	public int shortestPathAllKeys(String[] grid) {
		int sI = -1, sJ = -1, max = 0, rows = grid.length, cols = grid[0].length(), keys = 0, target = 0, res = 0, size = 0;
		boolean startFound = false;
		Deque<State> dq = new ArrayDeque<>();
		Set<State> visited = new HashSet<>();
		char c;
		State cur, next;
		int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				c = grid[i].charAt(j);
				if (!startFound && c == '@') {
					startFound = true;
					sI = i;
					sJ = j;
				} else if (c >= 'a' && c <= 'f') {
					max++;
				}
			}
		}

		target = (1 << max) - 1;
		cur = new State(0, sI, sJ);
		dq.offer(cur);
		visited.add(cur);

		while (!dq.isEmpty()) {
			for (size = dq.size(); size > 0; --size) {
				cur = dq.poll();
				if (cur.key == target) return res;
				for (int[] d : dir) {
					sI = cur.i + d[0];
					sJ = cur.j + d[1];
					if (sI < 0 || sJ < 0 || sI >= rows || sJ >= cols) continue;
					c = grid[sI].charAt(sJ);
					keys = cur.key;

					if (c == '#' || (c >= 'A' && c <= 'F' && (keys & (1 << (c - 'A'))) == 0)) continue;
					else if (c >= 'a' && c <= 'f') keys |= (1 << (c - 'a'));
					next = new State(keys, sI, sJ);
					if (visited.add(next)) dq.offer(next);
				}
			}
			res++;
		}

		return -1;
	}

	static class State {
		int key;
		int i;
		int j;

		public State(int key, int i, int j) {
			this.key = key;
			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			return Objects.hash(key, i, j);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || o.getClass() != getClass()) return false;
			State other = (State) o;
			return key == other.key && i == other.i && j == other.j;
		}

		@Override
		public String toString() {
			return "key=" + key + ", i=" + i + ", j=" + j;
		}
	}
}
