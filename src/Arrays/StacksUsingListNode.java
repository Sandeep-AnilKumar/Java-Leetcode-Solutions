package Arrays;

public class StacksUsingListNode {

	MyNode stack;
	MyNode minStack;

	StacksUsingListNode() {
		stack = new MyNode(0);
		minStack = new MyNode(0);
	}

	public void push(int val) {
		MyNode cur = new MyNode(val);
		cur.next = stack.next;
		stack.next = cur;
		addMin(val);
		return;
	}

	public boolean isEmpty() {
		return stack.next == null;
	}

	public int pop() {
		if(stack.next == null) {
			throw new NullPointerException();
		}

		MyNode cur = stack.next;
		stack.next = cur.next;
		removeMin(cur.val);
		return cur.val;
	}

	public int peek() {
		if(stack.next == null) {
			throw new NullPointerException();
		}

		return stack.next.val;
	}

	public int min() {
		if(minStack.next == null) {
			throw new NullPointerException();
		}
		return minStack.next.val;
	}

	public void addMin(int val) {
		if(minStack.next == null) {
			minStack.next = new MyNode(val);
			return;
		}

		if(val <= minStack.next.val) {
			MyNode cur = minStack.next;
			minStack.next = new MyNode(val);
			minStack.next.next = cur;
		}
		return;
	}

	public void removeMin(int val) {
		if(val == minStack.next.val) {
			minStack.next = minStack.next.next;
		}
		return;
	}

	@Override
	public String toString() {
		if(stack.next == null) {
			return null;
		}
		return stack.next.toString();
	}

	public static void main(String[] args) {
		StacksUsingListNode st = new StacksUsingListNode();
		st.push(3);
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.push(3);
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.pop();
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.push(2);
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.pop();
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.pop();
		System.out.println(st);
		st.push(28);
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.push(2);
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.push(3);
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.push(1);
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.pop();
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.pop();
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
		st.pop();
		System.out.println(st);
		System.out.println("The current min is := " + st.min());
	}
}
