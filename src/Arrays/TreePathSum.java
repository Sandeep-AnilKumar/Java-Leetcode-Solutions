package Arrays;

import Trees.TreeNode;

public class TreePathSum {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode a = new TreeNode(7);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(2);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(1);
		TreeNode h = new TreeNode(8);
		TreeNode i = new TreeNode(1);

		node.left = a;
		node.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;
		c.left = g;
		c.right = h;
		d.left = i;

		System.out.println("All paths that sum to 5 are :=");
		findSum(node, 9);
	}

	public static void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}

	public static void findSum(TreeNode node, int sum, int[] path, int level) {
		if(node == null) {
			return;
		}

		path[level] = node.val;
		int t = 0;
		for(int i = level; i >= 0; --i) {
			t += path[i];
			if(t == sum) {
				print(path, i, level);
			}
		}

		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
	}

	public static int depth(TreeNode node) {
		if(node == null) {
			return 0;
		}

		return 1 + Math.max(depth(node.left), depth(node.right));
	}

	public static void print(int[] path, int start, int end) {
		for(int i = start; i < end; ++i) {
			System.out.print(path[i] + " -> ");
		}
		System.out.println(path[end]);
	}
}
