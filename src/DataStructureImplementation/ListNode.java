package DataStructureImplementation;

/**
 * @author sandeepa
 */

public class ListNode<T> {
	private T val;
	private ListNode<T> next;
	
	public ListNode(T val) {
		this.val = val;
		this.next = null;
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "[" + val + " -> " + next + "]";
	}
}
