package Trees;

public class MirrorImage {

	public static void main(String[] args) {

	}

	public boolean isMirror(TreeNode root) {
		if(root == null)
			return false;

		return isMirrorImage(root.left,root.right);
	}

	public boolean isMirrorImage(TreeNode left, TreeNode right)
	{
		if(left != null && right != null && left.val == right.val)
		{
			return isMirrorImage(left.left,right.right) && isMirrorImage(left.right, right.left);
		}

		if(left == null && right == null)
		{
			return true;
		}   

		else
		{
			return false;
		}     
	}
}
