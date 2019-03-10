package DataStructureImplementation;

public class DesignHashSet {

	private Node[] set;

	/**
	 * Initialize your data structure here.
	 */
	public DesignHashSet() {
		set = new Node[10000];
	}

	public static void main(String[] args) {
		DesignHashSet hashSet = new DesignHashSet();
		hashSet.add(9999);
		System.out.println(hashSet.contains(-1));
	}

	public void add(int key) {
		int index = getIndex(key);
		Node node = set[index];
		if (node == null) {
			set[index] = new Node(-1);
			node = set[index];
		}
		Node cur = new Node(key);

		while (node.next != null) {
			if (node.next.key == key) {
				return;
			}
			node = node.next;
		}

		node.next = cur;
	}

	public boolean contains(int key) {
		int index = getIndex(key);
		Node node = set[index];

		node = node.next;
		while (node != null) {
			if (node.key == key) return true;
			node = node.next;
		}

		return false;
	}

	public void remove(int key) {
		int index = getIndex(key);
		Node node = set[index];
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
		int index = Integer.hashCode(key) % set.length;
		if (index < 0) {
			index = index + set.length;
			index %= set.length;
		}
		return index;
	}

	class Node {
		int key;
		Node next;

		public Node(int key) {
			this.key = key;
		}
	}
}
