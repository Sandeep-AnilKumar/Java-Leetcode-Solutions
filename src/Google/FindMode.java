package Google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Trees.TreeNode;

public class FindMode {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(8);
		TreeNode n10 = new TreeNode(8);
		TreeNode n11 = new TreeNode(9);
		TreeNode n12 = new TreeNode(9);
		TreeNode n13 = new TreeNode(9);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n3.right = n4;
		n3.left = n5;
		n5.left = n6;
		n6.left = n7;
		n5.right = n8;
		n2.right = n9;
		n9.left = n10;
		n9.right = n11;
		n11.left = n12;
		n11.right = n13;

		int[] result = findMode(root);
		for(int i : result) {
			System.out.println(i + " ");
		}
	}

	public static int[] findMode(TreeNode node) {
		if(node == null) {
			return new int[0];
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		TreeNode cur = node;

		//Finding Inorder Traversal.
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.offerLast(cur);
				cur = cur.left;
			} else {
				cur = stack.pollLast();
				list.add(cur.val);
				cur = cur.right;
			}
		}

		//Getting the max from Inorder list.
		List<Integer> result = new ArrayList<>();
		int length = list.size();
		int prev = list.get(0);
		int curItem = 0;
		int count = 0;
		int max = 0;

		for(int i = 0; i < length; ++i) {
			curItem = list.get(i);
			if(i == 0 || curItem == prev) {
				count++;
			} else {
				if(count > max) {
					max = count;
					result = new ArrayList<>();
					result.add(prev);
				} else if(count == max) {
					result.add(prev);
				}
				count = 1;
				prev = curItem;
			}
		}

		if(count > max) {
			max = count;
			result = new ArrayList<>();
			result.add(prev);
		} else if(count == max) {
			result.add(prev);
		}

		int[] resultArray = new int[result.size()];

		int j = 0;
		for(int i : result) {
			resultArray[j++] = i;
		}
		return resultArray;
	}
}
