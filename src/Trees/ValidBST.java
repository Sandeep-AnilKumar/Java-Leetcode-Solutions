package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode rootLeft = new TreeNode(5);
        TreeNode rootRight = new TreeNode(15);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(20);

        root.right = rootRight;
        root.left = rootLeft;
        rootRight.left = rightLeft;
        rootRight.right = rightRight;
        System.out.println(isValidBSTEasier(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> inorder = new ArrayList<>();
        TreeNode node = root;
        while(!dq.isEmpty() || node != null) {
            while(node != null) {
                dq.offerLast(node);
                node = node.left;
            }
            node = dq.pollLast();
            inorder.add(node.val);
            node = node.right;
        }
        return isValidBSTInorder(inorder, root.val);
    }

    public static boolean isValidBSTInorder(List<Integer> nodes, int pivot) {
        if(nodes == null) {
            return true;
        }

        int pIndex = nodes.indexOf(pivot);
        for(int i = 0; i < pIndex; ++i) {
            if(nodes.get(i) >= pivot) {
                return false;
            }
        }

        for(int i = pIndex + 1; i < nodes.size(); ++i) {
            if(nodes.get(i) <= pivot) {
                return false;
            }
        }
        return true;
    }

    //Easier solution.
    public static boolean isValidBSTEasier(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            if(pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
