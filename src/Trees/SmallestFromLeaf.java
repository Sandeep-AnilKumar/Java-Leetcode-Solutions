package Trees;

public class SmallestFromLeaf {
    String ans = null;

    public static void main(String[] args) {
        SmallestFromLeaf smallestFromLeaf = new SmallestFromLeaf();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(1);
        TreeNode leftRight = new TreeNode(1);
        TreeNode rightLeft = new TreeNode(0);
        TreeNode leftRightLeft = new TreeNode(0);

        root.left = left;
        root.right = right;
        left.right = leftRight;
        right.left = rightLeft;
        leftRight.left = leftRightLeft;

        System.out.println("The smallest path from leaf is := " + smallestFromLeaf.smallestFromLeaf(root));
    }

    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return ans;
    }

    public void helper(TreeNode root, String prev) {
        if (root == null) return;
        String cur = (char) (root.val + 'a') + "" + prev;

        if (root.left == null && root.right == null) {
            if (ans == null || cur.compareTo(ans) < 0) ans = cur;
        }

        helper(root.left, cur);
        helper(root.right, cur);
    }
}
