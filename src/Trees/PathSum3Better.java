package Trees;

import java.util.HashMap;
import java.util.Map;

public class PathSum3Better {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(-1);
		TreeNode n5 = new TreeNode(-3);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(-2);

		root.left = n2;
		n2.left = n3;
		n2.right = n6;
		n3.left = n4;
		root.right = n5;
		n5.left = n7;
		PathSum3Better pathSum = new PathSum3Better();
		int sum = -1;
		int paths = pathSum.pathSumBetter(root, sum);
		System.out.println("The number of paths having the sum := " + sum + " is := " + paths);
	}

	//Will be a runtime of O(n2).
	public int pathSum(TreeNode root, int sum) {
		if(root == null) return 0;
		int res = 0;
		res = hasPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
		return res;
	}

	public int hasPath(TreeNode node, int sum) {
		int res = 0;
		if(node == null) return 0;
		if(node.val == sum) res++;
		res += hasPath(node.left, sum - node.val);
		res += hasPath(node.right, sum - node.val);
		return res;
	}

	//Will be a runtime of O(n).
	public int pathSumBetter(TreeNode root, int sum) {
		Map<Integer, Integer> pSum = new HashMap<>();
		pSum.put(0, 1);
		return hasPath(root, 0, sum, pSum);
	}

	public int hasPath(TreeNode node, int curSum, int sum, Map<Integer, Integer> pSum) {
		if(node == null) return 0;

		curSum += node.val;
		int result = pSum.getOrDefault(curSum - sum, 0);
		pSum.put(curSum, pSum.getOrDefault(curSum, 0) + 1);
		result += hasPath(node.left, curSum, sum, pSum) + hasPath(node.right, curSum, sum, pSum);
		pSum.put(curSum, pSum.get(curSum) - 1);
		return result;
	}
}
