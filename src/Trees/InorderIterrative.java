package Trees;
import Trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class InorderIterrative {

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

        inorderTraversal(root);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        if(root == null)
            return returnList;

        Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
        TreeNode temp = root;

        while(!dq.isEmpty()|| temp != null) {
            if(temp != null) {
                dq.push(temp);
                temp = temp.left;
            }
            else {
                TreeNode n = dq.pop();
                returnList.add(n.val);
                temp = n.right;
            }
        }
        return returnList;
    }
}
