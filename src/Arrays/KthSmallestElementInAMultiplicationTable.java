package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInAMultiplicationTable {

	public static void main(String[] args) {
		KthSmallestElementInAMultiplicationTable table = new KthSmallestElementInAMultiplicationTable();
		int m = 3;
		int n = 3;
		int k = 5;

		System.out.println("The " + k + "th smallest element in the multiplication number is := " + table.findKthNumber(m, n, k));
	}
	
	//Not a very efficient solution for large m and n.
	public int findKthNumber(int m, int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		for(int i = 1; i <= m; ++i) {
			for(int j = 1; j <= n; ++j) {
				pq.offer(i * j);
			}
		}

		int curSmall = 1;
		while(k-- > 0) {
			curSmall = pq.poll();
		}
		return curSmall;
	}
}
