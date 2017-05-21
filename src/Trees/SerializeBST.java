package Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {

	String serializeTree = "";
	TreeNode deserializeTree = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		TreeNode g = new TreeNode(8);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;
		e.left = f;
		f.right = g;

		SerializeBST codec = new SerializeBST();
		String s = codec.serialize(root);
		System.out.println("Serialized Tree is := " + s);
		TreeNode ds = codec.deserialize(s);
		System.out.println("Deserialized Tree is := " + ds);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) {
			return null;
		}  
		StringBuffer sb = new StringBuffer();
		serialize(root, sb);
		return sb.toString().substring(1);
	}

	public void serialize(TreeNode node, StringBuffer sb) {
		if(node == null) {
			sb.append(",#");
			return;
		}

		sb.append("," + node.val);
		serialize(node.left, sb);
		serialize(node.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data == null || data.length() == 0) {
			return null;
		}

		String[] nodes = data.split(",");
		Queue<String> queue = new LinkedList(Arrays.asList(nodes));
		TreeNode root = null;
		return deserialize(root, queue);
	}

	public TreeNode deserialize(TreeNode node, Queue<String> queue) {
		if(!queue.isEmpty()) {
			String peek = queue.poll();
			if(peek.equals("#")) {
				return null;
			}

			node = new TreeNode(Integer.parseInt(peek));
			node.left = deserialize(node, queue);
			node.right = deserialize(node, queue);
		}
		return node;
	}
}
