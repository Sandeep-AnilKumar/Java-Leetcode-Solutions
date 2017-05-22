package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructBinaryTree {

	public static void main(String[] args) {
		String s = "-4(-1(-3)(-5))(-2(-20))";
		System.out.println("The binary tree is := " + str2tree(s));
	}

	public static TreeNode str2tree(String s) {
		if(s == null || s.length() == 0) {
			return null;
		}

		boolean neg = false;
		int length = s.length();
		int num = 0;
		int index = 0;
		if(s.charAt(index) == '-') {
			neg = true;
			index++;
		}
		while(index < length && s.charAt(index) != ')' && s.charAt(index) != '(') {
			num = num * 10 + Integer.parseInt(String.valueOf(s.charAt(index++)));
		}
		if(neg) {
			num = -num;
			neg = false;
		}
		TreeNode root = new TreeNode(num);

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		TreeNode cur = root;

		for(;index < length; ++index) {
			num = 0;
			if(s.charAt(index) == ')') {
				stack.pollFirst();
			} else if(s.charAt(index) != '('){
				if(s.charAt(index) == '-') {
					neg = true;
					index++;
				}
				while(index < length && s.charAt(index) != ')' && s.charAt(index) != '(') {
					num = num * 10 + Integer.parseInt(String.valueOf(s.charAt(index++)));
				}
				if(neg) {
					num = -num;
				}
				prev = stack.peekFirst();
				if(prev != null && prev.left == null) {
					prev.left = new TreeNode(num);
					cur = prev.left;
				} else if(prev != null){
					prev.right = new TreeNode(num);
					cur = prev.right;
				}
				stack.offerFirst(cur);
				neg = false;
				--index;
			}
		}
		return root;
	}
}
