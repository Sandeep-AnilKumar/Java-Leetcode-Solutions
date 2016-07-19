package Arrays;

public class MergeTwoLists {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(11);
		MyNode l3 = new MyNode(15);

		l1.next = l2;
		l2.next = l3;

		MyNode l4 = new MyNode(1);
		MyNode l5 = new MyNode(3);
		MyNode l6 = new MyNode(8);
		MyNode l7 = new MyNode(9);
		MyNode l8 = new MyNode(9);

		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		MyNode result = mergeTwoLists(l1,l4);

		while(result.next != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}
		System.out.println(result.val);
	}

	public static MyNode mergeTwoLists(MyNode l1, MyNode l2) {
		if(l1 == null) {
			return l2;
		}

		if(l2 == null) {
			return l1;
		}

		MyNode dummy = new MyNode(0);
		MyNode first = null;
		MyNode second = null;
		MyNode prev = null;

		if(l1.val <= l2.val) {
			dummy.next = l1;
			second = l2;
		}
		else {
			dummy.next = l2;
			second = l1;
		}

		first = dummy;
		prev = first;
		first = first.next;

		while(first != null && second != null) {
			if(first.val <= second.val) {
				prev.next = first;
				first = first.next;
			}
			else {
				prev.next = second;
				second = second.next;
			}
			prev = prev.next;
		}

		if(first == null) {
			prev.next = second;
		}
		else if(second == null) {
			prev.next = first;
		}

		return dummy.next;  
	}
}