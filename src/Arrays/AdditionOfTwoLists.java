package Arrays;

public class AdditionOfTwoLists {

	public static void main(String[] args) {
		MyNode node = new MyNode(7);
		MyNode a = new MyNode(1);
		MyNode b = new MyNode(6);

		node.next = a;
		a.next = b;

		MyNode nextNode = new MyNode(5);
		MyNode c = new MyNode(9);
		MyNode d = new MyNode(2);

		nextNode.next = c;
		c.next = d;

		System.out.println("The addition of two lists in backward direction is := " + additionBackward(node, nextNode));

		node.val = 6;
		a.val = 1;
		b.val = 7;

		nextNode.val = 2;
		c.val = 9;
		d.val = 5;

		System.out.println("The addition of two lists in forward direction is := " + additionForward(node, nextNode));
	}

	public static MyNode additionBackward(MyNode a, MyNode b) {
		int carry = 0;
		MyNode sumList = new MyNode(0);
		MyNode cur = sumList;
		int sum = 0;

		MyNode aCur = a;
		MyNode bCur = b;

		while(aCur != null || bCur != null) {
			sum = aCur == null ? 0 : aCur.val;
			sum += bCur == null ? 0 : bCur.val;
			sum += carry;

			carry = sum / 10;
			sum %= 10;

			cur.next = new MyNode(sum);
			cur = cur.next;
			aCur = aCur.next;
			bCur = bCur.next;
		}

		if(carry > 0) {
			cur.next = new MyNode(carry);
		}
		return sumList.next;
	}

	public static MyNode additionForward(MyNode a, MyNode b) {
		a = reverseNodes(a);
		b = reverseNodes(b);

		return additionBackward(a, b);
	}

	public static MyNode reverseNodes(MyNode node) {
		if(node == null || node.next == null) {
			return node;
		}

		MyNode head = node;
		MyNode next = null;
		MyNode rev = null;

		while(head != null) {
			next = head.next;
			head.next = rev;
			rev = head;
			head = next;
		}
		return rev;
	} 
}
