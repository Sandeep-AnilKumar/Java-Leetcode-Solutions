package Trees;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) {
		val = x;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.val + ", left -> " + this.left + ", right -> " + this.right);
		return sb.toString();
	}
}