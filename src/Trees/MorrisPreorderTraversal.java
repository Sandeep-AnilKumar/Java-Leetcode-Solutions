package Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        TreeNode pre = null, cur = root, temp = null;

        while (cur != null) {
            if (cur.left == null) {
                order.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;

                if (pre.right == null) {
                    pre.right = cur;

                    //For inorder remove the following line and add it in else condition.
                    order.add(cur.val);
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }

        return order;
    }
}
