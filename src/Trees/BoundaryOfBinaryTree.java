package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {

	static	int leaves = 0;
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

		System.out.println("The boundary of the binary tree is := " + boundaryOfBinaryTree(root));
	}

	//Might not work for few of the corner cases.
	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> boundary = new ArrayList<>();
		if(root == null) {
			return boundary;
		}

		int temp = 0;
		getLeaves(root);
		leaves = reverseNum(leaves);

		if(root.left != null) {
			leaves /= 10;
			int leftPath = leftMost(root, 0);
			temp = 0;
			while(leftPath > 9) {
				temp = leftPath;
				leftPath /= 10;
				temp %= 10;
				boundary.add(0, temp);
			}
		}

		while(leaves > 9) {
			temp = leaves;
			leaves /= 10;
			temp %= 10;
			boundary.add(temp);
		}

		if(root.right != null) {
			int rightPath = rightMost(root, 0);
			temp = 0;
			while(rightPath > 9) {
				temp = rightPath;
				rightPath /= 10;
				temp %= 10;
				boundary.add(temp);
			}
		}
		boundary.add(0, root.val);
		return boundary;
	}

	public static int leftMost(TreeNode node, int curSum) {
		if(node == null) {
			return 0;
		}

		if(node.left == null && node.right == null) {
			curSum = curSum * 10 + node.val;
			return curSum;
		}

		if(node.left != null) {
			curSum = leftMost(node.left, curSum * 10 + node.val);
		} else {
			curSum = leftMost(node.right, curSum * 10 + node.val);
		}
		return curSum;
	}

	public static int rightMost(TreeNode node, int curSum) {
		if(node == null) {
			return 0;
		}

		if(node.left == null && node.right == null) {
			curSum = curSum * 10 + node.val;
			return curSum;
		}

		if(node.right != null) {
			curSum = rightMost(node.right, curSum * 10 + node.val);
		} else {
			curSum = rightMost(node.left, curSum * 10 + node.val);
		}
		return curSum;
	}

	public static void getLeaves(TreeNode node) {
		if(node == null) {
			return;
		}

		if(node.left == null && node.right == null) {
			leaves = leaves * 10 + node.val;
			return;
		}

		getLeaves(node.left);
		getLeaves(node.right);
		return;
	}

	public static int reverseNum(int num) {
		if(num < 10) {
			return num;
		}

		int temp = num;
		int rem = 0;
		int rev = 0;
		while(temp > 0) {
			rem = temp;
			temp /= 10;
			rem %= 10;
			rev = rev * 10 + rem;
		}
		return rev;
	}

	public static boolean isLeaf(TreeNode t) {
		return t.left == null && t.right == null;
	}

	public static void addLeaves(List<Integer> res, TreeNode root) {
		if (isLeaf(root)) {
			res.add(root.val);
		} else {
			if (root.left != null) {
				addLeaves(res, root.left);
			}
			if (root.right != null) {
				addLeaves(res, root.right);
			}
		}
	}

	public static List<Integer> boundaryOfBinaryTreeBetter(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		if (!isLeaf(root)) {
			res.add(root.val);
		}
		TreeNode t = root.left;
		while (t != null) {
			if (!isLeaf(t)) {
				res.add(t.val);
			}
			if (t.left != null) {
				t = t.left;
			} else {
				t = t.right;
			}

		}
		addLeaves(res, root);
		Stack<Integer> s = new Stack<>();
		t = root.right;
		while (t != null) {
			if (!isLeaf(t)) {
				s.push(t.val);
			}
			if (t.right != null) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		while (!s.empty()) {
			res.add(s.pop());
		}
		return res;
	}
}
