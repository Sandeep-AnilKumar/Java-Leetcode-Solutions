package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSTIterator {
	List<Integer> inorder;

	public BSTIterator(TreeNode root) {
		inorder = new ArrayList<>();
		inorder = getInorder(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return inorder.size() > 0;
	}

	/** @return the next smallest number */
	public int next() {
		if(hasNext()) {
			int val = inorder.get(0);
			inorder.remove(0);
			return val;
		}
		return -1;
	}

	public List<Integer> getInorder(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		if(root == null) {
			return inorder;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;

		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				inorder.add(cur.val);
				cur = cur.right;
			}
		}
		return inorder;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);

		root.left = a;
		root.right = b;
		b.right = c;
		c.right = d;

		BSTIterator bsti = new BSTIterator(root);
		while(bsti.hasNext()) {
			System.out.print(bsti.next() + " ");
		}
	}
}
