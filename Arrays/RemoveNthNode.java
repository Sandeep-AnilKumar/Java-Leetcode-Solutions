package Arrays;

public class RemoveNthNode {

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
		
		removeNNode(l1,3);
	}
	
	public static MyNode removeNNode(MyNode head, int n)
	{
		if(n <= 0 || head == null)
			return head;
		
		MyNode fast = head;
		MyNode slow = head;
		
		while(n > 0)
		{
			fast = fast.next;
			n--;
		}
		
		while(fast != null && fast.next != null)
		{
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		
		return head;
	}

}
