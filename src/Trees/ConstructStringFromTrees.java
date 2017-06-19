package Trees;

public class ConstructStringFromTrees {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(6);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(10);

		root.right = b;
		b.right = c;
		c.right = d;
		d.right = e;
		e.left = f;

		ConstructStringFromTrees csft = new ConstructStringFromTrees();
		System.out.println("The string conversion of the tree is := " + csft.tree2str(root));
	}

	public String tree2str(TreeNode t) {
		if(t == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		generateString(t, sb);
		return sb.toString();
	}

	public void generateString(TreeNode node, StringBuffer sb) {
		if(node.left == null && node.right == null) {
			sb.append(node.val);
			return;
		}

		sb.append(node.val);
		if(node.left == null) {
			sb.append("()");
		} else {
			sb.append("(");
			generateString(node.left, sb);
			sb.append(")");
		}

		if(node.right != null) {
			sb.append("(");
			generateString(node.right, sb);
			sb.append(")");
		}
		return;
	}
}
