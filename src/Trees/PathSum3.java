package Trees;

public class PathSum3 {

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

        System.out.println("Total paths : " + pathSum(root, 13));

    }


    public static int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        return pathSum(root, sum, 0, sum, count);
    }

    public static int pathSum(TreeNode root, int sum, int presentSum, int totalSum, int count) {
        if(root == null) {
            return count;
        }

        if(sum == root.val || presentSum + root.val == totalSum) {
            count++;
            return count;
        }

        int result = count;
        result += pathSum(root.left, sum - root.val, root.val, totalSum, count);
        result += pathSum(root.right, sum - root.val, root.val, totalSum, count);
        return result;
    }
}
