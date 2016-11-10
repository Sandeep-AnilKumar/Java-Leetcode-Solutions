package Trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SerializeBST {
    String serializeTree = "";
    TreeNode deserializeTree = null;

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

        SerializeBST codec = new SerializeBST();
        String s = codec.serialize(root);
        System.out.println("Serialized Tree is := " + s);
        TreeNode ds = codec.deserialize(s);
        System.out.println("Deserialized Tree is := " + ds);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            serializeTree = "";
            return "";
        }
        serializeTree = serialTree(root, new StringBuilder());
        return serializeTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        deserializeTree = deserializeString(serializeTree);
        return deserializeTree;
    }

    public String serialTree(TreeNode root, StringBuilder sb) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int size = 0;
        TreeNode cur = null;
        while(!queue.isEmpty()) {
            size = queue.size();
            while(size-- > 0) {
                cur = queue.pollFirst();
                sb.append(cur == null ? "null+" : cur.val + "+");
                if(cur != null) {
                    if(cur.left != null) {
                        queue.offerLast(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offerLast(cur.right);
                    }
                }
            }
        }
        return sb.toString();
    }

    public TreeNode deserializeString(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        
        String[] nodes = s.split("\\+");
        if(nodes == null || nodes.length == 0) {
            return null;
        }
        int length = nodes.length;
        TreeNode[] tNodes = new TreeNode[length];
        int index = 0;
        for(String n : nodes) {
            tNodes[index++] = new TreeNode(n.equals("null") || n == null || n.length() == 0 ? -1 : Integer.parseInt(n));
        }
        TreeNode parent = null;
        int child = 0;
        for(int i = 1; i < length; ++i) {
            int j = (i-1)/2;
            parent = tNodes[j]; 
            child = 2*j + 1;
            if(tNodes[child].val != -1) {
                parent.left = tNodes[child];
            } else {
                parent.left = null;
            }
            child = 2*j + 2;
            if(tNodes[child].val != -1) {
                parent.right = tNodes[child];
            } else {
                parent.right = null;
            }
        }
        return tNodes[0];
    }
}
