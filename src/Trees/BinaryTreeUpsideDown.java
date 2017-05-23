package Trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BinaryTreeUpsideDown {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		TreeNode g = new TreeNode(8);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		c.left = e;
		e.left = f;
		f.left = g;

		System.out.println("The tree flipped upside down is := " + upsideDownBinaryTreeBetter(root));
	}

	public static TreeNode upsideDown(TreeNode root) {
		if(root == null) {
			return root;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		Deque<String> order = new ArrayDeque<>();
		TreeNode cur = root;
		stack.offerFirst(root);
		order.offerFirst("any");

		while(cur != null && !stack.isEmpty()) {
			if(cur.right != null) {
				stack.offerFirst(cur.right);
				order.offerFirst("left");
			}

			if(cur.left != null) {
				stack.offerFirst(cur.left);
				order.offerFirst("right");
			}

			cur = cur.left;
		}

		TreeNode prev = stack.pollFirst();
		TreeNode newRoot = prev;
		String curOrder = order.pollFirst();
		while(!stack.isEmpty() && !order.isEmpty()) {
			cur = stack.pollFirst();
			curOrder = order.pollFirst();
			cur.left = null;
			cur.right = null;

			if(curOrder.equals("left")) {
				prev.left = cur;
				cur = stack.pollFirst();
				order.pollFirst();
				cur.left = null;
				cur.right = null;
			}
			prev.right = cur;
			prev = prev.right;
		}
		return newRoot;
	}

	//A much easier version.
	public static TreeNode upsideDownBinaryTreeEasier(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (root.left != null) {
			stack.push(root.left);
			root = root.left;
		}
		TreeNode newRoot = stack.pop();
		TreeNode current = newRoot;
		while (!stack.isEmpty()) {
			TreeNode parent = stack.pop();
			current.left = parent.right;
			current.right = parent;
			parent.left = null;
			parent.right = null;
			current = parent;
		}
		return newRoot;
	}

	//The best one.
	public static TreeNode upsideDownBinaryTreeBetter(TreeNode root) {
		TreeNode prev = null;
		TreeNode curr = root;
		TreeNode next = null;
		TreeNode temp = null;
		while(curr != null) {
			next = curr.left;
			curr.left = temp;
			temp = curr.right;
			curr.right = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
