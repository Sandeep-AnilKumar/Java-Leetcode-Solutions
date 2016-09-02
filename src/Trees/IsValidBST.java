package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsValidBST {

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);

        n4.left = n2;
        n4.right = n7;
        n2.left = n1;
        n2.right = n3;
        n7.left = n6;
        n6.left = n5;
        System.out.println("Is BST valid? " + isValidBST(n4));
    }


    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
        TreeNode cur = root;
        int prev = Integer.MIN_VALUE;
        boolean flag = false;;
        int prev1 = root.val;

        while(!dq.isEmpty() || cur != null) {
            flag = true;
            if(cur != null) {
                dq.offerLast(cur);
                cur = cur.left;
            }
            else {
                cur = dq.pollLast();
                if(cur.val == prev1) {
                    flag = true;
                }
                if(!flag && cur.val <= prev) {
                    return false;
                }
                prev = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}
