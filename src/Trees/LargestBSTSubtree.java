package Trees;

public class LargestBSTSubtree {
	int max = 0;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(15);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(8);
		TreeNode e = new TreeNode(7);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;

		LargestBSTSubtree lbst = new LargestBSTSubtree();
		System.out.println("The largest BST Subtree is of size := " + lbst.largestBSTSubtree(root));
	}

	class Result {
		int size;
		int upper;
		int lower;

		Result(int size, int lower, int upper) {
			this.size = size;
			this.lower = lower;
			this.upper = upper;
		}
	}

	public int largestBSTSubtree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		traverse(root, null);
		return max;
	}

	public Result traverse(TreeNode node, TreeNode parent) {
		if(node == null) {
			return new Result(0, parent.val, parent.val);
		}

		Result left = traverse(node.left, node);
		Result right = traverse(node.right, node);

		if(left.size == -1 || right.size == -1 || node.val <= left.upper || node.val >= right.lower) {
			return new Result(-1, 0, 0);
		}

		int size = left.size + 1 + right.size;
		max = Math.max(size, max);
		return new Result(size, Math.min(left.lower, node.val), Math.max(right.upper, node.val));
	}
}
