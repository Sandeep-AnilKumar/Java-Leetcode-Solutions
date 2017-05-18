package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

//Sorting a stack, using only one additional stack. With the top element being the highest value. O(n2) time, O(n) space.
public class SortingStack {
	Deque<Integer> sortedStack;

	SortingStack() {
		sortedStack = new ArrayDeque<>();
	}

	public Deque<Integer> sort(Deque<Integer> stack) {
		int temp = 0;
		while(!stack.isEmpty()) {
			temp = stack.pollFirst();
			while(!sortedStack.isEmpty() && sortedStack.peekFirst() > temp) {
				stack.offerFirst(sortedStack.pollFirst());
			}
			sortedStack.offerFirst(temp);
		}
		return sortedStack;
	}

	public static void main(String[] args) {
		Deque<Integer> unsortedStack = new ArrayDeque<>();
		unsortedStack.offerFirst(12);
		unsortedStack.offerFirst(1);
		unsortedStack.offerFirst(34);
		unsortedStack.offerFirst(8);
		unsortedStack.offerFirst(6);
		unsortedStack.offerFirst(5);
		unsortedStack.offerFirst(22);
		unsortedStack.offerFirst(34);
		unsortedStack.offerFirst(89);

		SortingStack sortStack = new SortingStack();
		unsortedStack = sortStack.sort(unsortedStack);

		System.out.println(unsortedStack);
	}
}
