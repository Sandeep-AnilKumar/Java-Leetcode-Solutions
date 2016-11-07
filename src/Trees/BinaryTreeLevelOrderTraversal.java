package Trees;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        //TreeNode node6 = new TreeNode(6);
        //TreeNode node7 = new TreeNode(10);
        TreeNode node8 = new TreeNode(0);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = null;
        node4.left = node8;

        List<List<Integer>> result = levelOrderTraversal(root);

        for(List<Integer> node : result) {
            System.out.println(node.toString());
        }
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }

        Deque<TreeNode> st = new ArrayDeque<TreeNode>();
        st.offerLast(root);

        TreeNode cur = null;
        List<Integer> subPath = new ArrayList<Integer>();
        int size = 0;

        while(!st.isEmpty()) {
            subPath = new ArrayList<Integer>();
            size = st.size();

            while(size-- > 0) {
                cur = st.pollFirst();
                subPath.add(cur.val);

                if(cur.left != null) {
                    st.offerLast(cur.left);
                }

                if(cur.right != null) {
                    st.offerLast(cur.right);
                }
            }
            result.add(subPath);
        }
        return result;
    }
}
