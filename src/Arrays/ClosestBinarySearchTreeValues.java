package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import Trees.TreeNode;

public class ClosestBinarySearchTreeValues {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		TreeNode lleft = new TreeNode(3);
		TreeNode lright = new TreeNode(5);
		TreeNode rleft = new TreeNode(7);
		TreeNode rright = new TreeNode(9);

		root.left = left;
		root.right = right;
		left.left = lleft;
		left.right = lright;
		right.left = rleft;
		right.right = rright;

		ClosestBinarySearchTreeValues cbstv = new ClosestBinarySearchTreeValues();
		System.out.println(cbstv.closestKValuesBetter(root, 5.285714, 5));
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

	public List<Integer> closestKValuesBetter(TreeNode root, double target, int k) {
		if(root == null || k <= 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> result = new ArrayList<>();
		Map<Double, List<Integer>> diffMap = new HashMap<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode temp = root;
		Double diff = 0d;
		List<Integer> tempList = null;

		while(!stack.isEmpty() || temp != null) {
			if(temp != null) {
				stack.offerFirst(temp);
				diff = Math.abs(temp.val - target);
				tempList = diffMap.get(diff); 
				if(tempList ==  null) {
					tempList = new ArrayList<>();	
				}
				tempList.add(temp.val);
				diffMap.put(diff, tempList);
				temp = temp.left;
			} else {
				temp = stack.pollFirst();
				temp = temp.right;
			}
		}

		Double[] keys = new Double[diffMap.size()];
		Collections.sort(Arrays.asList(diffMap.keySet().toArray(keys)));
		int index = 0;
		while(k > 0) {
			tempList = diffMap.get(keys[index++]);
			k -= tempList.size();
			for(int val: tempList) {
				result.add(val);
			}
		}

		return result;
	}
}
