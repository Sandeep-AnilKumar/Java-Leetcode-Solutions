package Arrays;

public class RemoveDuplicatesUnsortedList {

	public static void main(String[] args) {
		MyNode node = new MyNode(2);
		MyNode b = new MyNode(2);
		MyNode c = new MyNode(2);
		MyNode d = new MyNode(2);
		MyNode e = new MyNode(2);
		MyNode f = new MyNode(2);
		MyNode g = new MyNode(2);
		MyNode h = new MyNode(2);
		MyNode i = new MyNode(2);
		MyNode j = new MyNode(2);
		MyNode k = new MyNode(2);

		node.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;
		j.next = k;

		System.out.println("The unduplicated list is := " + removeDuplicates(node).toString());

	}

	public static MyNode removeDuplicates(MyNode node) {
		if(node == null || node.next == null) {
			return node;
		}

		boolean[] present = new boolean[10000];
		MyNode head = new MyNode(0);
		MyNode prev = head;
		head.next = node;
		MyNode cur = head.next;

		while(cur != null) {
			if(!present[cur.val]) {
				present[cur.val] = true;
				prev.next = cur;
				prev = prev.next;
			}
			cur = cur.next;
		}

		prev.next = cur;
		return head.next;
	}
}
