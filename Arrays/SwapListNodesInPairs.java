package Arrays;

public class SwapListNodesInPairs {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(4);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		MyNode result = swapPairs(l1);

		while(result.next != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}
		System.out.println(result.val);
	}

	public static MyNode swapPairs(MyNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		MyNode newHead = new MyNode(0);
		newHead.next = head;
		MyNode first = head;
		MyNode second = head.next;
		MyNode prev = newHead;

		while(second != null) {
			prev.next = second;
			first.next = second.next;
			second.next = first;
			first = first.next;
			if(first != null && first.next != null) {
				second = first.next;
			}
			else {
				second = null;
			}
			prev = prev.next.next;
		}
		return newHead.next;
	}
}