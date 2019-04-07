package Arrays;

import java.util.Stack;

public class MinStack {
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(0);
		stack.push(1);
		stack.push(0);
		stack.push(1);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.getMin());
	}

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.pop() == min) min = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}