package Strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class MaxAbsoluteFilePath {

	public static void main(String[] args) {
		MaxAbsoluteFilePath path = new MaxAbsoluteFilePath();
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println("The longest absolute file path is := " + path.lengthLongestPath(input));
		input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext\ndir2\n\tsubdir1234567890\n\t\tfile33222.txt";
		System.out.println("The longest absolute file path is := " + path.lengthLongestPath(input));
		input = "dir\n        file.txt";
		System.out.println("The longest absolute file path is := " + path.lengthLongestPath(input));
	}

	public int lengthLongestPath(String input) {
		if(input == null || input.length() == 0) {
			return 0;
		}

		String[] parts = input.split("\n");
		int prev = 0;
		int level = 0;
		int max = 0;
		int cur = 0;
		Deque<Integer> stack = new ArrayDeque<>();

		for (String part : parts) {
			level = parse(part);

			while (stack.size() > level) {
				prev -= stack.pollLast();
			}

			cur = part.trim().length() + 1;
			prev += cur;

			if (part.contains(".") && max < (prev - 1)) {
				max = prev - 1;
			}
			stack.offerLast(cur);
		}
		return max;
	}

	public int parse(String input) {
		if(input == null || input.length() == 0) {
			return 0;
		}

		int count = 0;
		int space = 0;
		int length = input.length();
		for(int i = 0; i < length; ++i) {
			if(input.charAt(i) == '\t') {
				count++;
			} else if(input.charAt(i) == ' ') {
				space = 0;
				while(i < length && input.charAt(i) == ' ') {
					space++;
					i++;
				}
				count += space / 4;
				i--;
			}
		}

		return count;
	}
}
