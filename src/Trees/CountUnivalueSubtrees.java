package Trees;

public class CountUnivalueSubtrees {
	static int count = 0;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(5);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;

		System.out.println("The number of univalue subtrees is := " + countUnivalSubtrees(root));
	}

	public static int countUnivalSubtrees(TreeNode root) {
		if(root == null) {
			return 0;
		}

		traverse(root);
		return count;
	}

	public static boolean traverse(TreeNode node) {
		if(node == null) {
			return true;
		}

		boolean left = traverse(node.left);
		boolean right = traverse(node.right);

		if(left && right) {
			if(node.left != null && node.left.val != node.val) {
				return false;
			}

			if(node.right != null && node.right.val != node.val) {
				return false;
			}

			count++;
			return true;
		} else {
			return false;
		}
	}
}
