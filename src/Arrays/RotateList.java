package Arrays;

public class RotateList {

	public static void main(String[] args) {

		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);		
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(4);
		MyNode l5 = new MyNode(5);
		//MyNode l6 = new MyNode(5);
		//MyNode l7 = new MyNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		//l5.next = l6;
		//l6.next = l7;

		rotateRight(l1,17);


	}

	public static MyNode rotateRight(MyNode head, int k)
	{
		if(head == null || head.next == null || k <= 0)
			return head;

		MyNode dummy = new MyNode(0);
		dummy.next = head;
		MyNode slow = dummy;
		MyNode fast = dummy;

		int i = 0;
		for(i = 0; fast.next != null; i++)
			fast = fast.next;

		for(int j= 0; j < i-k%i ; j++)
			slow = slow.next;

		fast.next = dummy.next;
		dummy.next = slow.next;
		slow.next = null;

		return dummy.next;
	}
}
