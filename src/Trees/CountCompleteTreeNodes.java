package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        root.right = n3;
        root.left = n2;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n5.left = n10;

        System.out.println("The number of complete tree nodes are " + countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        TreeNode cur = root;
        while(cur.left != null) {
            count++;
            cur = cur.left;
        }

        count = ((int) Math.pow(2,count)) - 1;

        if(root.right == null) {
            return count;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);
        cur = root;

        while(!dq.isEmpty()) {
            cur = dq.pollLast();
            if(cur.right == null) {
                count++;
                if(cur.left != null) {
                    break;
                }
            }

            if(cur.right != null) dq.offerLast(cur.right);
            if(cur.left != null) dq.offerLast(cur.left);
        }
        return count;
    }
}
