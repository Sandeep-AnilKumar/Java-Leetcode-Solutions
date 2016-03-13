package Trees;

public class PathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		TreeNode rootLeft = new TreeNode(3);
		TreeNode rootRight = new TreeNode(4);
		TreeNode leftLeft = new TreeNode(1);
		//TreeNode leftLeftLeft = new TreeNode(1);
		TreeNode leftRight = new TreeNode(2);
		TreeNode rightLeft = new TreeNode(5);
		TreeNode rightRight = new TreeNode(0);
		//TreeNode rootRight = new TreeNode(7);

		root.right = rootRight;
		root.left = rootLeft;
		rootLeft.left = leftLeft;
		//leftLeft.left = leftLeftLeft;
		rootLeft.right = leftRight;
		rootRight.left = rightLeft;
		rootRight.right = rightRight;

		System.out.println(hasPathSum(root,16));

	}

	public static boolean hasPathSum(TreeNode root, int sum)
	{
		if(root == null)
			return false;

		return pathSum(root,sum) == 0;
	}

	public static int pathSum(TreeNode root, int sum)
	{
		if(root != null && root.val == sum)
			return 0;

		if(root == null)
			return -1;

		int thisLeftSum = pathSum(root.left, sum-root.val);
		int thisRightSum = pathSum(root.right, sum-root.val);

		if(thisLeftSum == 0 || thisRightSum == 0)
			return 0;

		return -1;
	}

}
