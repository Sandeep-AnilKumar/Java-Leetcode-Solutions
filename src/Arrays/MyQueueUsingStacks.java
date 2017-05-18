package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueueUsingStacks {

	Deque<Integer> stack1;
	Deque<Integer> stack2;

	public MyQueueUsingStacks() {
		stack1 = new ArrayDeque<>();
		stack2 = new ArrayDeque<>();
	}

	//	public void enqueue(int val) {
	//		if(!stack2.isEmpty()) {
	//			while(!stack2.isEmpty()) {
	//				stack1.offerFirst(stack2.pollFirst());
	//			}
	//		}
	//		stack1.offerFirst(val);
	//	}
	//
	//	public int dequeue() {
	//		if(stack2.isEmpty()) {
	//			while(!stack1.isEmpty()) {
	//				stack2.offerFirst(stack1.pollFirst());
	//			}
	//		}
	//		if(stack2.isEmpty()) {
	//			throw new NullPointerException();
	//		}
	//		return stack2.pollFirst();
	//	}


	//A much more efficient implementation.

	public void enqueue(int value) {
		stack1.offerFirst(value);
	}

	public void shiftStacks() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.offerFirst(stack1.pollFirst());
			}
		}
	}

	public int dequeue() throws Exception {
		shiftStacks();
		if(stack2.isEmpty()) {
			throw new Exception("Trying to poll an empty queue");
		}
		return stack2.pollFirst();
	}

	public int peek() throws Exception {
		shiftStacks();
		if(stack2.isEmpty()) {
			throw new Exception("Trying to peek an empty queue");
		}
		return stack2.peekFirst();
	}

	public static void main(String[] args) throws Exception {
		MyQueueUsingStacks queue = new MyQueueUsingStacks();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(45);
		System.out.println("Dequeue value is := " + queue.dequeue());
		queue.enqueue(55);
		System.out.println("Dequeue value is := " + queue.dequeue());
		System.out.println("The head of the queue is := " + queue.peek());
	}
}
