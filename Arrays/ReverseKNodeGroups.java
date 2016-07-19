package Arrays;

public class ReverseKNodeGroups {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(4);
		MyNode l5 = new MyNode(5);
		MyNode l6 = new MyNode(6);
		MyNode l7 = new MyNode(7);
		MyNode l8 = new MyNode(8);


		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		MyNode result = reverseKGroup(l1,7);

		while(result.next != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}
		System.out.println(result.val);
	}

	public static MyNode reverseKGroup(MyNode head, int k) {
		if(head == null || head.next == null || k <=1){
			return head;
		} 
		MyNode slow = null, newHead = new MyNode(-1), pre = newHead, temp = null, cur = head;

		while(cur != null) {
			int i = 0;
			temp = cur;
			for(i = 0; cur != null && i < k; ++i) {
				slow = cur;
				cur = cur.next;
			}
			slow.next = null;

			if(i < k) {
				pre.next = temp;
			}
			else {
				pre.next = reverseList(temp);
				i = 0;
				while(pre != null && i < k) {
					pre = pre.next;
					i++;
				}
			}
		}
		return newHead.next;
	}

	public static MyNode reverseList(MyNode head) {
		MyNode reverse = null;
		MyNode next = null;
		while(head != null) {
			next = head.next;
			head.next = reverse;
			reverse = head;
			head = next;
		}
		return reverse;
	}

}
