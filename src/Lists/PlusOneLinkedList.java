package Lists;

public class PlusOneLinkedList {

	public static void main(String[] args) {
		PlusOneLinkedList list = new PlusOneLinkedList();
		ListNode head = new ListNode(9);
		System.out.println("List after adding one to it is := ");
		System.out.println(list.plusOne(head));
	}

	public ListNode plusOne(ListNode head) {
		if(head == null) return head;
		ListNode copy = head;
		ListNode rev = reverseList(copy);
		addOne(rev);
		return reverseList(rev);
	}

	public ListNode reverseList(ListNode node) {
		ListNode cur = null;
		ListNode rev = null;

		while(node != null) {
			cur = node;
			node = node.next;
			cur.next = rev;
			rev = cur;
		}
		return rev;
	}

	public void addOne(ListNode node) {
		int carry = 0;
		int sum = 0;
		ListNode cur = node;
		ListNode prev = null;
		int index = 0;

		while(cur != null) {
			sum = index == 0 ? 1 + cur.val : carry + cur.val;
			index++;

			carry = sum / 10;
			sum %= 10;

			cur.val = sum;
			prev = cur;
			cur = cur.next;
		}

		if(carry > 0) prev.next = new ListNode(carry);

		return;
	}
}