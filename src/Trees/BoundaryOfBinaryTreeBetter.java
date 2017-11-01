package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class BoundaryOfBinaryTreeBetter {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(4);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;
		c.left = f;

		System.out.println("The boundary of the binary tree is := " + new BoundaryOfBinaryTreeBetter().boundaryOfBinaryTree(root));
	}

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> boundary = new ArrayList<>();
		if(root == null) return boundary;

		boundary.add(root.val);
		addPath(root.left, boundary, true);

		addLeaves(root.left, boundary);
		addLeaves(root.right, boundary);

		addPath(root.right, boundary, false);

		return boundary;
	}

	public void addPath(TreeNode node, List<Integer> boundary, boolean left) {
		if(node == null || (node.left == null && node.right == null)) return;

		if(left) {
			boundary.add(node.val);
			if(node.left != null) {
				addPath(node.left, boundary, left);
			} else if(node.right != null) {
				addPath(node.right, boundary, left);
			}
		} else {
			if(node.right != null) {
				addPath(node.right, boundary, left);
			} else if(node.left != null) {
				addPath(node.left, boundary, left);
			}
			boundary.add(node.val);
		}
		return;
	}

	public void addLeaves(TreeNode node, List<Integer> boundary) {
		if(node == null) return;

		if(node.left == null && node.right == null) {
			boundary.add(node.val);
			return;
		}

		addLeaves(node.left, boundary);
		addLeaves(node.right, boundary);
		return;
	}
}
