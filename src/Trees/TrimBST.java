package Trees;

public class TrimBST {

	public static void main(String[] args) {
		TrimBST trim = new TrimBST();
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(1);

		root.left = n1;
		root.right = n2;
		n1.right = n3;
		n3.left = n4;

		int L = 1;
		int R = 3;

		System.out.println("The trimmed BST is := " + trim.trimBST(root, L, R));
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null) return root;

		if(L > root.val) return trimBST(root.right, L, R);
		if(root.val > R) return trimBST(root.left, L, R);

		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);

		return root;
	}
}
