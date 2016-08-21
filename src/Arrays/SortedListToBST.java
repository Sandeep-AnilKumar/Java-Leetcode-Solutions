package Arrays;

import Trees.TreeNode;

public class SortedListToBST {
	public static MyNode node;
	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(4);
		MyNode l5 = new MyNode(5);


		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		TreeNode result = sortedListToBST(l1);
	}



	public static TreeNode sortedListToBST(MyNode head) {
		if(head == null || head.next == null) {
			return head == null ? null : new TreeNode(head.val);
		}
		node = head;
		MyNode pre = head;
		int size = 0;
		while(pre != null) {
			pre = pre.next;
			size++;
		}

		return inOrderTraversal(0, size - 1);
	}

	public static TreeNode inOrderTraversal(int start, int end) {
		if(start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;


		TreeNode left = inOrderTraversal(start, mid - 1);
		TreeNode root = new TreeNode(node.val);
		root.left = left;

		node = node.next;

		TreeNode right = inOrderTraversal(mid + 1, end);
		root.right = right;

		return root;
	}


}
