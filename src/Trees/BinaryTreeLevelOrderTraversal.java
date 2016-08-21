package Trees;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(0);
		TreeNode rootLeft = new TreeNode(1);
		TreeNode rootRight = new TreeNode(2);
		TreeNode leftLeft = new TreeNode(3);
		TreeNode leftRight = new TreeNode(4);
		TreeNode rightLeft = new TreeNode(5);

		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = leftLeft;
		rootLeft.right = leftRight;
		rootRight.left = rightLeft;

		List<List<Integer>> result = levelOrderTraversal(root);

		for(List<Integer> node : result) {
			System.out.println(node.toString());
		}
	}

	public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}

		Deque<TreeNode> st = new ArrayDeque<TreeNode>();
		st.offerLast(root);

		TreeNode cur = null;
		List<Integer> subPath = new ArrayList<Integer>();
		int size = 0;

		while(!st.isEmpty()) {
			subPath = new ArrayList<Integer>();
			size = st.size();

			while(size-- > 0) {
				cur = st.pollFirst();
				subPath.add(cur.val);

				if(cur.left != null) {
					st.offerLast(cur.left);
				}

				if(cur.right != null) {
					st.offerLast(cur.right);
				}
			}
			result.add(subPath);
		}
		return result;
	}
}
