package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindBottomLeftValue {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);

		node.left = a;
		node.right = b;
		a.left = c;
		b.left = d;
		b.right = e;
		d.left = f;

		System.out.println("The leftmost value in the last row is := " + findBottomLeftValue(node));
	}


	public static int findBottomLeftValue(TreeNode root) {
		List<List<Integer>> level = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		List<Integer> curLevel = new ArrayList<>();
		curLevel.add(root.val);
		level.add(curLevel);
		queue.offerLast(root);

		int size = 0;
		TreeNode cur = null;

		while(!queue.isEmpty()) {
			size = queue.size();
			curLevel = new ArrayList<>();

			while(size-- > 0) {
				cur = queue.pollFirst();
				if(cur.left != null) {
					queue.offerLast(cur.left);
					curLevel.add(cur.left.val);
				}

				if(cur.right != null) {
					queue.offerLast(cur.right);
					curLevel.add(cur.right.val);
				}
			}

			if(curLevel.size() > 0) {
				level.add(curLevel);
			}
		}

		return level.get(level.size() - 1).get(0);
	}

	//A much easier solution.

	public static int findBottomLeftValueBetter(TreeNode root) {
		return findValueWithDepth(root, new int[]{0, 0}, 1);    
	}

	/*res[0]: val of TreeNode, res[1]: depth*/
	private static int findValueWithDepth(TreeNode root, int[] res, int depth) {
		if(res[1] < depth) {
			res[0] = root.val;
			res[1] = depth;
		}   
		if(root.left != null) {
			findValueWithDepth(root.left, res, depth+1);
		}
		if(root.right != null) {
			findValueWithDepth(root.right, res, depth+1);
		}
		return res[0];
	}
}
