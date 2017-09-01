package Trees;

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		MergeTwoBinaryTrees trees = new MergeTwoBinaryTrees();

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

		System.out.println("The merged tree is := ");
		TreeNode merged = trees.mergeTrees(t1, t2);
		System.out.println(merged);
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return null;

		int cur = 0;

		if(t1 != null) {
			cur += t1.val;
		}

		if(t2 != null) {
			cur += t2.val;
		}

		TreeNode merged = new TreeNode(cur);
		merged.left = mergeTrees(t1 != null && t1.left != null ? t1.left : null, t2 != null && t2.left != null ? t2.left : null);
		merged.right = mergeTrees(t1 != null && t1.right != null ? t1.right : null, t2 != null && t2.right != null ? t2.right : null);
		return merged;
	}
}
