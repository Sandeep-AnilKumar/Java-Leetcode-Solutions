package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistributeCoinsInBinaryTree {
	private Map<TreeNode, TreeNode> parent;
	private List<TreeNode> extra;
	private int total;

	public static void main(String[] args) {
		DistributeCoinsInBinaryTree distributeCoinsInBinaryTree = new DistributeCoinsInBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(0);
		TreeNode right = new TreeNode(2);

		root.left = left;
		root.right = right;
		System.out.println("The total moves to distribute coins is := " + distributeCoinsInBinaryTree.distributeCoins(root));
	}

	public int distributeCoins(TreeNode root) {
		parent = new HashMap<>();
		extra = new ArrayList<>();
		total = 0;
		dfs(root, null);

		for (TreeNode node : extra) bfs(node);
		return total;
	}

	private void bfs(TreeNode node) {
		if (node == null) return;
		Set<TreeNode> visited = new HashSet<>();
		Deque<TreeNode> dq = new ArrayDeque<>();
		dq.offer(node);
		int level = 0, size = 0;
		TreeNode cur;

		while (!dq.isEmpty() && node.val > 1) {
			size = dq.size();
			for (int i = 0; i < size && node.val > 1; ++i) {
				cur = dq.poll();
				if (visited.contains(cur)) continue;
				visited.add(cur);
				if (cur.val == 0) {
					cur.val++;
					node.val--;
					total += level;
				}

				if (cur.right != null) dq.offer(cur.right);
				if (cur.left != null) dq.offer(cur.left);
				if (parent.get(cur) != null) dq.offer(parent.get(cur));
			}

			level++;
		}
	}

	private void dfs(TreeNode node, TreeNode prev) {
		if (node == null) return;
		if (node.val > 1) extra.add(node);
		parent.put(node, prev);
		dfs(node.left, node);
		dfs(node.right, node);
	}
}