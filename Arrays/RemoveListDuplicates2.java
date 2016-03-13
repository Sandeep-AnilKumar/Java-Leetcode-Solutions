package Arrays;

public class RemoveListDuplicates2 {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(1);		
		MyNode l3 = new MyNode(1);
		MyNode l4 = new MyNode(3);
		MyNode l5 = new MyNode(4);
		MyNode l6 = new MyNode(5);
		MyNode l7 = new MyNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		deleteDuplicates(l1);
	}


	public static MyNode deleteDuplicates(MyNode head) {
		if(head == null || head.next == null)
			return head;

		MyNode dummy = new MyNode(0);
		dummy.next = head;
		MyNode pre = dummy;
		MyNode cur = head;

		while(cur != null)
		{
			while(cur.next != null && cur.val == cur.next.val)
			{
				cur = cur.next;
			}

			if(pre.next != cur)
			{
				pre.next = cur.next;
				cur = pre.next;
			}
			else
			{
				pre = pre.next;
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}
