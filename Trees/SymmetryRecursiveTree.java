package Trees;

public class SymmetryRecursiveTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode rootLeft = new TreeNode(3);
		TreeNode rootRight = new TreeNode(3);
		TreeNode leftLeft = new TreeNode(4);
		//TreeNode leftLeftLeft = new TreeNode(1);
		TreeNode leftRight = new TreeNode(5);
		TreeNode rightLeft = null;
		TreeNode rightRight = new TreeNode(4);
		//TreeNode rootRight = new TreeNode(7);

		root.right = rootRight;
		root.left = rootLeft;
		rootLeft.left = leftLeft;
		//leftLeft.left = leftLeftLeft;
		rootLeft.right = leftRight;
		rootRight.left = rightLeft;
		rootRight.right = rightRight;
		System.out.println(isSymmetric(root));
	}

	public static boolean isSymmetric(TreeNode root)
	{
		if(root == null)
			return true;
		return isSymmetric(root.left, root.right);

	}

	public static boolean isSymmetric(TreeNode left, TreeNode right)
	{
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;

		if(left.val == right.val)
			return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);

		return false;
	}

}
