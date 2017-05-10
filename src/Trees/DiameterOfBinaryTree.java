package Trees;

public class DiameterOfBinaryTree {

	static int max = 0;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(7);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		System.out.println(root);
		System.out.println("The diameter of binary tree is := " + diameterOfBinaryTree(root));
	}

	public static int diameterOfBinaryTree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		depthTree(root);
		return max;
	}

	public static int depthTree(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int left = depthTree(node.left);
		int right = depthTree(node.right);
		max = Math.max(max, left + right);
		return 1 + Math.max(left, right);
	}

}
