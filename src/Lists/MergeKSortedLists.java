package Lists;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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

	//A second brute-force easier possible solution

	public ListNode mergeKListsBetter(ListNode[] lists) {
		int k = lists.length;
		int[] count = new int[1000001];
		ListNode cur = null;

		for(int i = 0; i < k; ++i) {
			cur = lists[i];

			while(cur != null) {
				count[cur.val + 500000]++;
				cur = cur.next;
			}
		}

		ListNode merged = new ListNode(0);
		ListNode head = merged;

		for(int i = 0; i < count.length; ++i) {
			while(count[i]-- > 0) {
				head.next = new ListNode(i - 500000);
				head = head.next;
			}
		}
		return merged.next;
	}

	//O(n log k) solution using priority queue. Where n is the total number of nodes in the merged list, and k is the number of lists.

	public ListNode mergeKListsMuchBetter(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;

		PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(new Comparator<ListNode>(){
			public int compare(ListNode o1,ListNode o2){
				return o1.val - o2.val;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail=dummy;

		for (ListNode node:lists)
			if (node!=null)
				queue.add(node);

		while (!queue.isEmpty()){
			tail.next=queue.poll();
			tail=tail.next;

			if (tail.next != null)
				queue.add(tail.next);
		}
		return dummy.next;
	}

	//O(kN). So far the best solution.

	public ListNode mergeKListsBest(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;

		int k = lists.length;
		Set<Integer> active = new HashSet<>();

		for(int i = 0; i < k; ++i) active.add(i);

		ListNode merged = new ListNode(0);
		ListNode head = merged;
		int curMin = Integer.MAX_VALUE;
		int curIndex = 0;
		boolean found = false;

		while(!active.isEmpty()) {
			curMin = Integer.MAX_VALUE;
			curIndex = 0;
			found = false;

			for(int i = 0; i < k; ++i) {
				if(lists[i] != null && lists[i].val < curMin) {
					curIndex = i;
					curMin = lists[i].val;
					found = true;
				} else if(lists[i] == null) active.remove(i);
			}

			if(found) {
				head.next = new ListNode(curMin);
				head = head.next;

				if(lists[curIndex] == null || lists[curIndex].next == null) active.remove(curIndex);
				if(lists[curIndex] != null) lists[curIndex] = lists[curIndex].next;
			}
		}
		return merged.next;
	}
}