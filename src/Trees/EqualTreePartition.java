package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class EqualTreePartition {

	public static void main(String[] args) {
		EqualTreePartition eq = new EqualTreePartition();
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(20);
		TreeNode n5 = new TreeNode(15);

		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n2.right = n4;

		System.out.println("Can the tree be divided into two equal partitions? := " + eq.checkEqualTree(root));

		n2.right = n5;

		System.out.println("Can the tree be divided into two equal partitions? := " + eq.checkEqualTree(root));
	}
	
	//Inorder solution won't work in some cases.
	public boolean checkEqualTree(TreeNode root) {
		if(root == null) return false;

		List<Integer> inorder = getInorder(root);

		int sum = 0;
		for(int i: inorder) {
			sum += i;
		}

		int size = inorder.size();
		int cur = 0;

		for(int i = 0; i < size - 1; ++i) {
			cur += inorder.get(i);
			if(cur == sum - cur) return true;
		}
		return false;
	}

	public List<Integer> getInorder(TreeNode node) {
		Deque<TreeNode> dq = new ArrayDeque<>();
		TreeNode temp = node;
		List<Integer> inorder = new ArrayList<>();

		while(!dq.isEmpty() || temp != null) {
			if(temp != null) {
				dq.offerLast(temp);
				temp = temp.left;
			} else {
				temp = dq.pollLast();
				inorder.add(temp.val);
				temp = temp.right;
			}
		}
		return inorder;
	}
}