package Strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class MagicalStrings {

	public static void main(String[] args) {
		MagicalStrings str = new MagicalStrings();
		int n = 14;
		System.out.println("The number of 1 in the first n characters of the magical strings is := " + str.magicalString(n));
	}

	public int magicalString(int n) {
		if(n == 0) return 0;
		if(n <= 3) return 1;

		int prev = 2;
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(2);
		int head = 0;
		int count = 1;
		int cur = 0;
		int total = 4;

		while(total <= n && !dq.isEmpty()) {
			head = dq.poll();
			cur = prev ^ 3;

			for(int j = 0; j < head; ++j) {
				if(cur == 1 && total <= n) count++;
				total++;
				dq.offer(cur);
			}
			prev = cur;
		}

		return count;
	}
}