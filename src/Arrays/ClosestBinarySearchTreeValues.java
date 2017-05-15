package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

import Trees.TreeNode;

public class ClosestBinarySearchTreeValues {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(12);
		TreeNode lleft = new TreeNode(3);
		TreeNode lright = new TreeNode(6);
		TreeNode rleft = new TreeNode(11);
		TreeNode rright = new TreeNode(13);

		root.left = left;
		root.right = right;
		left.left = lleft;
		left.right = lright;
		right.left = rleft;
		right.right = rright;

		ClosestBinarySearchTreeValues cbstv = new ClosestBinarySearchTreeValues();
		System.out.println(cbstv.closestKValues(root, 9.0, 4));
	}

	//Will not work for Double values.
	public class DiffVal {
		double diff;
		int val;

		DiffVal(int val, double diff) {
			this.diff = diff;
			this.val = val;
		}
	}

	//Will not work for Double values.
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		if(root == null || k <= 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> result = new ArrayList<>();
		PriorityQueue<DiffVal> min = new PriorityQueue<>(10000, new Comparator<DiffVal>(){
			@Override
			public int compare(DiffVal d1, DiffVal d2) {
				return (int) (d1.diff - d2.diff);
			}
		});
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode temp = root;

		while(!stack.isEmpty() || temp != null) {
			if(temp != null) {
				stack.offerFirst(temp);
				min.offer(new DiffVal(temp.val, Math.abs(temp.val - target)));
				temp = temp.left;
			} else {
				temp = stack.pollFirst();
				temp = temp.right;
			}	
		}

		while(k-- > 0) {
			result.add(min.poll().val);
		}
		return result;
	}
}
