package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(7);
		TreeNode f = new TreeNode(11);

		root.left = b;
		root.right = a;
		a.left = e;
		a.right = f;
		b.left = c;
		b.right = d;

		System.out.println("The flattened tree is := ");
		flattenTree(root);
		System.out.println(root);
	}

	//Brute force.
	public static void flattenTree(TreeNode root) {
		if(root == null) {
			return;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		List<TreeNode> preorder = new ArrayList<>();

		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				preorder.add(cur);
				System.out.println(cur.val);
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				cur = cur.right;
			}
		}

		for(int i = 0; i < preorder.size() - 1; ++i) {
			preorder.get(i).right = preorder.get(i + 1);
			preorder.get(i).left = null;
		}
		return;
	}

	public static void flattenBetter(TreeNode root) {
		TreeNode now = root;

		while (now != null) {
			if (now.left != null) {
				TreeNode pre = now.left;
				while (pre.right != null) pre = pre.right;
				pre.right = now.right;
				now.right = now.left;
				now.left = null;
			}

			now = now.right;
		}
	}

	public static void flattenDynamic(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();

		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.right != null) stack.push(cur.right);
			if (cur.left != null) stack.push(cur.left);
			if (!stack.isEmpty()) cur.right = stack.peek();
			cur.left = null;
		}
	}

	public sttaic void flattenRecursiev(TreeNode root) {
		if (root == null) return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}

}
