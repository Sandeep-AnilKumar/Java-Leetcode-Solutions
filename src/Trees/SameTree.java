package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        root1.left = node2;
        root1.right = node3;
        node2.left = node4;

        TreeNode root2 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node41 = new TreeNode(4);
        TreeNode node51 = new TreeNode(5);

        root2.left = node21;
        root2.right = node31;
        node21.left = node41;
        node21.right = node51;

        System.out.println("Are the two trees same := " + isSameTree(root1, root2));
    }

    //Recursive version.
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) {
            return q == null;
        }
        if(q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //Iterative version.
    public static boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Deque<TreeNode> stackP = new ArrayDeque<>();       
        Deque<TreeNode> stackQ = new ArrayDeque<>();

        if (p != null) {
            stackP.push( p ) ;
        }
        if (q != null) {
            stackQ.push( q ) ;
        }
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode pn = stackP.pop() ;
            TreeNode qn = stackQ.pop() ;          
            if (pn.val != qn.val) {
                return false ;
            }
            if (pn.right != null) {
                stackP.push(pn.right) ;
            }
            if (qn.right != null) {
                stackQ.push(qn.right) ;
            }
            if (stackP.size() != stackQ.size()) {
                return false ;
            }
            if (pn.left != null) {
                stackP.push(pn.left) ;                        
            }
            if (qn.left != null) {
                stackQ.push(qn.left) ;
            }
            if (stackP.size() != stackQ.size()) {
                return false ;
            }
        }           
        return stackP.size() == stackQ.size() ;  
    }    
}