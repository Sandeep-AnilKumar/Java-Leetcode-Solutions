package Trees;

import java.util.Stack;

public class SymmetricTree2 {

	public static void main(String[] args) {


	}

	public static boolean isMirror(TreeNode root)
	{
		if(root == null)
			return true;

		TreeNode right = invertTree(root.right);
		return isSame(root.left, right);
	}

	public static TreeNode invertTree(TreeNode right)
	{
		if(right == null)
			return right;

		Stack<TreeNode> stackRightInvert = new Stack<TreeNode>();
		stackRightInvert.push(right);

		while(!stackRightInvert.isEmpty())
		{
			TreeNode temp = stackRightInvert.pop();
			TreeNode left = temp.left;
			temp.left = temp.right;
			temp.right = left;

			if(temp.left != null)
				stackRightInvert.push(temp.left);

			if(temp.right != null)
				stackRightInvert.push(temp.right);
		}
		return right;
	}

	public static boolean isSame(TreeNode p, TreeNode q)
	{
		if(p == null && q == null)
			return true;

		if(p == null && q != null || (p != null && q == null))
			return false;

		Stack<TreeNode> stackP = new Stack<TreeNode>();
		Stack<TreeNode> stackQ = new Stack<TreeNode>();

		stackP.push(p);
		stackQ.push(q);

		while(!stackP.isEmpty() && !stackQ.isEmpty())
		{
			TreeNode tempP = stackP.pop();
			TreeNode tempQ = stackQ.pop();

			if(tempP.val == tempQ.val)
			{
				if(tempP.left != null && tempQ.left != null)
				{
					stackP.push(tempP.left);
					stackQ.push(tempQ.left);
				}

				else if(tempP.left == null && tempQ.left != null || (tempP.left != null && tempQ.left == null))
					return false;

				if(tempP.right != null && tempQ.right != null)
				{
					stackP.push(tempP.right);
					stackQ.push(tempQ.right);
				}

				else if(tempP.right == null && tempQ.right != null || (tempP.right != null && tempQ.right == null))
					return false;

			}
			else
				return false;
		}
		return true; 
	}
}