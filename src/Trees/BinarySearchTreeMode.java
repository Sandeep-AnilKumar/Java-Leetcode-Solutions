package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeMode {
    private Integer prev = null;
    private int count = 1;
    private int max = 0;

    public static void main(String[] args) {
        BinarySearchTreeMode binarySearchTreeMode = new BinarySearchTreeMode();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightRight = new TreeNode(2);
        root.right = right;
        right.right = rightRight;

        System.out.println("The mode of the BST is := ");
        int[] res = binarySearchTreeMode.findMode(root);
        Arrays.stream(res).forEach(System.out::println);
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
}
