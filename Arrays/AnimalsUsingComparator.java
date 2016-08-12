package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

class AnimalComparator implements Comparator<Animal> {
	@Override
	public int compare(Animal one, Animal other) {
		return one.year - other.year;
	}
}

public class AnimalsUsingComparator {
	public static void main(String[] args) {
		//using year;
		PriorityQueue<Animal> pq = new PriorityQueue<Animal>(6, new AnimalComparator());
		pq.offer(new Animal(2001, "Godzilla", 112445));
		pq.offer(new Animal(1856, "Spider", 125342));
		pq.offer(new Animal(1700, "Mammoth", 1));
		pq.offer(new Animal(1456, "Kiwi", 11));
		pq.offer(new Animal(1200, "Monkey", 11244124));
		pq.offer(new Animal(100, "Fish", 11244523));

		System.out.println("\n-------------Year Comparison----------------");
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().toString());
		}

		PriorityQueue<Animal> pqName = new PriorityQueue<Animal>(6, new AnimalComparator() {
			@Override
			public int compare(Animal one, Animal other) {
				return one.name.compareTo(other.name);
			}
		});

		System.out.println("\n-------------Name Comparison----------------");
		pqName.offer(new Animal(2001, "Godzilla", 112445));
		pqName.offer(new Animal(1856, "Spider", 125342));
		pqName.offer(new Animal(1700, "Mammoth", 1));
		pqName.offer(new Animal(1456, "Kiwi", 11));
		pqName.offer(new Animal(1200, "Monkey", 11244124));
		pqName.offer(new Animal(100, "Fish", 11244523));

		while(!pqName.isEmpty()) {
			System.out.println(pqName.poll().toString());
		}

		PriorityQueue<Animal> pqPop = new PriorityQueue<Animal>(6, new AnimalComparator() {
			@Override
			public int compare(Animal one, Animal other) {
				return Long.compare(one.population, other.population);
			}
		});

		System.out.println("\n-------------Population Comparison----------------");
		pqPop.offer(new Animal(2001, "Godzilla", 112445));
		pqPop.offer(new Animal(1856, "Spider", 125342));
		pqPop.offer(new Animal(1700, "Mammoth", 1));
		pqPop.offer(new Animal(1456, "Kiwi", 11));
		pqPop.offer(new Animal(1200, "Monkey", 11244124));
		pqPop.offer(new Animal(100, "Fish", 11244523));

		while(!pqPop.isEmpty()) {
			System.out.println(pqPop.poll().toString());
		}
	}
}
