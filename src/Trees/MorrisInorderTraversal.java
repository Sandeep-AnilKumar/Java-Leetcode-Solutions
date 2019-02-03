package Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {

    // The main motivation here is to keep track of the successor while traversing the node in an
    // inorder sequence. We do so by visiting the rightmost node in the left sub-tree and pointing
    // the current node as its successor.


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        TreeNode pre = null, cur = root, temp = null;

        while (cur != null) {

            //If the left subtree does not exist, add this node to the order and move on to the right subtree.
            if (cur.left == null) {
                order.add(cur.val);
                cur = cur.right;

            } else {
                pre = cur.left;

                //Go to the left subtree and move to the right most node, unless you hit null or the current node.

                while (pre.right != null && pre.right != cur) pre = pre.right;

                // if you hit null, then this is the first time we are traversing this edge, mark the cur node as
                // successor to this node.

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;

                    // we have already traversed this path, this is a backedge, set it to null and move on.
                } else {
                    pre.right = null;
                    order.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return order;
    }
}
