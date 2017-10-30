package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sandeepa
 */

public class ValidBSTBetter {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);

		root.left = n2;
		System.out.println("Is a valid BST := " + new ValidBSTBetter().isValidBSTBetter(root));
	}

	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;

		Deque<TreeNode> dq = new ArrayDeque<>();
		TreeNode temp = root;
		List<Integer> list = new ArrayList<>();

		while(!dq.isEmpty() || temp != null) {
			if(temp != null) {
				dq.offerLast(temp);
				temp = temp.left;
			} else {
				temp = dq.pollLast();
				list.add(temp.val);
				temp = temp.right;
			}
		}

		int size = list.size();
		for(int i = 1; i < size; ++i) {
			if(list.get(i - 1) >= list.get(i)) return false;
		}
		return true;
	}

	public boolean isValidBSTBetter(TreeNode root) {
		return checkBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	public boolean checkBST(TreeNode node, long max, long min) {
		if(node == null) return true;

		if(node.val >= max || node.val <= min) return false;
		if(!checkBST(node.left, node.val, min) || !checkBST(node.right, max, node.val)) return false;

		if(node.left != null && node.val <= node.left.val) return false;
		if(node.right != null && node.val >= node.right.val) return false;
		return true;
	}
}
