package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class LargestRectangleArea {

	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		System.out.println("The largest rectangle area is := " + new LargestRectangleArea().largestRectangleArea(heights));
	}

	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) {
			return 0;
		}

		Deque<Integer> stack = new ArrayDeque<>();
		stack.offerLast(-1);
		int length = heights.length;
		int max = 0;

		for(int i = 0; i <= length; ++i) {
			while(stack.peekLast() != -1 && (i == length || heights[i] <= heights[stack.peekLast()])) {
				max = Math.max(max, heights[stack.pollLast()] * (i - (stack.peekLast()) - 1));
			}
			stack.offerLast(i);
		}

		return max;
	}
}
