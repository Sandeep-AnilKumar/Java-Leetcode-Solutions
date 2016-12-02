package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(12);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);

        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;

        System.out.println("The sum of left leaves is := " + sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<String> parent = new ArrayDeque<>();
        q.offer(root);
        parent.offer("root");
        int sum = 0;
        String current = "";
        TreeNode node = null;
        while(!q.isEmpty() && !parent.isEmpty()) {
            node = q.poll();
            current = parent.poll();

            if(node.left != null) {
                q.offer(node.left);
                parent.offer("left");
            }

            if(node.right != null) {
                q.offer(node.right);
                parent.offer("right");
            }

            if(node.left == null && node.right == null && current == "left") {
                sum += node.val;
            }
        }
        return sum;
    }   
}
