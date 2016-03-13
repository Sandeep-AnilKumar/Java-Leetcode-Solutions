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

		System.out.println("The addition of the two lists in reverse order is");

		MyNode result = AddLists(l1,l3);
	}

	public static MyNode AddLists(MyNode l1, MyNode l2){

		MyNode newhead = new MyNode(0);
		MyNode l3 = newhead;
		int carry = 0;

		while(l1 != null || l2 != null)
		{
			if(l1 != null)
			{
				carry += l1.val;
				l1 = l1.next;
			}

			if(l2 != null)
			{
				carry += l2.val;
				l2 = l2.next;
			}

			l3.next = new MyNode(carry % 10);
			l3 = l3.next;
			carry /= 10;
		}

		if(carry == 1){
			l3.next = new MyNode(1);
		}

		return newhead.next;
	}
}
