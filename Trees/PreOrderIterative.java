package Trees;
import Trees.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class PreOrderIterative {
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
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if(root == null)
			return returnList;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while(!stack.empty())
		{
			TreeNode n = stack.pop();
			returnList.add(n.val);

			if(n.right != null)
			{
				stack.push(n.right);
			}

			if(n.left != null)
			{
				stack.push(n.left);
			}
		}
		return returnList;
	}
}
