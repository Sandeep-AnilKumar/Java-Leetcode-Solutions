package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TwoSumBST {

	public static void main(String[] args) {
		TwoSumBST bst = new TwoSumBST();
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(7);

		root.left = n1;
		root.right = n2;
		n1.left = n2;
		n1.right = n3;
		n4.right = n5;

		int k = 4;

		System.out.println("Are there two nodes which sum up to " + k + "? := " + bst.findTarget(root, k));
	}

	public boolean findTarget(TreeNode root, int k) {
		if(root == null) {
			return false;
		}

		Deque<TreeNode> dq = new ArrayDeque<>();
		TreeNode temp = root;

		List<Integer> values = new ArrayList<>();

		while(!dq.isEmpty() || temp != null) {
			if(temp != null) {
				dq.offer(temp);
				temp = temp.left;
			} else {
				temp = dq.pollLast();
				values.add(temp.val);
				temp = temp.right;
			}
		}

		int start = 0;
		int end = values.size() - 1;
		int curSum = 0;

		while(start < end) {
			curSum = values.get(start) + values.get(end);
			if(curSum == k) return true;
			else if(curSum < k) start++;
			else end--;
		}
		return false;
	}
}
