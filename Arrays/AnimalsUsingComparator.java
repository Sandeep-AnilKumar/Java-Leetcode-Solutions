package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

class AnimalComparator implements Comparator<Animal> {
	public static class YearCompare implements Comparator<Animal> {
		@Override
		public int compare(Animal o1, Animal o2) {
			return o1.year - o2.year;
		}
	}

	@Override
	public int compare(Animal one, Animal other) {
		return one.year - other.year;
	}
}

public class AnimalsUsingComparator {
	public static void main(String[] args) {
		//using year; And normal class.
		PriorityQueue<Animal> pq = new PriorityQueue<Animal>(new AnimalComparator());
		pq.offer(new Animal(2001, "Godzilla", 112445));
		pq.offer(new Animal(1856, "Spider", 125342));
		pq.offer(new Animal(1700, "Mammoth", 1));
		pq.offer(new Animal(1456, "Kiwi", 11));
		pq.offer(new Animal(1200, "Monkey", 11244124));
		pq.offer(new Animal(100, "Fish", 11244523));

		System.out.println("After adding all the elements, the Queue is: - \n--------------------------------------------------");
		pq.forEach(System.out::println);

		System.out.println("\n-------------Year Comparison----------------");
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().toString());
		}

		//using name; and Anonymous inner class.
		PriorityQueue<Animal> pqName = new PriorityQueue<Animal>(new AnimalComparator() {
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

		//using population and java lambdas.
		PriorityQueue<Animal> pqPop = new PriorityQueue<Animal>((Animal x, Animal y) -> {
			return Long.compare(x.population, y.population);
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
