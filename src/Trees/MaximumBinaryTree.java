package Trees;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        MaximumBinaryTree mbt = new MaximumBinaryTree();
        int[] nums = {3, 2, 1, 6, 0, 5};
        System.out.println(mbt.constructMaximumBinaryTree(nums));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = findLargest(nums, left, right);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, left, mid - 1);
        node.right = construct(nums, mid + 1, right);
        return node;
    }

    private int findLargest(int[] nums, int left, int right) {
        int index = 0, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}

