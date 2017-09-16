package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumWidthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(7);

		root.left = n2;
		root.right = n3;
		n2.left = n4;
		n4.left = n5;
		n3.right = n6;
		n6.right = n7;

		MaximumWidthOfBinaryTree width = new MaximumWidthOfBinaryTree();
		System.out.println("The maximum width of the binary tree is := " + width.widthOfBinaryTree(root));
	}

	//Will not work for a very big tree.
	class TreeKey {
		boolean present;
		TreeNode node;

		public TreeKey(boolean present, TreeNode node) {
			this.present = present;
			this.node = node;
		}
	}

	public int widthOfBinaryTree(TreeNode root) {
		if(root == null) return 0;

		Deque<TreeKey> dq = new ArrayDeque<>();
		List<List<String>> levels = new ArrayList<>();
		dq.offer(new TreeKey(true, root));
		TreeKey cur = null;
		List<String> curLevel = new ArrayList<>();
		curLevel.add(root.val + "");
		levels.add(curLevel);

		int size = 0;
		boolean present = false;

		while(!dq.isEmpty()) {
			curLevel = new ArrayList<>();
			size = dq.size();
			present = false;

			while(size-- > 0) {
				cur = dq.poll();

				if(cur.present) {
					if(cur.node.left != null) {
						present = true;
						curLevel.add(cur.node.left.val + "");
						dq.offer(new TreeKey(true, cur.node.left));
					} else {
						curLevel.add("N");
						dq.offer(new TreeKey(false, null));
					}

					if(cur.node.right != null) {
						present = true;
						curLevel.add(cur.node.right.val + "");
						dq.offer(new TreeKey(true, cur.node.right));
					} else {
						curLevel.add("N");
						dq.offer(new TreeKey(false, null));
					}
				} else {
					curLevel.add("N");
					curLevel.add("N");
				}
			}
			if(present) {
				levels.add(new ArrayList<>(curLevel));
			} else {
				break;
			}
		}

		size = levels.size();
		int max = 1;
		int end = 0;
		int start = 0;
		for(int i = size - 1; i >= 0; --i) {
			curLevel = levels.get(i);

			end = curLevel.size() -1;
			start = 0;
			while(end >= 0 && curLevel.get(end).contains("N")) {
				end--;
			}
			max = Math.max(max, end - start + 1);
		}
		return max;
	}

	//A better solution.

	public int widthOfBinaryTreeBetter(TreeNode root) {
		if(root == null) return 0;
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		ArrayDeque<Integer>  count = new ArrayDeque<>();
		queue.offer(root);
		count.offer(0);
		int max = 1;

		while(!queue.isEmpty()) {
			int size = queue.size();
			int left = 0;
			int right = 0;
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				int index = count.poll();
				if(i == 0)  left = index;
				if(i == size-1)  right = index;
				if(node.left != null) {
					queue.offer(node.left);
					count.offer(index*2);
				}
				if(node.right != null) {
					queue.offer(node.right);
					count.offer(index*2 + 1);
				}
			}
			max = Math.max(max,right - left + 1);
		}
		return max;
	}
}
