package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sandeepa
 */

public class ClosestBinaryTreeLeaf {

	public static void main(String[] args) {
		ClosestBinaryTreeLeaf closest = new ClosestBinaryTreeLeaf();
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(1);

		root.left = n1;
		root.right = n2;

		n1.left = n3;
		n3.left = n4;
		n4.left = n5;
		n5.left = n6;
		int k = 2;

		System.out.println("The closest leaf to node + '" + k + "' is := " + closest.findClosestLeaf(root, k));
	}

	public int findClosestLeaf(TreeNode root, int k) {    
		if(root == null) {
			return 0;
		}

		Map<Integer, List<Integer>> adj = new HashMap<>();
		Deque<TreeNode> dq = new ArrayDeque<>();
		TreeNode node = null;
		List<Integer> cur = new ArrayList<>();
		List<Integer> next = new ArrayList<>();
		Map<Integer, TreeNode> tree = new HashMap<>();
		Deque<Integer> queue = new ArrayDeque<>();
		int max = 0;

		dq.offer(root);

		while(!dq.isEmpty()) {
			node = dq.poll();
			tree.put(node.val, node);
			max = Math.max(max, node.val);

			if(!adj.containsKey(node.val)) {
				cur = new ArrayList<>();
			} else {
				cur = adj.get(node.val);
			}

			if(node.left != null) {
				dq.offer(node.left);
				cur.add(node.left.val);

				if(!adj.containsKey(node.left.val)) {
					next = new ArrayList<>();
				} else {
					next = adj.get(node.left.val);
				}

				next.add(node.val);
				adj.put(node.left.val, next);
			}

			if(node.right != null) {
				dq.offer(node.right);
				cur.add(node.right.val);

				if(!adj.containsKey(node.right.val)) {
					next = new ArrayList<>();
				} else {
					next = adj.get(node.right.val);
				}

				next.add(node.val);
				adj.put(node.right.val, next);
			}

			adj.put(node.val, cur);
		}

		int[] visited = new int[max + 1];
		queue.offer(k);
		int val = 0;

		while(!queue.isEmpty()) {
			val = queue.poll();

			if(visited[val] != 1) {
				node = tree.get(val);

				if(node.left == null && node.right == null) {
					return node.val;
				}

				cur = adj.get(val);
				if(cur != null && cur.size() > 0) {
					for(int nextVal : cur) {
						if(visited[nextVal] == 0) {
							queue.offer(nextVal);
							visited[nextVal] = -1;
						}
					}
				}

				visited[val] = 1;
			}
		}

		return 0;
	}
}