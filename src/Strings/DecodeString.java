package Strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class DecodeString {

	public static void main(String[] args) {
		String s = "f3[a3[b]2[c]]4[de]ghij";
		System.out.println("The decoded string is := " + new DecodeString().decodeString(s));
	}

	public String decodeString(String s) {
		Deque<String> result = new ArrayDeque<>();
		Deque<Integer> count = new ArrayDeque<>();
		int times = 0, index = 0, next = 0, length = s.length();
		char c;
		String repeat = "";
		StringBuilder sb = new StringBuilder();
		result.offerLast("");

		while(index < length) {
			c = s.charAt(index);
			if(c >= '0' && c <= '9') {
				next = index;
				while(next < length && s.charAt(next) >= '0' && s.charAt(next) <= '9') {
					next++;
				}

				times = Integer.parseInt(s.substring(index, next));
				count.offerLast(times);
				index = next - 1;

			} else if(c == '[') {
				result.offerLast("");

			} else if(c == ']') {
				repeat = result.pollLast();
				times = count.pollLast();
				sb = new StringBuilder();
				while(times-- > 0) {
					sb.append(repeat);
				}

				result.offerLast(result.pollLast() + sb.toString());

			} else {
				result.offerLast(result.pollLast() + c);
			}

			index++;
		}

		return result.pollLast();
	}
}
