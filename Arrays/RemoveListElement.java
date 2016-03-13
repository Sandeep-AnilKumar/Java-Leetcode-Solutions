package Arrays;

public class RemoveListElement {

	public static void main(String[] args) {

		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);		
		MyNode l3 = new MyNode(1);
		MyNode l4 = new MyNode(1);
		MyNode l5 = new MyNode(4);
		MyNode l6 = new MyNode(1);
		MyNode l7 = new MyNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		removeElements(l1,1);

	}

	public static MyNode removeElements(MyNode head, int val) {
		if(head == null)
			return head;

		MyNode dummy = new MyNode(0);
		MyNode pre = dummy;
		dummy.next = head;
		MyNode cur = head;

		while(cur != null)
		{
			if(cur.val == val)
				pre.next = pre.next.next;

			else
				pre = pre.next;

			cur = cur.next;
		}
		return dummy.next;
	}
}
