package DataStructureImplementation;

public class DesignLinkedList {

	ListNode head, tail;
	int size = 0;

	/**
	 * Initialize your data structure here.
	 */
	public DesignLinkedList() {
		head = new ListNode(-1);
		tail = new ListNode(-1);
		head.next = tail;
		tail.prev = head;
	}

	public static void main(String[] args) {
		DesignLinkedList linkedList = new DesignLinkedList();
		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		System.out.println(linkedList.get(0));
		System.out.println(linkedList.get(2));
		linkedList.addAtIndex(1, 2);
		System.out.println(linkedList.get(2));
		linkedList.deleteAtIndex(2);
		System.out.println(linkedList.get(1));
		linkedList.deleteAtIndex(0);
		linkedList.deleteAtIndex(0);
		System.out.println(linkedList.get(0));

		linkedList.addAtIndex(1, 2);
		System.out.println(linkedList.get(1));
		System.out.println(linkedList.get(0));
		linkedList.addAtIndex(0, 1);
		System.out.println(linkedList.get(0));
		System.out.println(linkedList.get(1));
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
	 */
	public int get(int index) {
		if (index >= size) return -1;
		int hPtr = 0, tPtr = size - 1;
		ListNode l = head.next, r = tail.prev;

		while (hPtr < index && tPtr > index) {
			l = l.next;
			r = r.prev;
			hPtr++;
			tPtr--;
		}

		if (hPtr == index) return l.val;
		if (tPtr == index) return r.val;
		return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		size++;
		ListNode node = new ListNode(val);
		node.next = head.next;
		node.prev = head;
		node.next.prev = head.next = node;
	}

	/**
	 * Append a node of value val to the last element of the linked list.
	 */
	public void addAtTail(int val) {
		size++;
		ListNode node = new ListNode(val);
		node.prev = tail.prev;
		node.next = tail;
		node.prev.next = tail.prev = node;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index > size) return;

		if (index == size) {
			addAtTail(val);
			return;
		}

		if (index == 0) {
			addAtHead(val);
			return;
		}

		size++;
		int cur = 0;
		ListNode node = new ListNode(val);
		ListNode curNode = head.next;

		while (cur < index) {
			curNode = curNode.next;
			cur++;
		}

		node.next = curNode;
		node.prev = curNode.prev;
		curNode.prev = node.prev.next = node;
	}

	/**
	 * Delete the index-th node in the linked list, if the index is valid.
	 */
	public void deleteAtIndex(int index) {
		if (index >= size) return;
		int cur = 0;
		size--;

		ListNode curNode = head.next;

		while (cur < index) {
			curNode = curNode.next;
			cur++;
		}

		curNode.prev.next = curNode.next;
		curNode.next.prev = curNode.prev;
	}

	class ListNode {
		int val;
		ListNode next, prev;

		public ListNode(int val) {
			this.val = val;
		}
	}
}
