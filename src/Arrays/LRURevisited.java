package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LRURevisited {

	class ListNode {
		int key;
		ListNode prev;
		ListNode next;

		public ListNode(int key) {
			this.key = key;
		}
	}

	int capacity;
	Map<Integer, Integer> map;
	ListNode head;
	ListNode cur;
	int size;

	public LRURevisited(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		size = 0;
	}

	public void writeData(int key, int value) {
		if(!map.containsKey(key)) {
			map.put(key, value);

			if(size == 0) {
				head = new ListNode(key);
				cur = head;
				size++;
				return;
			}

			if(size == capacity) {
				head = head.next;
				head.prev = null;
				size--;
			}

			cur.next = new ListNode(key);
			cur.next.prev = cur;
			cur = cur.next;
			size++;
			return;
		}
	}

	public int readData(int key) {
		if(size == 0) {
			return -1;
		}

		ListNode check = head;
		while(check != null && check.key != key) {
			check = check.next;
		}

		if(check == null) {
			return -1;
		}

		if(check == cur) {
			return map.get(key);
		}

		if(check.prev != null && check.next != null) {
			check.next.prev = check.prev;
			check.prev.next = check.next;
		} else if(check.next != null) {
			check.next.prev = null;
			head = head.next;
		}

		cur.next = new ListNode(check.key);
		check.prev = cur;
		cur = cur.next;
		return map.get(key);
	}

	public static void main(String[] args) {
		LRURevisited lru = new LRURevisited(2);
		System.out.println(lru.readData(1));
		lru.writeData(1, 3);
		System.out.println(lru.readData(1));
		lru.writeData(2, 4);
		System.out.println(lru.readData(2));
		System.out.println(lru.readData(1));
		System.out.println(lru.readData(1));
		System.out.println(lru.readData(1));
		System.out.println(lru.readData(1));
		System.out.println(lru.readData(2));
		lru.writeData(3, 5);
		System.out.println(lru.readData(1));
		System.out.println(lru.readData(2));
		System.out.println(lru.readData(3));
	}
}
