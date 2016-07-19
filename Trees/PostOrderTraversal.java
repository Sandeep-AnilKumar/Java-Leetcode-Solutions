package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode rootLeft = new TreeNode(2);
		TreeNode rootRight = new TreeNode(3);
		TreeNode leftLeft = new TreeNode(4);
		TreeNode rightLeft = new TreeNode(5);
		TreeNode rightRight = new TreeNode(6);
		TreeNode rightRightLeft = new TreeNode(7);

		root.right = rootRight;
		root.left = rootLeft;
		rootLeft.left = leftLeft;
		rootRight.left = rightLeft;
		rootRight.right = rightRight;
		rightRight.left = rightRightLeft;
		postOrderTraversal(root);

	}
	public static List<Integer> postOrderTraversal(TreeNode root)
	{	
		ArrayList<Integer> lst = new ArrayList<Integer>();

		if(root == null)
			return lst; 

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode prev = null;
		while(!stack.empty()){
			TreeNode curr = stack.peek();

			// go down the tree.
			//check if current node is leaf, if so, process it and pop stack,
			//otherwise, keep going down
			if(prev == null || prev.left == curr || prev.right == curr){
				//prev == null is the situation for the root node
				if(curr.left != null){
					stack.push(curr.left);
				}else if(curr.right != null){
					stack.push(curr.right);
				}else{
					stack.pop();
					lst.add(curr.val);
				}

				//go up the tree from left node    
				//need to check if there is a right child
				//if yes, push it to stack
				//otherwise, process parent and pop stack
			}else if(curr.left == prev){
				if(curr.right != null){
					stack.push(curr.right);
				}else{
					stack.pop();
					lst.add(curr.val);
				}

				//go up the tree from right node 
				//after coming back from right node, process parent node and pop stack. 
			}else if(curr.right == prev){
				stack.pop();
				lst.add(curr.val);
			}

			prev = curr;
		}

		return lst;

	}
}
