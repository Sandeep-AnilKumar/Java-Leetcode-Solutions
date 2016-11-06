package Trees;

public class ValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode rootLeft = new TreeNode(3);
        TreeNode rootRight = new TreeNode(7);

        root.right = rootRight;
        root.left = rootLeft;
        System.out.println(isValidBST(root));
    }


    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean result;
        if((root.left != null && root.val < root.left.val) || (root.right != null && root.right.val < root.val)) {
            return false;
        }
        else {
            result = isValidBST(root.left) && isValidBST(root.right);
        }
        return result;
    }
}
