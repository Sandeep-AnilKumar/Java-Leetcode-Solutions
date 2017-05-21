package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ConvertBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(10);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		System.out.println("Converted BST is := " + convertBSTBetter(root));
	}

	public static TreeNode convertBST(TreeNode root) {
		if(root == null) {
			return root;
		}

		List<TreeNode> inorder = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;

		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				inorder.add(cur);
				cur = cur.right;
			}
		}

		if(inorder != null && inorder.size() > 0) {
			for(int i = inorder.size() - 2; i >= 0; --i) {
				inorder.get(i).val += inorder.get(i + 1).val;
			}
		}
		return root;
	}

	//A much easier and better solution.
	static int sum = 0;
	public static TreeNode convertBSTBetter(TreeNode node) {
		addMaxBST(node);
		return node;
	}

	public static void addMaxBST(TreeNode node) {
		if(node == null) {
			return;
		}

		addMaxBST(node.right);
		sum += node.val;
		node.val = sum;
		addMaxBST(node.left);
	}
}
