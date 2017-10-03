package Arrays;

import java.util.NoSuchElementException;
import java.util.Scanner;

class Hashmap<K,V> {

	static class MapNode<K, V> {
		private K key;
		private V value;
		private MapNode<K,V> next;

		public MapNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public MapNode<K, V> getNext() {
			return this.next;
		}

		public void setNext(MapNode<K, V> next) {
			this.next = next;
		}
	}

	private int size;
	private MapNode<K,V>[] bucket;

	public Hashmap(int capacity) {
		this.bucket = new MapNode[nextPrime(capacity)];
		this.size = 0;
	}

	public void put(K key, V value) {
		int hashKey = getHashCode(key);
		MapNode<K, V> cur = new MapNode<K, V>(key, value);

		if(bucket[hashKey] == null) {
			bucket[hashKey] = cur;
		} else {
			cur.setNext(bucket[hashKey]);
			bucket[hashKey] = cur;
		}
		size++;
		return;
	}

	public V get(K key) {
		int hashKey = getHashCode(key);
		if(bucket[hashKey] == null) {
			throw new NoSuchElementException();
		}

		MapNode<K, V> start = bucket[hashKey];
		MapNode<K, V> end = start;

		if(start.getKey().equals(key)) return start.getValue();

		while(end.getNext() != null && !end.getNext().getKey().equals(key)) {
			end = end.getNext();
		}

		if(end.getNext() != null && end.getNext().getKey().equals(key)) {
			return end.getNext().getValue();
		}
		throw new NoSuchElementException();
	}

	public int nextPrime(int num) {
		if(num % 2 == 0) return num + 1;

		for(; !isPrime(num); num +=2);

		return num;
	}

	public boolean isPrime(int num) {
		if(num == 2 || num == 3) return true;
		if(num == 1 || num % 2 == 0) return false;

		for(int i = 3; i * i <= num; ++i) {
			if(num % i == 0) return false;
		}
		return true;
	}

	public int getHashCode(K key) {
		int hashValue = key.hashCode();
		hashValue %= bucket.length;

		if(hashValue < 0) {
			hashValue += bucket.length;
		}
		return hashValue;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		int length = bucket.length;
		bucket = new MapNode[length];
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public void print() {
		MapNode<K, V> cur = null;
		MapNode<K, V> next = null;
		for(int i = 0; i < bucket.length; ++i) {
			cur = bucket[i];
			next = cur;
			System.out.println("=====================================================");
			System.out.println("Bucket " + i);

			while(next != null) {
				System.out.println(next.getKey() + ", " + next.getValue());
				next = next.getNext();
			}
			System.out.println("=====================================================");
		}
	}
}

public class MapImpl {
	public static void main(String[] args) {
		Hashmap<Integer, Integer> hashMap = new Hashmap<>(5);
		Scanner in = new Scanner(System.in);
		int  choice = 0;
		int key = 0;
		int value = 0;
		do {

			System.out.println("What would you like to do?");
			System.out.println("1. Insert a new hashmap entry?");
			System.out.println("2. Retrieve a value by its key?");
			System.out.println("3. Check if hashmap is empty?");
			System.out.println("4. Clear the hashmap?");
			System.out.println("5. Print hashmap?");
			System.out.println("6. Exit?");

			choice = in.nextInt();

			switch(choice) {
			case 1: 
				System.out.println("Enter the key followed by the value");
				key = in.nextInt();
				value = in.nextInt();
				hashMap.put(key, value);
				break;

			case 2:
				System.out.println("Enter the key you want to retrieve.");
				key = in.nextInt();
				System.out.println(hashMap.get(key));
				break;

			case 3:
				System.out.println("Is hashmap empty? := " + hashMap.isEmpty());
				break;

			case 4:
				hashMap.clear();
				System.out.println("HashMap is cleared, current size is := " + hashMap.size());
				break;

			case 5:
				hashMap.print();
				break;

			case 6:
				break;
			}

		} while(choice != 6);
		in.close();
	}
}
