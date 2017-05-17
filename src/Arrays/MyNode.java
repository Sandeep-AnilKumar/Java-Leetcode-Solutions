package Arrays;

class MyNode {
	int val;
	MyNode next;

	MyNode() {
		val= 1;
	}

	MyNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		MyNode node = this;
		if(node != null) {
			while(node != null) {
				sb.append(node.val + " -> ");
				node = node.next;
			}
			sb.append("null");
		}
		return sb.toString();
	}
}
