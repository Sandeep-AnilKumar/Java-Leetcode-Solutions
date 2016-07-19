package Trees;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args)
	{
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
	}

	public static List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> nodes = new ArrayList<List<Integer>>();
		if(root == null)
			return nodes;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		while(queue.size() != 0)
		{
			int size = queue.size();
			List<Integer> levelNodes = new ArrayList<Integer>();

			while(size > 0)
			{
				TreeNode temp = queue.poll();
				levelNodes.add(temp.val);

				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);

				size--;
			}
			nodes.add(levelNodes);
		}
		return nodes;
	}
}
