package Trees;

import java.util.Stack;

public class InvertTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		TreeNode rootLeft = new TreeNode(3);
		TreeNode rootRight = new TreeNode(4);
		TreeNode leftLeft = new TreeNode(1);
		//TreeNode leftLeftLeft = new TreeNode(1);
		TreeNode leftRight = new TreeNode(2);
		TreeNode rightLeft = new TreeNode(5);
		TreeNode rightRight = new TreeNode(0);
		//TreeNode rootRight = new TreeNode(7);

		root.right = rootRight;
		root.left = rootLeft;
		rootLeft.left = leftLeft;
		//leftLeft.left = leftLeftLeft;
		rootLeft.right = leftRight;
		rootRight.left = rightLeft;
		rootRight.right = rightRight;
		invertTree(root);

	}

	public static TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		stack.push(root.left);
		stack.push(root.right);

		while(stack.size() != 0)
		{
			TreeNode node = stack.pop();
			//TreeNode nodeLeft = stack.pop();

			if(node.left == null && node.right == null)
				continue;

			else if(node.left == null)
			{
				node.left = node.right;
			}

			else if(node.right == null)
			{
				node.right = node.left;
			}

			else
			{
				TreeNode tempNode = node.left;
				node.left = node.right;
				node.right = temp;
			}

			stack.push(node.left);
			stack.push(node.right);
		}
		return root;
	}

}
