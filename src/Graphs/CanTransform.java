package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class CanTransform {
	public static void main(String[] args) {
		CanTransform canTransform = new CanTransform();
		String start = "XLLR";
		String end = "LXLX";
		System.out.println(canTransform.canTransform(start, end));
	}

	public boolean canTransform(String start, String end) {
		Set<String> visited = new HashSet<>();
		Deque<String> dq = new ArrayDeque<>();
		dq.offer(start);
		String cur = "", sub = "", next = "";

		while (!dq.isEmpty()) {
			cur = dq.poll();
			System.out.println(cur);
			if (visited.contains(cur)) continue;
			if (cur.equals(end)) return true;
			visited.add(start);

			for (int i = 0; i < cur.length() - 1; ++i) {
				sub = cur.substring(i, i + 2);
				next = "";
				if (sub.equals("RX")) {
					next = cur.substring(0, i) + "XR" + cur.substring(i + 2);
				} else if (sub.equals("XL")) {
					next = cur.substring(0, i) + "LX" + cur.substring(i + 2);
				}

				if (next.length() > 0 && !visited.contains(next)) dq.offer(next);
			}
		}
		return false;
	}
}
