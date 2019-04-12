package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class FrogJump {
	public static void main(String[] args) {
		FrogJump frogJump = new FrogJump();
		int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
		System.out.println(frogJump.canCross(stones));
	}

	public boolean canCross(int[] stones) {

		Stone cur = new Stone(0, 1), next;
		int dest = stones[stones.length - 1];

		Deque<Stone> dq = new ArrayDeque<>();
		Set<Stone> visited = new HashSet<>();
		Set<Integer> units = new HashSet<>();

		for (int stone : stones) units.add(stone);
		dq.offer(cur);

		while (!dq.isEmpty()) {
			cur = dq.poll();
			if (visited.contains(cur) || cur.k == 0) continue;
			if (cur.unit == dest) return true;
			visited.add(cur);

			for (int j = -1; j <= 1; ++j) {
				if (units.contains(cur.unit + cur.k)) {
					next = new Stone(cur.unit + cur.k, cur.k + j);
					if (!visited.contains(next)) dq.offer(next);
				}
			}
		}
		return false;
	}

	static class Stone {
		int unit;
		int k;

		public Stone(int unit, int k) {
			this.unit = unit;
			this.k = k;
		}

		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || o.getClass() != getClass()) return false;
			Stone other = (Stone) o;
			return unit == other.unit && k == other.k;
		}

		public int hashCode() {
			return Objects.hash(unit, k);
		}
	}
}
