package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class SerializeTree {

	public static void main(String[] args) {
		SerializeTree codec = new SerializeTree();
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(2);


		root.left = n1;
		root.right = n2;
		n1.right = n3;

		String serialized = codec.serialize(root);
		System.out.println("Serialized string is := " + serialized);

		TreeNode deserialized = codec.deserialize(serialized);
		System.out.println("Deserialized tree is := " + deserialized);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) return "";

		StringBuilder serialized = new StringBuilder();
		serialize(root, serialized);
		return serialized.toString();
	}

	public void serialize(TreeNode node, StringBuilder serialized) {
		if(node == null) return;

		Deque<TreeNode> dq = new ArrayDeque<>();
		serialized.append(node.val + "#");
		dq.offer(node);
		TreeNode cur = null;

		while(!dq.isEmpty()) {
			cur = dq.poll();

			if(cur.left != null) {
				serialized.append(cur.left.val + "#");
			} else {
				serialized.append("Null#");
			}

			if(cur.right != null) {
				serialized.append(cur.right.val + "#");
			} else {
				serialized.append("Null#");
			}

			if(cur.left != null) {
				dq.offer(cur.left);
			}

			if(cur.right != null) {
				dq.offer(cur.right);
			}
		}

		return;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data == null || data.length() == 0) {
			return null;
		}

		String[] parts = data.split("#");
		TreeNode[] nodes = new TreeNode[parts.length];
		int prev = parts.length - 1;
		int numIndex = 0;
		for(int i = parts.length - 1; i >= 1; i -= 2) {
			for(numIndex = prev; numIndex >= 0; numIndex--) {
				if(!parts[numIndex].equals("Null")) {
					break;
				}
			}

			prev = numIndex - 1;
			nodes[numIndex] = new TreeNode(Integer.parseInt(parts[numIndex]));
			if(!parts[i].equals("Null")) {
				if(nodes[i] == null) {
					nodes[numIndex].right = new TreeNode(Integer.parseInt(parts[i]));
				} else {
					nodes[numIndex].right = nodes[i];
				}
			}
			if(!parts[i - 1].equals("Null")) {
				if(nodes[i - 1] == null) {
					nodes[numIndex].left = new TreeNode(Integer.parseInt(parts[i - 1]));
				} else {
					nodes[numIndex].left = nodes[i - 1];
				}
			}
		}
		return nodes[0];
	}
}
