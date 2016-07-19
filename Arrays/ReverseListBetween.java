package Arrays;

public class ReverseListBetween {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(4);
		MyNode l5 = new MyNode(5);
		MyNode l6 = new MyNode(6);
		MyNode l7 = new MyNode(7);
		MyNode l8 = new MyNode(8);


		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		MyNode result = reverseBetween(l1,2,4);

		while(result.next != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}
		System.out.println(result.val);
	}

	public static MyNode reverseBetween(MyNode head, int m, int n) {
		if(head == null || head.next == null) {
			return head;
		}

		MyNode newHead = new MyNode(-1);
		newHead.next = head;
		MyNode pre = newHead;
		MyNode cur = newHead;

		for(int i = 0; cur != null && i < n - m; ++i) {
			cur = cur.next;
		}

		MyNode temp = null;
		for(int i = 0; cur != null && i < m; ++i) {
			cur = cur.next;
			temp = pre;
			pre = pre.next;
		}

		MyNode nextHead = cur.next;
		cur.next = null;
		temp.next = reverseList(pre);
		cur = newHead;

		for(int i = 0; cur != null && i < n; ++i) {
			cur = cur.next;
		} 
		cur.next = nextHead;

		return newHead.next;
	}

	public static MyNode reverseList(MyNode head) {
		MyNode reverse = null;
		MyNode next = null;
		while(head != null) {
			next = head.next;
			head.next = reverse;
			reverse = head;
			head = next;
		}
		return reverse;
	}
}