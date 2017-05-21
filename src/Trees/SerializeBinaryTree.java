package Trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
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

	//An iterative solution. But much complicated.
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) {
			return null;
		}

		Deque<TreeNode> queue = new ArrayDeque<>();
		Deque<String> codec = new ArrayDeque<>();
		queue.offerLast(root);
		codec.offerLast(String.valueOf(root.val) + ",");
		TreeNode cur = null;

		while(!queue.isEmpty()) {
			cur = queue.pollFirst();
			if(cur.left != null) {
				codec.offerLast(String.valueOf(cur.left.val) + ",");
				queue.offerLast(cur.left);
			} else {
				codec.offerLast("n,");
			}

			if(cur.right != null) {
				codec.offerLast(String.valueOf(cur.right.val) + ",");
				queue.offerLast(cur.right);
			} else {
				codec.offerLast("n,");
			}
		}

		StringBuffer sb = new StringBuffer();
		while(!codec.isEmpty()) {
			sb.append(codec.pollFirst());
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data == null || data.length() == 0) {
			return null;
		}

		String[] chars = data.split(",");
		TreeNode[] nodes = new TreeNode[chars.length];
		int prev = chars.length - 1;
		int numIndex = 0;
		for(int i = chars.length - 1; i >= 1; i -= 2) {
			for(numIndex = prev; numIndex >= 0; numIndex--) {
				if(!chars[numIndex].equals("n")) {
					break;
				}
			}

			prev = numIndex - 1;
			nodes[numIndex] = new TreeNode(Integer.parseInt(String.valueOf(chars[numIndex])));
			if(!chars[i].equals("n")) {
				if(nodes[i] == null) {
					nodes[numIndex].right = new TreeNode(Integer.parseInt(String.valueOf(chars[i])));
				} else {
					nodes[numIndex].right = nodes[i];
				}
			}
			if(!chars[i - 1].equals("n")) {
				if(nodes[i - 1] == null) {
					nodes[numIndex].left = new TreeNode(Integer.parseInt(String.valueOf(chars[i - 1])));
				} else {
					nodes[numIndex].left = nodes[i - 1];
				}
			}
		}
		return nodes[0];
	}

	//A much easier solution.

	// Encodes a tree to a single string.
	public String serializeBetter(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		ser(root, sb);

		return sb.substring(1);
	}

	void ser(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append(",#");
		} else {
			sb.append(",");
			sb.append(node.val);
			ser(node.left, sb);
			ser(node.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserializeBetter(String data) {
		String[] strs = data.split(",");
		Queue<String> q = new LinkedList<>(Arrays.asList(strs));
		return deser(q);
	}

	TreeNode deser(Queue<String> q) {
		String peek = q.poll();
		if (peek.equals("#"))
			return null;
		TreeNode node = new TreeNode(Integer.valueOf(peek));
		node.left = deser(q);
		node.right = deser(q);
		return node;
	}
}
