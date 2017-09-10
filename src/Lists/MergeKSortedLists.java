package Lists;

public class MergeKSortedLists {

	public static void main(String[] args) {
		MergeKSortedLists merge = new MergeKSortedLists();
		ListNode[] lists = new ListNode[2];

		ListNode first = new ListNode(5);
		ListNode head = first;

		first.next = new ListNode(7);
		first = first.next;

		first.next = new ListNode(22);
		first = first.next;

		first.next = new ListNode(41);
		first = first.next;
		lists[0] = head;

		ListNode second = new ListNode(1);
		head = second;

		second.next = new ListNode(6);
		second = second.next;

		second.next = new ListNode(7);
		second = second.next;

		second.next = new ListNode(8);
		second = second.next;

		second.next = new ListNode(42);
		second = second.next;

		second.next = new ListNode(55);
		second = second.next;

		lists[1] = head;

		System.out.println("The merged list is := " + merge.mergeKLists(lists));
	}

	//Will be TLE for very large amount of ListNodes having single node.
	
	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		ListNode merged = null;

		for(int i = 0; i < k; ++i) {
			merged = merge2Lists(merged, lists[i]);
		}
		return merged;
	}

	public ListNode merge2Lists(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;

		ListNode merged = new ListNode(0);
		ListNode cur = merged;
		ListNode first = list1;
		ListNode second = list2;

		while(first != null && second != null) {
			if(first.val < second.val) {
				cur.next = first;
				first = first.next;
			}
			else if(second.val < first.val) {
				cur.next = second;
				second = second.next;
			} else {
				cur.next = first;
				first = first.next;
				cur = cur.next;

				cur.next = second;
				second = second.next;
			}
			cur = cur.next;
		}

		if(first != null && second == null) {
			cur.next = first;
		} else if(first == null && second != null) {
			cur.next = second;
		}
		return merged.next;
	}
}