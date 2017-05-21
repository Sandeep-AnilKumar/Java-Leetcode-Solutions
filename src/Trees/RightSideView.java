package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);

		root.left = a;
		root.right = b;
		b.left = c;
		a.right = d;
		d.left = e;

		System.out.println("The right side view of the tree is := " + rightSideView(root));
	}


	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> nodes = new ArrayList<>();
		if(root == null) {
			return nodes;
		}

		List<List<Integer>> levels = new ArrayList<>();
		List<Integer> curLevel = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();

		curLevel.add(root.val);
		levels.add(curLevel);
		queue.offerLast(root);
		TreeNode cur = null;
		int size = 0;

		while(!queue.isEmpty()) {
			size = queue.size();
			curLevel = new ArrayList<>();

			while(size-- > 0) {
				cur = queue.pollFirst();
				if(cur.left != null) {
					curLevel.add(cur.left.val);
					queue.offerLast(cur.left);
				}
				if(cur.right != null) {
					curLevel.add(cur.right.val);
					queue.offerLast(cur.right);
				}
			}

			if(curLevel != null && curLevel.size() > 0) {
				levels.add(curLevel);
			}
		}

		int depth = levels.size();
		for(int i = 0; i < depth; ++i) {
			curLevel = levels.get(i); 
			nodes.add(curLevel.get(curLevel.size() - 1));
		}
		return nodes;
	}
}
