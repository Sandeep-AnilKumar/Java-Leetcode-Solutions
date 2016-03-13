package Arrays;
import Arrays.MyNode;


public class PalindromeList {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(5);
		MyNode l5 = new MyNode(1);
		//MyNode l6 = new MyNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		//l5.next = l6;

		isPalindrome(l1);
	}

	public static boolean isPalindrome(MyNode head)
	{
		if(head == null || head.next == null)
			return true;

		MyNode dummy = new MyNode(0);
		dummy.next = head;
		MyNode fast = dummy;
		MyNode slow = dummy;

		while(fast.next != null)
		{
			fast = fast.next;
			if(fast.next != null)
				fast = fast.next;
			slow = slow.next;
		}

		MyNode pre = slow;
		pre = pre.next;
		slow.next = null;

		pre = reverseList(pre, null);
		MyNode first = dummy.next;

		while(pre != null && first != null)
		{
			if(pre.val == first.val)
			{
				pre =pre.next;
				first = first.next;
			}
			else
			{
				return false;
			}
		}

		return true;
	}

	public static MyNode reverseList(MyNode head, MyNode newHead)
	{
		if(head == null) return newHead;
		MyNode next = head.next;
		head.next = newHead;
		return reverseList(next,head);
	}
}
