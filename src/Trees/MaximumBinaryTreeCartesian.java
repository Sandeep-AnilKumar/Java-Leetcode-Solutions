package Trees;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumBinaryTreeCartesian {
    public static void main(String[] args) {
        MaximumBinaryTreeCartesian maximumBinaryTreeCartesian = new MaximumBinaryTreeCartesian();
        int[] nums = {3, 2, 1, 6};
        System.out.println("The maximum binary tree is := " + maximumBinaryTreeCartesian.constructMaximumBinaryTree(nums));
        nums = new int[]{6, 3, 1, 2, 4};
        System.out.println("The maximum binary tree is := " + maximumBinaryTreeCartesian.constructMaximumBinaryTree(nums));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}
