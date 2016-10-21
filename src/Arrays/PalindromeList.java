package Arrays;

public class PalindromeList {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(2);
		MyNode l5 = new MyNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		System.out.println(isPalindrome(l1));
	}

	public static boolean isPalindrome(MyNode head) {
		if(head == null || head.next == null) {
			return true;
		}

		MyNode dummy = new MyNode(0);
		dummy.next = head;

		MyNode newHead = partitionList(dummy, null);

		MyNode reverseNewHead = reverseList(newHead, null);

		return areListsEqual(dummy.next, reverseNewHead);
	}

	public static boolean areListsEqual(MyNode head1, MyNode head2) {
		while(head1 != null && head2 != null) {
			if(head1.val == head2.val) {
				head1 = head1.next;
				head2 = head2.next;
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static MyNode partitionList(MyNode head, MyNode newHead) {

		MyNode slow = head;
		MyNode fast = head;

		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		newHead = slow.next;
		slow.next = null;

		return newHead;
	}

	public static MyNode reverseList(MyNode head, MyNode reverse) {
		if(head == null) {
			return reverse;
		}

		while(head != null) {
			MyNode next = head.next;
			head.next = reverse;
			reverse = head;
			head = next;
		}

		return reverse;
	}
}