package Trees;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class isBalanced {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode rootLeft = new TreeNode(3);
		TreeNode rootRight = new TreeNode(7);
		TreeNode leftLeft = new TreeNode(2);
		TreeNode leftLeftLeft = new TreeNode(1);
		TreeNode leftRight = new TreeNode(4);
		//TreeNode rootRight = new TreeNode(7);

		root.right = rootRight;
		root.left = rootLeft;
		rootLeft.left = leftLeft;
		leftLeft.left = leftLeftLeft;
		rootLeft.right = leftRight;
		System.out.println("Is the tree balanced? :-  " + isBalanced(root));

	}

	public static boolean isBalanced(TreeNode root)
	{
		return height(root) != -1;
	}

	public static int height(TreeNode node)
	{
		if(node == null)
			return 0;

		int leftHeight = height(node.left);
		if(leftHeight == -1)
			return -1;

		int rightHeight = height(node.right);
		if(rightHeight == -1)
			return -1;

		if(Math.abs(leftHeight - rightHeight) > 1)
			return -1;

		return Math.max(leftHeight, rightHeight) + 1;
	}
}
