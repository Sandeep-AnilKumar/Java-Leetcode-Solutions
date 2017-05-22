package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DeleteNodeBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(7);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;

		System.out.println("The BST after deleting the node of value 3 is := " + deleteNode(root, 5));
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) {
			return root;
		}

		TreeNode cur = root;
		TreeNode prev = null;
		while(cur != null) {
			if(cur.val == key) {
				break;
			} else if(cur.val < key) {
				prev = cur;
				cur = cur.right;
			} else {
				prev = cur;
				cur = cur.left;
			}
		}
		if(cur == null) {
			return root;
		}

		List<Integer> inorder = new ArrayList<>();
		if(prev == null) {
			inorder = getInorder(cur);
			for(int i = 0; i < inorder.size(); ++i) {
				if(inorder.get(i) == key) {
					inorder.remove(i);
					break;
				}
			}

			return createBST(inorder);
		}

		if(prev != null && prev.right != null && prev.right.val == key) {
			prev.right = null;
		} else if(prev != null && prev.left != null && prev.left.val == key) {
			prev.left = null;
		}

		inorder = getInorder(cur);

		for(int n: inorder) {
			if(n != key) {
				addNodeBST(root, n);
			}
		}
		return root;
	}

	public static List<Integer> getInorder(TreeNode node) {
		List<Integer> inorder = new ArrayList<>();

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = node;

		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				inorder.add(cur.val);
				cur = cur.right;
			}
		}
		return inorder;
	}

	public static void addNodeBST(TreeNode node, int val) {
		if(node == null) {
			return;
		}

		TreeNode cur = node;
		while(cur != null) {
			if(cur.val > val) {
				if(cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = new TreeNode(val);
					break;
				}
			} else if(cur.val < val) {
				if(cur.right != null) {
					cur = cur.right;
				} else {
					cur.right = new TreeNode(val);
					break;
				}
			}
		}
		return;
	}

	public static TreeNode createBST(List<Integer> values) {
		if(values == null || values.size() == 0) {
			return null;
		}

		int[] nums = new int[values.size()];

		int index = 0;
		for(int n: values) {
			nums[index++] = n;
		}

		TreeNode root = null;
		root = createBST(root, nums, 0, nums.length - 1);
		return root;
	}

	public static TreeNode createBST(TreeNode node, int[]  nums, int start, int end) {
		if(end < start) {
			return null;
		}

		int mid = start + ((end - start) >>> 1);
		node = new TreeNode(nums[mid]);
		node.left = createBST(node, nums, start, mid - 1);
		node.right = createBST(node, nums, mid + 1, end);
		return node;
	}
}
