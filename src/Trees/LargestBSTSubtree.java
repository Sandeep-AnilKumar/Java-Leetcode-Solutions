package Trees;

public class LargestBSTSubtree {

    public int largestBSTSubtree(TreeNode root) {
        Result result = largestBSTSubtreeHelper(root);
        return result.size;
    }

    private Result largestBSTSubtreeHelper(TreeNode node) {
        if (node == null) return new Result(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);

        Result left = largestBSTSubtreeHelper(node.left);
        Result right = largestBSTSubtreeHelper(node.right);
        Result result;

        if (left.possible && right.possible && node.val > left.max && node.val < right.min) {
            result = new Result(1 + left.size + right.size, Math.max(node.val, right.max),
                    Math.min(node.val, left.min), true);
        } else {
            result = new Result(Math.max(left.size, right.size), 0, 0, false);
        }
        return result;
    }

    static class Result {
        int size;
        int max;
        int min;
        boolean possible;

        public Result(int size, int max, int min, boolean possible) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.possible = possible;
        }
    }
}
