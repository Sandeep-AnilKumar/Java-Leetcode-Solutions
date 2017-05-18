package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class DogsAndCats {

	Deque<Animal> stock;

	public class Animal {
		String type;
		String name;
		Animal(String type, String name) {
			this.type = type;
			this.name = name;
		}

		public String getType() {
			return this.type;
		}

		public String getName() {
			return this.name;
		}
	}

	DogsAndCats() {
		stock = new ArrayDeque<>();
	}

	public void enqueue(String type, String name) {
		stock.offerLast(new Animal(type, name));
	}

	public Animal dequeueAny() throws Exception {
		if(!stock.isEmpty()) {
			return stock.pollFirst();
		}
		throw new Exception("Trying to poll an empty queue");
	}

	public Animal dequeueDog() throws Exception {
		Animal dog = null;
		Deque<Animal> temp = new ArrayDeque<>();
		while(!stock.isEmpty() && !stock.peekFirst().getType().equals("Dog")) {
			temp.offerFirst(stock.pollFirst());
		}
		if(stock.isEmpty()) {
			throw new Exception("No dog available");
		}
		dog = stock.pollFirst();
		while(!temp.isEmpty()) {
			stock.offerFirst(temp.pollFirst());
		}
		return dog;
	}

	public Animal dequeueCat() throws Exception {
		Animal dog = null;
		Deque<Animal> temp = new ArrayDeque<>();
		while(!stock.isEmpty() && !stock.peekFirst().getType().equals("Cat")) {
			temp.offerFirst(stock.pollFirst());
		}
		if(stock.isEmpty()) {
			throw new Exception("No cat available");
		}
		dog = stock.pollFirst();
		while(!temp.isEmpty()) {
			stock.offerFirst(temp.pollFirst());
		}
		return dog;
	}


	public static void main(String[] args) throws Exception {
		DogsAndCats dc = new DogsAndCats();
		dc.enqueue("Dog", "bat");
		dc.enqueue("Cat", "spidey");
		dc.enqueue("Dog", "super");
		Animal cur = dc.dequeueAny();
		System.out.print("The Animal available is named := '" + cur.getName() +  "' of type " + cur.getType());
		dc.enqueue("Dog", "robin");
		dc.enqueue("Dog", "wolfie");
		dc.enqueue("Cat", "iron");
		cur = dc.dequeueAny();
		System.out.print("\nThe Animal available is named := '" + cur.getName() +  "' of type " + cur.getType());
		dc.enqueue("Cat", "thunder");
		cur = dc.dequeueCat();
		System.out.print("\nThe Cat available is := named '" + cur.getName() + "'");
		dc.enqueue("Dog", "rascal");
		cur = dc.dequeueDog();
		System.out.print("\nThe Dog available is named := '" + cur.getName() + "'");
		cur = dc.dequeueDog();
		System.out.print("\nThe Dog available is named := '" + cur.getName() + "'");
		cur = dc.dequeueCat();
		System.out.print("\nThe Cat available is := named '" + cur.getName() + "'");
		//		cur = dc.dequeueCat();
		//		System.out.print("\nThe Cat available is := named '" + cur.getName() + "'");
		//throws exception saying "no cat available"
	}
}
