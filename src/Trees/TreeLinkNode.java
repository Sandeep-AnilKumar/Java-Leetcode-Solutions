package Trees;

public class TreeLinkNode {
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	int val;

	TreeLinkNode(int value) {
		this.val = value;
		this.left = null;
		this.right = null;
		this.next = null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		TreeLinkNode cur = this;
		sb.append(cur.val);
		while(cur.next != null) {
			sb.append(" next -> " + cur.next.val);
			cur = cur.next;
		}
		return sb.toString();
	}
}
