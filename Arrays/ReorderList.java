package Arrays;
import Arrays.MyNode;
public class ReorderList {

	public static void main(String[] args) {

		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);		
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(4);
		MyNode l5 = new MyNode(5);
		MyNode l6 = new MyNode(6);
		MyNode l7 = new MyNode(7);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		reorderList(l1);

	}

	public static MyNode reorderList(MyNode l1)
	{
		if(l1 == null || l1.next == null)
			return l1;

		MyNode pre = l1;
		MyNode cur = l1;
		MyNode head = l1;

		while(cur != null && cur.next != null && cur.next.next != null)
		{
			pre = pre.next;
			cur = cur.next.next;
		}

		MyNode second = pre.next;
		pre.next = null;
		second = reverseList(second);

		MyNode p1 = head;
		MyNode p2 = second;

		while(p2 != null)
		{
			MyNode t1 = p1.next;
			MyNode t2 = p2.next;

			p1.next = p2;
			p2.next = t1;
			p1 = t1;
			p2 = t2;
		}
		return head;
	}


	public static MyNode reverseList(MyNode head) {
		return reverseList(head,null);
	}

	public static MyNode reverseList(MyNode head, MyNode newHead)
	{
		if(head == null)
			return newHead;
		MyNode next = head.next;
		head.next = newHead;
		return reverseList(next,head);
	}	
}
