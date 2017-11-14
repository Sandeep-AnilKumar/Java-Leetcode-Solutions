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

			if(!counts.isEmpty() && counts.size() == 2) {
				count += Math.min(counts.poll(), counts.peek());
			}

			index--;
		}
		return count;
	}
}
