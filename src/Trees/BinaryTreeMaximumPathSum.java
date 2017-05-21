package Trees;

public class BinaryTreeMaximumPathSum {
	static int maxSum = Integer.MIN_VALUE;
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode a = new TreeNode(7);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(2);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(-4);
		TreeNode h = new TreeNode(-4);
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

		System.out.println("The binary tree maximum path sum is := " + maxPathSum(node));
	}


	public static int maxPathSum(TreeNode root) {
		pathSum(root);
		return maxSum;
	}

	public static int pathSum(TreeNode node) {
		if(node == null) {
			return 0;
		}

		int left = 0;
		int right = 0;

		left = Math.max(0, pathSum(node.left));
		right = Math.max(0, pathSum(node.right));

		maxSum = Math.max(maxSum, node.val + left + right);
		return Math.max(left, right) + node.val;
	}
}
