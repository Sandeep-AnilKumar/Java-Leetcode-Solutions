package Arrays;

import java.util.Scanner;

class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	public SinglyLinkedListNode(int val) {
		this.data = val;
		this.next = null;
	}
}

class HashTableImplementation {
	int size;
	SinglyLinkedListNode[] table;

	public HashTableImplementation(int intialcapacity) {
		this.table = new SinglyLinkedListNode[nextPrime(intialcapacity)];
		this.size = 0;
	}

	public int nextPrime(int value) {
		if(value % 2 == 0) {
			return value ++;
		}

		for(; !isPrime(value); value += 2) {}

		return value;
	}

	public boolean isPrime(int value) {
		if(value == 2 || value == 3) {
			return true;
		}

		if(value == 1 || value % 2 == 0) {
			return false;
		}

		for(int i = 3; i * i <= value; i += 2) {
			if(value % i == 0) {
				return false;
			}
		}
		return true;
	}


	public void insert(int value) {
		int hashCode = getHashCode(value);
		SinglyLinkedListNode cur = new SinglyLinkedListNode(value);
		size++;
		if(table[hashCode] == null) {
			table[hashCode] = cur;
		}
		else {
			cur.next = table[hashCode];
			table[hashCode] = cur;
		}
	}

	public void remove(int value) {
		int hashCode = getHashCode(value);
		SinglyLinkedListNode start = table[hashCode];
		SinglyLinkedListNode end = start;

		if(start.data == value) {
			size--;
			table[hashCode] = start.next;
			return;
		}

		while(end.next != null && end.next.data != value) {
			end = end.next;
		}

		if(end.next == null) {
			System.out.println("Element not found\n");
			return;
		}

		size--;
		if(end.next.next == null) {
			end.next = null;
			return;
		}
		end.next = end.next.next;
		table[hashCode] = start;
	}

	public int getHashCode(Integer value) {
		int val = value.hashCode();
		val %= table.length;

		if(val < 0) {
			return val += table.length;
		}
		return val;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		int length = table.length;
		table = new SinglyLinkedListNode[length];
		return;
	}

	public void printHashTable() {
		int length = table.length;
		for(int i = 0; i < length; ++i) {
			System.out.print("Bucket " + i + ": ");
			SinglyLinkedListNode start = table[i];
			while(start != null) {
				System.out.print(start.data + " ");
				start = start.next;
			}
			System.out.println();
		}
	}
}

public class HashTableImplementationTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("HashTable Implementation");
		System.out.println("Enter the capacity of the hash table");
		int capacity = in.nextInt();
		HashTableImplementation ht = new HashTableImplementation(capacity);

		char ch;

		do {
			System.out.println("Hashtable operations: -");
			System.out.println("1. Insert");
			System.out.println("2. Remove");
			System.out.println("3. Clear");
			System.out.println("4. Is Empty?");
			System.out.println("5. Size");

			System.out.println("Enter your choice: -");

			int choice = in.nextInt();

			switch(choice) {
			case 1: 
				System.out.println("Enter the integer to insert");
				ht.insert(in.nextInt());
				break;
			case 2: 
				System.out.println("Enter the integer to remove");
				ht.remove(in.nextInt());
				break;
			case 3: 
				System.out.println("Clearing hashtable. . .");
				ht.clear();
				break;
			case 4: 
				System.out.println("Is hashtable empty? " + ht.isEmpty());
				break;
			case 5: 
				System.out.println("The size of the hashTable is: - " + ht.size);
				break;
			default: 
				System.out.println("Wrong choice");
				break;
			}

			ht.printHashTable();

			System.out.println("Do you want to continue?");
			ch = in.next().charAt(0);
		}while (ch == 'Y' || ch == 'y');
		in.close();
	}
}
