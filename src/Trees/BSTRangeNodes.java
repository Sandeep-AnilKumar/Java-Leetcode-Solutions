package Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BSTRangeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(10);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(printRangeNodes(root, 5, 11));
    }

    public static List<Integer> printRangeNodes(TreeNode root, int from, int to) {
        List<Integer> result = new LinkedList<>();
        if(root == null) {
            return result;
        }
        printRangeNodes(root, from, to, result);
        return result;
    }

    public static void printRangeNodes(TreeNode root, int from, int to, List<Integer> result) {
        if(root == null) {
            return;
        }
        if(root.val >= from && root.val <= to) {
            result.add(root.val);
        }

        printRangeNodes(root.left, from, to, result);
        printRangeNodes(root.right, from, to, result);
        return;
    }
}
