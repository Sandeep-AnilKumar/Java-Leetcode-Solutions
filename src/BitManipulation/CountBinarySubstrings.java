package BitManipulation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class CountBinarySubstrings {

	public static void main(String[] args) {
		String s = "11001100";
		System.out.println("The number of binary substrings are := " + new CountBinarySubstrings().countBinarySubstrings(s));
	}

	public int countBinarySubstrings(String s) {
		int length = s.length(), count = 0, curCount = 0, pre = s.charAt(0), index = 0;
		Deque<Integer> counts = new ArrayDeque<>();

		for(; index < length; ++index) {
			curCount = 0;
			while(index < length && s.charAt(index) == pre) {
				curCount++; index++;
			}
			pre ^= 1;
			counts.offer(curCount);

			if(!counts.isEmpty() && counts.size() == 2) count += Math.min(counts.poll(), counts.peek());

			index--;
		}
		return count;
	}

	public int countBinarySubstringsAlt(String s) {
		int ans = 0, prev = 0, cur = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i-1) != s.charAt(i)) {
				ans += Math.min(prev, cur);
				prev = cur;
				cur = 1;
			} else {
				cur++;
			}
		}
		return ans + Math.min(prev, cur);
	}
}
