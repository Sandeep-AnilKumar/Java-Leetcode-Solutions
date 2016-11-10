package Trees;


public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        root.right = n3;
        root.left = n2;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        System.out.println("The number of complete tree nodes are " + countNodes(root));
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    
    public static int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}
