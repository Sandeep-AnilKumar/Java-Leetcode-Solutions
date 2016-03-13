package Trees;
import Trees.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreOrderRecursive {
	static ArrayList<Integer> preOrder = new ArrayList<Integer>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode rootLeft = new TreeNode(3);
		TreeNode rootRight = new TreeNode(7);
		TreeNode leftLeft = new TreeNode(2);
		TreeNode leftRight = new TreeNode(4);
		//TreeNode rootRight = new TreeNode(7);

		root.right = rootRight;
		root.left = rootLeft;
		rootLeft.left = leftLeft;
		rootLeft.right = leftRight;
		preorderTraversal(root);
	}

	public static ArrayList preorderTraversal(TreeNode root)
	{
		if(root == null)
			return preOrder;

		helper(root);

		return preOrder;
	}

	public static void helper(TreeNode n)
	{	

		preOrder.add(n.val);

		if(n.left != null)
			helper(n.left);

		if(n.right != null)
			helper(n.right);
	}
}
