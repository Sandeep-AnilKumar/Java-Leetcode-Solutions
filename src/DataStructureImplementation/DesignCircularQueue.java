package DataStructureImplementation;

public class DesignCircularQueue {

	int k, size;
	Node front, rear;

	/**
	 * Initialize your data structure here. Set the size of the queue to be k.
	 */
	public DesignCircularQueue(int k) {
		this.k = k;
		size = 0;
		front = new Node(-1);
		rear = new Node(-1);
		front.next = rear;
		rear.prev = front;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is successful.
	 */
	public boolean enQueue(int value) {
		if (size == k) return false;
		Node cur = new Node(value);
		cur.prev = rear.prev;
		cur.next = rear;
		cur.prev.next = rear.prev = cur;
		size++;
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is successful.
	 */
	public boolean deQueue() {
		if (size == 0) return false;
		Node cur = front.next;
		cur.next.prev = cur.prev;
		cur.prev.next = cur.next;
		size--;
		return true;
	}

	/**
	 * Get the front item from the queue.
	 */
	public int Front() {
		if (size == 0) return -1;
		return front.next.val;
	}

	/**
	 * Get the last item from the queue.
	 */
	public int Rear() {
		if (size == 0) return -1;
		return rear.prev.val;
	}

	/**
	 * Checks whether the circular queue is empty or not.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Checks whether the circular queue is full or not.
	 */
	public boolean isFull() {
		return size == k;
	}

	class Node {
		int val;
		Node next, prev;

		public Node(int val) {
			this.val = val;
		}
	}
}
