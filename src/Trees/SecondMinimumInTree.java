package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class SecondMinimumInTree {

	public static void main(String[] args) {
		SecondMinimumInTree minimum = new SecondMinimumInTree();
		//[1,1,3,1,1,3,4,3,1,1,8]
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(1);
		TreeNode n10 = new TreeNode(8);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n3.left = n7;
		n3.right = n8;
		n4.left = n9;
		n4.right = n10;
		System.out.println("The second minimum element in the tree is := " + minimum.findSecondMinimumValue(root));
	}

	public int findSecondMinimumValue(TreeNode root) {
		if(root == null) return -1;
		Deque<TreeNode> queue = new ArrayDeque<>();
		int rootVal = root.val;

		queue.offer(root);
		int secondValue = Integer.MAX_VALUE;
		TreeNode cur = null;

		while(!queue.isEmpty()) {
			cur = queue.pollFirst();
			if(cur.val > rootVal && cur.val < secondValue) {
				secondValue = cur.val;
			}
			if(cur.left != null) {
				queue.offer(cur.left);
				queue.offer(cur.right);
			}
		}

		return secondValue != Integer.MAX_VALUE ? secondValue : -1;
	}
}
