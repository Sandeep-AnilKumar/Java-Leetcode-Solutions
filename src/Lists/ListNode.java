package Lists;

public class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public String toString() {
		if(this.next == null) return this.val + " -> null";
		return this.val + " -> " + this.next;
	}
}
