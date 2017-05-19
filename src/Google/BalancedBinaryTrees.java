package Google;

import Trees.TreeNode;

public class BalancedBinaryTrees {
	static boolean balanced = true;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(7);
		TreeNode f = new TreeNode(8);
		TreeNode g = new TreeNode(9);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;
		c.left = g;

		System.out.println("Is the tree balanced? := " + isBalanced(root));
	}

	public static boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}

		depth(root);
		return balanced;
	}

	public static int depth(TreeNode node) {
		if(node == null) {
			return 0;
		}

		int left = depth(node.left);
		int right = depth(node.right);

		if(Math.abs(left - right) >= 2) {
			balanced = false;
		}
		return 1 + Math.max(left, right);
	}
}
