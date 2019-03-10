package DataStructureImplementation;

public class DesignHashMap {

	private Node[] map;

	/**
	 * Initialize your data structure here.
	 */
	public DesignHashMap() {
		map = new Node[10000];
	}

	public static void main(String[] args) {
		DesignHashMap hashMap = new DesignHashMap();
		hashMap.put(1, 1);
		System.out.println(hashMap.get(1));
		hashMap.put(2, 2);
		System.out.println(hashMap.get(2));
		hashMap.put(2, 1);
		System.out.println(hashMap.get(2));
		System.out.println(hashMap.get(3));
		hashMap.remove(2);
		System.out.println(hashMap.get(2));
		System.out.println(hashMap.get(1));
	}

	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value) {
		int index = getIndex(key);
		Node node = map[index];
		if (node == null) {
			map[index] = new Node(-1, -1);
			node = map[index];
		}
		Node cur = new Node(key, value);

		while (node.next != null) {
			if (node.next.key == key) {
				node.next.value = value;
				return;
			}
			node = node.next;
		}

		node.next = cur;
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key) {
		int index = getIndex(key);
		Node node = map[index];

		while (node != null) {
			if (node.key == key) return node.value;
			node = node.next;
		}

		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
	public void remove(int key) {
		int index = getIndex(key);
		Node node = map[index];
		if (node == null) return;

		while (node.next != null) {
			if (node.next.key == key) {
				node.next = node.next.next;
				return;
			}
			node = node.next;
		}
	}

	private int getIndex(int key) {
		return Integer.hashCode(key) % map.length;
	}

	class Node {
		int key, value;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
