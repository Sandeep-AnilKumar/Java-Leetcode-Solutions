package Trees;

public class MaximumPathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(9);
		TreeNode n5 = new TreeNode(-12);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(10);
		TreeNode n8 = new TreeNode(-13);
		TreeNode n9 = new TreeNode(11);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n7;
		n7.right = n9;
		n5.left = n8;

		MaximumPathSum maxPath = new MaximumPathSum();
		System.out.println("The maximum path sum is := " + maxPath.maxPathSum(root));
	}

	int maxSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		int sum = maxPath(root);
		return Math.max(sum, maxSum);
	}

	public int maxPath(TreeNode node) {
		if(node == null) return 0;
		int left = Math.max(0, maxPath(node.left));
		int right = Math.max(0, maxPath(node.right));
		maxSum = Math.max(maxSum, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
}
