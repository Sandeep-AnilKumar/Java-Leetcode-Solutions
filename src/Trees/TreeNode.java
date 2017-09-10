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
		sb.append(this.val);
		if(this.left != null) {
			sb.append(", left = " + this.left);
		}

		if(this.right != null) {
			sb.append(", right = " + this.right);
		}
		
		return sb.toString();
	}
}