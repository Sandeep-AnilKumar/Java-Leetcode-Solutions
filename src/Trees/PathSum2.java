package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(5);
        TreeNode t9 = new TreeNode(1);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;
        List<List<Integer>> result = pathSum(root, 22);
        for(List<Integer> p : result) {
            System.out.println(p);
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, path, result);
        return result;
    }

    public static void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if(root == null) {
            return;
        }
        if(sum == root.val && root.left == null && root.right == null) {
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val);
        pathSum(root.left, sum - root.val, path, result);
        pathSum(root.right, sum - root.val, path, result);
        path.remove(path.size() - 1);
        return;
    }
}
