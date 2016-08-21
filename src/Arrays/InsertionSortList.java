package Arrays;

public class InsertionSortList {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(6);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(8);
		MyNode l5 = new MyNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		MyNode result = insertionSortList(l1);
		while(result != null) {
			System.out.println(result.val + ",");
			result = result.next;
		}
	}

	public static MyNode insertionSortList(MyNode head) {
		if(head == null || head.next == null){
			return head;
		}
		MyNode preNode = head;
		MyNode curNode = head.next;

		while(curNode != null){
			MyNode nextInsert = curNode.next;
			if(curNode.val <= head.val){
				preNode.next = curNode.next;
				curNode.next = head;
				head = curNode;
			}
			else if(curNode.val >= preNode.val){
				preNode = preNode.next;
			}
			else{
				MyNode findNode = head;
				while(findNode.next.val < curNode.val)   findNode = findNode.next;
				preNode.next = curNode.next;
				curNode.next = findNode.next;
				findNode.next = curNode;
			}
			curNode = nextInsert;
		}
		return head;
	}
}
