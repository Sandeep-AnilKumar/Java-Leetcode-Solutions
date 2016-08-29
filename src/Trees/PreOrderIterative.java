package Trees;
import Trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class PreOrderIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rootLeft = new TreeNode(3);
        TreeNode rootRight = new TreeNode(7);
        TreeNode leftLeft = new TreeNode(2);
        TreeNode leftRight = new TreeNode(4);
        //TreeNode rootRight = new TreeNode(7);

        root.right = rootRight;
        root.left = rootLeft;
        rootLeft.left = leftLeft;
        rootLeft.right = leftRight;
        preorderTraversal(root);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode cur = root;

        while(!dq.isEmpty() || cur != null) {
            if(cur != null) {
                dq.offerLast(cur);
                result.add(cur.val);
                cur = cur.left;
            }
            else {
                cur = dq.pollLast();
                cur = cur.right;
            }
        }
        return result;
    }
}
