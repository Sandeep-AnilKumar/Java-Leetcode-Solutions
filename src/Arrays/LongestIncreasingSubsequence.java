package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sandeepa
 */

public class LongestIncreasingSubsequence {
	public static List<Integer> lis(List<Integer> sequence) {
		List<Node> path = new ArrayList<Node>();

		for (Integer n : sequence) {
			Node node = new Node();
			node.value = n;
			int i = binarySearch(path, n);

			if (i < 0) i = ~i;

			if (i != 0)
				node.pointer = path.get(i - 1);

			if (i != path.size())
				path.set(i, node);
			else
				path.add(node);
		}

		List<Integer> result = new ArrayList<Integer>();
		for (Node node = path.size() == 0 ? null : path.get(path.size() - 1); node != null; node = node.pointer)
			result.add(node.value);
		Collections.reverse(result);
		return result;
	}

	private static class Node {
		public int value;
		public Node pointer;
		public String toString() { return this.value + " -> " + this.pointer; }
	}

	private static int binarySearch(List<Node> pile, int key) {
		int low = 0; int high = pile.size() - 1; int mid = 0;
		while (low <= high) {
			mid = low + ((high - low) >>> 1);

			if (pile.get(mid).value == key) return mid;
			else if (pile.get(mid).value < key) low = mid + 1;
			else high = mid - 1;
		}
		return - (low + 1);
	}

	public static void main(String[] args) {
		List<Integer> d = Arrays.asList(0, 8, 4, 12, 2);
		System.out.printf("an L.I.S. of %s is %s\n", d, lis(d));
	}
}