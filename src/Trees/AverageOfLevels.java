package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevels {

	public static void main(String[] args) {
		AverageOfLevels avg = new AverageOfLevels();

		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(14);
		TreeNode n2 = new TreeNode(1);

		root.left = n1;
		n1.left = n2;

		System.out.println("The average of levels is := " + avg.averageOfLevels(root));
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> average = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.offerFirst(root);
		int temp = 0;
		double curSum = 0;
		TreeNode curNode = null;
		int curCount = 0;

		while(!stack.isEmpty()) {
			temp = stack.size();
			curSum = 0;
			curCount = 0;

			while(!stack.isEmpty() && temp-- > 0) {
				curNode = stack.pollLast();
				curSum += curNode.val;
				curCount++;

				if(curNode.right != null) stack.offerFirst(curNode.right);
				if(curNode.left != null) stack.offerFirst(curNode.left);
			}
			average.add(curSum / curCount);
		}
		return average;
	}
}