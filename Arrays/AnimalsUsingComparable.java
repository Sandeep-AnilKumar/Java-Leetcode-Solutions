package Arrays;

import java.util.PriorityQueue;

class Animal implements Comparable<Animal>{
	int year;
	String name;
	long population;

	public Animal(int year, String name, long population) {
		this.year = year;
		this.name = name;
		this.population = population;
	}

	@Override
	public int compareTo(Animal other) {
		return name.compareTo(other.name);
	}

	public String toString() {
		return(name + " discovered in " + year + " has population of " + population);
	}
}

public class AnimalsUsingComparable {
	public static void main(String[] args) {
		PriorityQueue<Animal> pq = new PriorityQueue<Animal>();
		pq.offer(new Animal(2001, "Godzilla", 112445));
		pq.offer(new Animal(1856, "Spider", 125342));
		pq.offer(new Animal(1700, "Mammoth", 1));
		pq.offer(new Animal(1456, "Kiwi", 11));
		pq.offer(new Animal(1200, "Monkey", 11244124));
		pq.offer(new Animal(100, "Fish", 11244523));

		while(!pq.isEmpty()) {
			System.out.println(pq.poll().toString());
		}
	}
}
