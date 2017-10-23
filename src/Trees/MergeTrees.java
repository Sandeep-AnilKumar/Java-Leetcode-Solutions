package Trees;

/**
 * @author sandeepa
 */

public class MergeTrees {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);

		t1.left = n1;
		t1.right = n2;
		n1.left = n3;

		TreeNode t2 = new TreeNode(2);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);

		t2.left = n4;
		t2.right = n5;
		n4.right = n6;
		n5.right = n7;

		System.out.println("The merged tree is := " + new MergeTrees().mergeTrees(t1, t2));
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		return merge(null, t1, t2);
	}

	public TreeNode merge(TreeNode result, TreeNode t1, TreeNode t2) {
		if(t1 == null) return t2;
		if(t2 == null) return t1;

		result = new TreeNode(t1.val + t2.val);
		result.left = merge(result, t1.left, t2.left);
		result.right = merge(result, t1.right, t2.right);
		return result;
	}
}
