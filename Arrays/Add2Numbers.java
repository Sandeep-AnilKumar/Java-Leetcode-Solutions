package Arrays;
import Arrays.MyNode;

public class Add2Numbers {

	public static void main(String[] args) {

		MyNode l1 = new MyNode(2);
		MyNode l2 = new MyNode(3);
		l2.next = new MyNode(4);

		l1.next = l2;

		MyNode l3 = new MyNode(8);
		MyNode l4 = new MyNode(0);
		l4.next = new MyNode(2);

		l3.next = l4;

		MyNode result = addTwoNumbers(l1,l3);
	}

	public static MyNode addTwoNumbers(MyNode l1, MyNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}

		MyNode cur1 = l1, cur2 = l2, result = new MyNode(-1), curResult = result;

		int sum = 0, carry = 0;

		while(cur1 != null || cur2 != null) {
			sum = (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val) + carry;
			carry = sum / 10;
			sum %= 10;

			curResult.next = new MyNode(sum);
			curResult = curResult.next;
			cur1 = cur1 == null ? null : cur1.next;
			cur2 = cur2 == null ? null : cur2.next;
		}

		if(carry == 1) {
			curResult.next = new MyNode(carry);
		}
		return result.next;
	}
}
