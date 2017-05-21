package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MostFrequentSubtreeSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(-5);

		root.left = left;
		root.right = right;

		System.out.println("The most frequent subtree sum is := ");
		int[] result = findFrequentTreeSum(root);
		for(int i: result) {
			System.out.print(i + " ");
		}
	}

	public static int[] findFrequentTreeSum(TreeNode root) {
		if(root == null) {
			return new int[0];
		}

		Map<Integer, Integer> map = new HashMap<>();
		getFrequencies(root, map);

		int max = Integer.MIN_VALUE;
		for(int k: map.keySet()) {
			if(map.get(k) > max) {
				max = map.get(k);
			}
		}

		List<Integer> keys = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue() == max) {
				keys.add(entry.getKey());
			}
		}

		int[] result = new int[keys.size()];
		int index = 0;
		for(int k: keys) {
			result[index++] = k;
		}
		return result;
	}

	public static int getFrequencies(TreeNode node, Map<Integer, Integer> map) {
		if(node == null) {
			return 0;
		}

		int curSum = node.val;
		curSum += getFrequencies(node.left, map);
		curSum += getFrequencies(node.right, map);

		if(map.containsKey(curSum)) {
			map.put(curSum, map.get(curSum) + 1); 
		} else {
			map.put(curSum, 1);
		}

		return curSum;
	}
}
