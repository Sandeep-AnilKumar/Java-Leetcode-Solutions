package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	//A solution to find the total and then traverse again.

	boolean result = false;
	public boolean checkEqualTreeDFS(TreeNode root) {
		long sum = total(root, 0);
		if(sum % 2 != 0) return false;

		result = false;
		total(root, sum);
		return result;
	}
	private long total(TreeNode root, long sum) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return root.val;

		long left = total(root.left, sum);
		long right = total(root.right, sum);

		if((root.left != null && left == sum/2) || (root.right != null && right == sum/2)) {
			result = true;
		}
		return root.val + left + right;
	}

	//An excellent solution to traverse only once.

	public boolean checkEqualTreeMap(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = getsum(root, map);
		if(sum == 0)return map.getOrDefault(sum, 0) > 1;
		return sum%2 == 0 && map.containsKey(sum/2);
	}

	public int getsum(TreeNode root, Map<Integer, Integer> map ){
		if(root == null)return 0;
		int cur = root.val + getsum(root.left, map) + getsum(root.right, map);
		map.put(cur, map.getOrDefault(cur,0) + 1);
		return cur;
	}
}