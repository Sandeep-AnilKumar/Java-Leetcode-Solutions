package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {

	public static void main(String[] args) {

		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);

		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n3.left = n7;
		n4.left = n8;
		n6.left = n9;
		n6.right = n10;

		List<List<Integer>> result = levelOrderTraversal2(n0);

		for(List<Integer> node : result) {
			System.out.println(node.toString());
		}
	}

	public static List<List<Integer>> levelOrderTraversal1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}

		Deque<TreeNode> st = new ArrayDeque<TreeNode>();
		st.offerLast(root);

		TreeNode cur = null;
		List<Integer> subPath = new ArrayList<Integer>();
		int size = 0;
		int nextRound = 0;

		while(!st.isEmpty()) {
			subPath = new ArrayList<Integer>();
			size = st.size();

			while(size-- > 0) {
				cur = st.pollFirst();

				if((nextRound ^ 1) == 1) {
					subPath.add(cur.val);
				}
				else {
					subPath.add(0,cur.val);
				}

				if(cur.left != null) {
					st.offerLast(cur.left);
				}

				if(cur.right != null) {
					st.offerLast(cur.right);
				}
			}
			nextRound ^=  1;
			result.add(subPath);
		}
		return result;
	}

	//Other solution: -

	public static List<List<Integer>> levelOrderTraversal2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}

		Deque<TreeNode> st = new ArrayDeque<TreeNode>();
		st.offerLast(root);

		TreeNode cur = null;
		List<Integer> subPath = new ArrayList<Integer>();
		int size = 0;
		int nextRound = 0;

		while(!st.isEmpty()) {
			subPath = new ArrayList<Integer>();
			size = st.size();

			while(size-- > 0) {
				//pop_back, push_front, left then right
				if((nextRound ^ 1) == 1) {
					cur = st.pollLast();
					subPath.add(cur.val);

					if(cur.left != null) {
						st.offerFirst(cur.left);
					}

					if(cur.right != null) {
						st.offerFirst(cur.right);
					}
				}

				//pop_front, push_back, right then left
				else {
					cur = st.pollFirst();
					subPath.add(cur.val);

					if(cur.right != null) {
						st.offerLast(cur.right);
					}

					if(cur.left != null) {
						st.offerLast(cur.left);
					}
				}
			}
			nextRound ^= 1;
			result.add(subPath);
		}
		return result;
	}
}
