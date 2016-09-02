package Trees;
import Trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
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

        List<Integer> result = inorderTraversal(root);

        for(int val : result) {
            System.out.print(val + " ");
        }
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

    //Wrong.
    public static List<Integer> inorderTraversalIterative1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }

        Stack<TreeNode> dq = new Stack<TreeNode>();
        TreeNode cur = root;
        dq.push(root);

        while(!dq.isEmpty() || cur != null) {
            if(cur != null) {
                dq.push(cur.left);
                cur = cur.left;
            }
            else {
                cur = dq.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;
    }
}
