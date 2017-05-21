package Trees;

public class BinaryTreeConsecutiveSequence {
	static int maxval = 0;
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode a = new TreeNode(7);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(2);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(1);
		TreeNode h = new TreeNode(8);
		TreeNode i = new TreeNode(1);

		node.left = a;
		node.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;
		c.left = g;
		c.right = h;
		d.left = i;

		System.out.println("The largest binary tree consecutive sequence is of length := " + longestConsecutive(node));
	}

	public static int longestConsecutive(TreeNode root) {
		longestPath(root);
		return maxval;
	}
	public static int[] longestPath(TreeNode root) {
		if (root == null)
			return new int[] {0,0};
		int inr = 1, dcr = 1;
		if (root.left != null) {
			int[] l = longestPath(root.left);
			if (root.val == root.left.val + 1)
				dcr = l[1] + 1;
			else if (root.val == root.left.val - 1)
				inr = l[0] + 1;
		}
		if (root.right != null) {
			int[] r = longestPath(root.right);
			if (root.val == root.right.val + 1)
				dcr = Math.max(dcr, r[1] + 1);
			else if (root.val == root.right.val - 1)
				inr = Math.max(inr, r[0] + 1);
		}
		maxval = Math.max(maxval, dcr + inr - 1);
		return new int[] {inr, dcr};
	}
}
