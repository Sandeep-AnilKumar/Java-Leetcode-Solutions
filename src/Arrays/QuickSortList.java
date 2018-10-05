package Arrays;

public class QuickSortList {

	//All the nodes having value less than the target will be on the start of the all the nodes having values greater than the target.
	public static void main(String[] args) {
		MyNode node = new MyNode(12);
		MyNode a = new MyNode(1);
		MyNode b = new MyNode(2);
		MyNode c = new MyNode(10);
		MyNode d = new MyNode(22);
		MyNode e = new MyNode(4);
		MyNode f = new MyNode(8);
		MyNode g = new MyNode(22);
		MyNode h = new MyNode(-1);
		MyNode i = new MyNode(5);
		MyNode j = new MyNode(32);
		MyNode k = new MyNode(2);
		MyNode l = new MyNode(7);

		node.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;
		j.next = k;
		k.next = l;

		System.out.println("The quciksorted once listnodes are := " + quickSortOnce(node, 7));
	}

	public static MyNode quickSortOnce(MyNode node, int target) {
		if(node == null || node.next == null) {
			return node;
		}

		MyNode before = new MyNode(0);
		MyNode bCur = before;
		MyNode after = new MyNode(0);
		MyNode aCur = after;

		MyNode cur = node;

		while(cur != null) {
			if(cur.val < target) {
				bCur.next = cur;
				bCur = bCur.next;
			} else {
				aCur.next = cur;
				aCur = aCur.next;
			}
			cur = cur.next;
		}

		bCur.next = after.next;
		return before.next;
	}
}
