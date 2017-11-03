package Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sandeepa
 */

public class PathSum3Best {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(-3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(11);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(-2);
		TreeNode n8 = new TreeNode(1);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.right = n8;

		int sum = 8;

		System.out.println("The number of paths that sum to " + sum + " are := " + new PathSum3Best().pathSum(root, sum));
	}

	public int pathSum(TreeNode root, int sum) {
		if(root == null) return 0;

		Map<Integer, Integer> prefixSum = new HashMap<>();
		prefixSum.put(0, 1);

		return propogate(root, 0, sum, prefixSum);
	}

	public int propogate(TreeNode node, int curSum, int target, Map<Integer, Integer> prefixSum) {
		if(node == null) return 0;

		curSum += node.val;

		int count = prefixSum.getOrDefault(curSum - target, 0);
		prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);

		count += propogate(node.left, curSum, target, prefixSum);
		count += propogate(node.right, curSum, target, prefixSum);

		prefixSum.put(curSum, prefixSum.get(curSum) - 1);
		return count;
	}
}
