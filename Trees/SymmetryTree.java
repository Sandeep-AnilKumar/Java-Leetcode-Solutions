package Trees;

import java.util.Stack;

public class SymmetryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode rootLeft = new TreeNode(3);
		TreeNode rootRight = new TreeNode(3);
		TreeNode leftLeft = new TreeNode(4);
		//TreeNode leftLeftLeft = new TreeNode(1);
		TreeNode leftRight = new TreeNode(5);
		TreeNode rightLeft = new TreeNode(5);
		TreeNode rightRight = new TreeNode(4);
		//TreeNode rootRight = new TreeNode(7);

		root.right = rootRight;
		root.left = rootLeft;
		rootLeft.left = leftLeft;
		//leftLeft.left = leftLeftLeft;
		rootLeft.right = leftRight;
		rootRight.left = rightLeft;
		rootRight.right = rightRight;
		System.out.println(isSymmetric(root));

	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root.left == null && root.right == null)
			return true;

		if(root.left == null || root.right == null)
			return false;

		stack.push(root.left);
		stack.push(root.right);

		while(stack.size() != 0)
		{
			TreeNode right = stack.pop();
			TreeNode left = stack.pop();

			if(right == null && left == null)
				continue;

			if(right == null || left == null)
				return false;

			if(right.val == left.val)
			{
				stack.push(left.right);
				stack.push(right.left);
				stack.push(left.left);
				stack.push(right.right);
			}

			else
			{
				return false;
			}

		}
		return true;
	}

}
