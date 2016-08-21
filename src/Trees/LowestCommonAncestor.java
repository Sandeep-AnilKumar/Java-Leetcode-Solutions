package Trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode rootLeft = new TreeNode(3);
		TreeNode rootRight = new TreeNode(7);
		TreeNode leftLeft = new TreeNode(2);
		TreeNode leftLeftLeft = new TreeNode(1);
		TreeNode leftRight = new TreeNode(4);
		//TreeNode rootRight = new TreeNode(7);

		root.right = rootRight;
		root.left = rootLeft;
		rootLeft.left = leftLeft;
		leftLeft.left = leftLeftLeft;
		rootLeft.right = leftRight;
		System.out.println(lowestCommonAncestor(root, leftRight, leftLeftLeft).val);
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
			
			if(temp.left != null)
			{
				parentOf.put(temp.left,temp);
				stack.push(temp.left);
			}
			
			if(temp.right != null)
			{
				parentOf.put(temp.right, temp);
				stack.push(temp.right);
			}
		}
		
		Set<TreeNode> ancestors = new HashSet<TreeNode>();
		
		while(p != null)
		{
			p = parentOf.get(p);
			ancestors.add(p);
		}
		
		while(!ancestors.contains(q))
		{
			q = parentOf.get(q);
		}
		
		return q;
	}
}
