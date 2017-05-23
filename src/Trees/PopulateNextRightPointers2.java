package Trees;

public class PopulateNextRightPointers2 {

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(-1);
		TreeLinkNode a = new TreeLinkNode(-7);
		TreeLinkNode b = new TreeLinkNode(9);
		TreeLinkNode c = new TreeLinkNode(-1);
		TreeLinkNode d = new TreeLinkNode(-7);
		TreeLinkNode e = new TreeLinkNode(8);
		TreeLinkNode f = new TreeLinkNode(-9);
		//		TreeLinkNode g = new TreeLinkNode(1);
		//		TreeLinkNode h = new TreeLinkNode(6);
		//		TreeLinkNode i = new TreeLinkNode(8);

		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
		c.right = e;
		d.left = f;
		//		b.right = e;
		//		c.left = f;
		//		c.right = g;
		//		d.right = h;
		//		e.right = i;

		System.out.println("The Tree after populating next right pointers is := " + connect(root));
	}

	public static TreeLinkNode connect(TreeLinkNode root) {
		if(root == null) {
			return root;
		}

		TreeLinkNode prev = root;
		TreeLinkNode cur = null;
		TreeLinkNode temp = null;

		while(prev != null) {
			cur = prev;

			while(cur != null) {
				if(cur.left != null) {
					if(cur.right != null) {
						cur.left.next = cur.right;
					} else {
						temp = cur.next;
						while(temp != null) {
							if(temp.left != null || temp.right != null) {
								if(temp.left != null) {
									cur.left.next = temp.left;
								} else {
									cur.left.next = temp.right;
								}
								break;
							}
							temp = temp.next;
						}
					}
				} if(cur.right != null) {
					temp = cur.next;
					while(temp != null) {
						if(temp.left != null || temp.right != null) {
							if(temp.left != null) {
								cur.right.next = temp.left;
							} else {
								cur.right.next = temp.right;
							}
							break;
						}
						temp = temp.next;
					}
				}
				cur = cur.next;
			}
			if(prev.left != null) {
				prev = prev.left;
			} else if (prev.right != null){
				prev = prev.right;
			} else {
				prev = prev.next;
			}
		}
		return root;
	}

	//A much easier solution.

	public static void connectBetter(TreeLinkNode root) {
		TreeLinkNode pre = null, head = null, cur = root;

		while (cur != null) {
			while (cur != null) {
				if (cur.left != null) {
					if (pre == null) {
						pre = cur.left;
						head = pre;
					} else {
						pre.next = cur.left;
						pre = pre.next;
					}
				}
				if (cur.right != null) {
					if (pre == null) {
						pre = cur.right;
						head = pre;
					} else {
						pre.next = cur.right;
						pre = pre.next;
					}
				}
				cur = cur.next;
			}
			cur = head;
			head = null;
			pre = null;            
		}  
	}
}
