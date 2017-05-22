package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLeavesOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;

		System.out.println("The leaves of the binary tree are := " + findLeaves(root));
	}

	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> leaves = new ArrayList<>();
		if(root == null) {
			return leaves;
		}

		List<Integer> curLeaves = new ArrayList<>();
		boolean present = false;
		while(!present) {
			curLeaves = new ArrayList<>();
			present = getLeaves(root, curLeaves);
			if(present) {
				break;
			}
			leaves.add(curLeaves);
		}
		leaves.add(new ArrayList<Integer>(Arrays.asList(root.val)));
		return leaves;
	}

	public static boolean getLeaves(TreeNode node, List<Integer> curLeaves) {
		if(node == null) {
			return true;
		}

		if(node.left == null && node.right == null) {
			return true;
		}

		boolean left = getLeaves(node.left, curLeaves);
		boolean right = getLeaves(node.right, curLeaves);

		if(left && node.left != null) {
			curLeaves.add(node.left.val);
			node.left = null;
		}

		if(right && node.right != null) {
			curLeaves.add(node.right.val);
			node.right = null;
		}

		return false;
	}

	//A much easier solution.

	public static List<List<Integer>> findLeavesBetter(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		level(root, res);
		return res;
	}

	private static int level(TreeNode root, List<List<Integer>> lists) {
		if (root == null) {
			return -1;
		}
		int ll = level(root.left, lists);
		int rl = level(root.right, lists);
		int level = Math.max(ll, rl) + 1;
		if (level == lists.size()) {
			lists.add(new ArrayList<>());
		}
		lists.get(level).add(root.val);
		return level;
	}
}
