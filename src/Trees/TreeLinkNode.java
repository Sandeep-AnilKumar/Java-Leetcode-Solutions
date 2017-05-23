package Trees;

public class TreeLinkNode {
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	int value;

	TreeLinkNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.next = null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		TreeLinkNode cur = this;
		sb.append(cur.value);
		while(cur != null) {
			sb.append(" left -> " + cur.left + " right -> " + cur.right + " next -> " + cur.next);
			cur = cur.next;
		}
		return sb.toString();
	}
}
