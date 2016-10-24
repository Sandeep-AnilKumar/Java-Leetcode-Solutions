package DynamicProgramming;

import Trees.TreeNode;

public class HouseRobberBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.right = t5;

        System.out.println("Maximum Profit Robbing Alternate houses is : " + robBetter(root));
    }

    //A very slow solution, sub problems are recalculated every time. Which is unnecessary.
    public static int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = 0, right = 0;
        int subLeft = 0, subRight = 0;

        if(root.left != null) {
            left = rob(root.left);
            subLeft = rob(root.left.right) + rob(root.left.left);
        }

        if(root.right != null) {
            right = rob(root.right);
            subRight = rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(root.val + subRight + subLeft, left + right);
    }

    //A better solution.

    public static int robBetter(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int[] result = robBetterDP(root);
        //result[0] is if root is included or robbed. result[1] is when root is not robbed.
        return Math.max(result[0], result[1]);
    }

    public static int[] robBetterDP(TreeNode root) {
        int[] result = new int[2];
        if(root == null) {
            return result;
        }

        int[] left = robBetterDP(root.left);
        int[] right = robBetterDP(root.right);

        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }
}
