package Trees;

public class ClosestBSTValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right= node3;
        node2.left = node4;
        node2.right= node5;
        node3.left = node6;

        System.out.println("Closest BST value is := " + closestValueBetter(root, 6.8));
    }

    public static int closestValue(TreeNode root, double target) {
        if(root == null) {
            return 0;
        }
        return findMin(root, target, root.val);
    }

    public static int findMin(TreeNode node, double target, int value) {
        if(node == null) {
            return value;
        }
        int curMin = value;
        if(node.val < target) {
            if(node.right != null) {
                curMin = (Math.abs(target - value) > Math.abs(target - node.right.val)) ? node.right.val : value;
                return findMin(node.right, target, curMin);
            }
        } else {
            if(node.left != null) {
                curMin = (Math.abs(target - value) > Math.abs(target - node.left.val)) ? node.left.val : value;
                return findMin(node.left, target, curMin);
            }
        }
        return curMin;
    }

    //Better version.
    public static int closestValueBetter(TreeNode root, double target) {
        int closestVal = root.val; 
        while(root != null){ 
            closestVal = (Math.abs(target - root.val) < Math.abs(target - closestVal))? root.val : closestVal;
            root = (root.val > target)? root.left: root.right;
        }
        return closestVal;
    }

    //Much Better
    public static int closestValueBest(TreeNode root, double target) {
        TreeNode kid = root.val < target ? root.right : root.left;
        if(kid == null) {
            return root.val;
        }
        int k = closestValue(kid, target);
        return Math.abs(root.val - target) < Math.abs(k - target) ? root.val : k;
    }
}
