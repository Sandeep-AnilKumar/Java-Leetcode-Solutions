package DataStructureImplementation;

import java.util.NoSuchElementException;

/**
 * @author sandeepa
 */

public class SinglyLinkedList<T> {

	private ListNode<T> head;
	private ListNode<T> tail;
	private int count;

	public SinglyLinkedList() {
		head = tail = null;
		count = 0;
	}

	public void insertFirst(T val) {
		if (head == null) {
			head = new ListNode<T>(val);
			tail = head;
		} else {
			ListNode<T> cur = new ListNode<T>(val);
			cur.setNext(head);
			head = cur;
		}

		count++;
		return;
	}

	public void insertLast(T val) {
		if (tail == null) {
			tail = new ListNode<T>(val);
			head = tail;
		} else {
			ListNode<T> cur = new ListNode<T>(val);
			tail.setNext(cur);
			tail = cur;
		}

		count++;
		return;
	}

	public void insert(int index, T val) {
		if (index < 0 || index > count) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		if (index == 0) {
			insertFirst(val);
			return;
		} else if (index == count){
			insertLast(val);
			return;
		}

		int curIndex = 0;
		ListNode<T> cur = head;
		ListNode<T> prev = null;

		while(curIndex < index && cur != null) {
			curIndex++;
			prev = cur;
			cur = cur.getNext();
		}

		ListNode<T> node = new ListNode<T>(val);
		prev.setNext(node);
		node.setNext(cur);
		count++;
		return;
	}

	//removes the object
	public void remove(T val) {
		if(count == 0 || head == null || tail == null) {
			throw new NoSuchElementException("" + val);
		}

		if(head.getVal() == val) {
			head = head.getNext();

			if(count == 1) {
				tail = null;
			}

			count--;
			return;
		}

		ListNode<T> cur = head;
		ListNode<T> prev = null;

		while(cur != null && cur.getVal() != val) {
			prev = cur;
			cur = cur.getNext();
		}

		if(cur == null) {
			throw new NoSuchElementException("" + val);
		}

		if(cur.getVal() == val) {
			prev.setNext(cur.getNext());

			if(cur.getNext() == null) {
				tail = prev;
			}

			count--;
		}

		return;
	}

	//removes by index
	public void remove(int index) {
		if(index < 0 || index >= count) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		if(count == 0 || head == null || tail == null) {
			throw new NoSuchElementException("Linked list is empty, nothing to remove.");
		}

		if(index == 0) {
			head = head.getNext();

			if(count == 1) {
				tail = null;
			}

			count--;
			return;
		}

		int curIndex = 0;
		ListNode<T> cur = head;
		ListNode<T> prev = null;

		while(curIndex < index && cur != null) {
			curIndex++;
			prev = cur;
			cur = cur.getNext();
		}

		if(index == count) {
			prev.setNext(null);
			tail = prev;
		} else {
			prev.setNext(cur.getNext());
		}

		count--;
		return;
	}

	public int size() {
		return count;
	}

	public String print() {
		if(count == 0) {
			return "[]";
		}

		StringBuffer sb = new StringBuffer();
		ListNode<T> cur = head;

		if(cur != null) {
			sb.append(cur);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		list.insert(0, 1);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		list.insertLast(2);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		list.remove(1);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		/*list.remove((int) 1); //Tries to remove the node at index 1
		System.out.println("Size := " + list.size());
		System.out.println(list.print());*/

		list.remove((Integer) 1); //Removes the node with value = 1
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		// list.remove(0); // Array Index Out of Bounds

		// list.remove((Integer) 5); // No such element

		list.insertLast(2);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		list.insertLast(3);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		list.insertFirst(1);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		list.remove(1);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		list.remove((Integer) 3);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());

		list.remove(0);
		System.out.println("\nSize := " + list.size());
		System.out.println(list.print());
	}
}