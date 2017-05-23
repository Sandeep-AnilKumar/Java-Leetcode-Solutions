package Trees;

public class PopulateNextRightPointers {

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode a = new TreeLinkNode(2);
		TreeLinkNode b = new TreeLinkNode(3);
		TreeLinkNode c = new TreeLinkNode(4);
		TreeLinkNode d = new TreeLinkNode(5);
		TreeLinkNode e = new TreeLinkNode(6);
		TreeLinkNode f = new TreeLinkNode(7);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;

		System.out.println("The Tree after populating next right pointers is := " + connect(root));
	}

	public static TreeLinkNode connect(TreeLinkNode root) {
		if(root == null) {
			return root;
		}

		TreeLinkNode prev = root;
		TreeLinkNode cur = null;

		while(prev != null) {
			cur = prev;
			while(cur != null) {
				if(cur.left != null) {
					cur.left.next = cur.right;
					if(cur.next != null) {
						cur.right.next = cur.next.left;
					}
				}
				cur = cur.next;
			}
			prev = prev.left;
		}
		return root;
	}
}
