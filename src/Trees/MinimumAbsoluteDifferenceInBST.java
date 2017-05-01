package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(4);
		TreeNode rightLeft = new TreeNode(2);
		root.right = right;
		right.left = rightLeft;
		System.out.println(getMinimumDifference(root));
	}

	public static int getMinimumDifference(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		List<Integer> nums = new ArrayList<>();
		TreeNode cur = root;
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				nums.add(cur.val);
				cur = cur.right;
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.size() - 1; ++i) {
			min = Math.min(min, Math.abs(nums.get(i) - nums.get(i + 1)));
		}
		return min;
	}
}
