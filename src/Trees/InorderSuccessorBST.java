package Trees;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class InorderSuccessorBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(8);
		TreeNode e = new TreeNode(7);

		root.left = a;
		root.right = d;
		a.left = c;
		a.right = b;
		d.left = e;

		System.out.println("The inorder successor of 7 is := " + inorderSuccessor(root, e));
		System.out.println("The inorder predecessor of 7 is := " + inorderPredecessor(root, e));
	}

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while(root != null) {
			if(root.val > p.val) {
				res = root;
				root = root.left;
			}
			else root = root.right;
		}
		return res;
	}

	public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while(root != null) {
			if(root.val < p.val) {
				res = root;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return res;
	}
}
