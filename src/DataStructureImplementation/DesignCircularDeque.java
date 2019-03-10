package DataStructureImplementation;

public class DesignCircularDeque {

	private int k, size, f, r;
	private int[] nums;

	/**
	 * Initialize your data structure here. Set the size of the deque to be k.
	 */
	public DesignCircularDeque(int k) {
		this.k = k;
		nums = new int[k];
		size = 0;
		f = -1;
		r = k;
	}

	/**
	 * Adds an item at the front of Deque. Return true if the operation is successful.
	 */
	public boolean insertFront(int value) {
		if (!isFull()) {
			f = (((f + 1) % k) + k) % k;
			nums[f] = value;
			size++;
			return true;
		}
		return false;
	}

	/**
	 * Adds an item at the rear of Deque. Return true if the operation is successful.
	 */
	public boolean insertLast(int value) {
		if (!isFull()) {
			r = (((r - 1) % k) + k) % k;
			nums[r] = value;
			size++;
			return true;
		}
		return false;
	}

	/**
	 * Deletes an item from the front of Deque. Return true if the operation is successful.
	 */
	public boolean deleteFront() {
		if (!isEmpty()) {
			f = (((f - 1) % k) + k) % k;
			size--;
			return true;
		}
		return false;
	}

	/**
	 * Deletes an item from the rear of Deque. Return true if the operation is successful.
	 */
	public boolean deleteLast() {
		if (!isEmpty()) {
			r = (((r + 1) % k) + k) % k;
			size--;
			return true;
		}
		return false;
	}

	/**
	 * Get the front item from the deque.
	 */
	public int getFront() {
		if (!isEmpty()) {
			return nums[f % k];
		}
		return -1;
	}

	/**
	 * Get the last item from the deque.
	 */
	public int getRear() {
		if (!isEmpty()) {
			return nums[r % k];
		}
		return -1;
	}

	/**
	 * Checks whether the circular deque is empty or not.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Checks whether the circular deque is full or not.
	 */
	public boolean isFull() {
		return size == k;
	}
}