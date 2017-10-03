package Trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(-1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(8);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n3.left = n5;

		System.out.println(lowestCommonAncestor(root, n5, n4).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if(root == null || (root.left == null && root.right == null))
			return root;

		Map<TreeNode,TreeNode> parentOf = new HashMap<TreeNode,TreeNode>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		stack.push(root);
		parentOf.put(root, null);

		while(!parentOf.containsKey(p) || !parentOf.containsKey(q)) {

			TreeNode temp = stack.pop();

			if(temp.left != null) {
				parentOf.put(temp.left,temp);
				stack.push(temp.left);
			}

			if(temp.right != null) {
				parentOf.put(temp.right, temp);
				stack.push(temp.right);
			}
		}

		Set<TreeNode> ancestors = new HashSet<TreeNode>();

		while(p != null) {
			p = parentOf.get(p);
			ancestors.add(p);
		}

		while(!ancestors.contains(q)) {
			q = parentOf.get(q);
		}

		return q;
	}
}
