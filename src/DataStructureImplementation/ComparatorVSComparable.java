package DataStructureImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sandeepa
 */

public class ComparatorVSComparable {
	private static class Person implements Comparable<Person>{
		private String name;
		private int id;

		private Person(String name, int id) {
			this.name = name;
			this.id = id;
		}

		private String getName() {
			return name;
		}

		private int getId() {
			return id;
		}

		private void getName(String name) {
			this.name = name;
		}

		private void setId(int id) {
			this.id = id;
		}

		@Override
		public int compareTo(Person p) {
			return this.id < p.id ? -1 : this.id > p.id ? 1 : 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", id=" + id + "]";
		}
	}

	static class NameComparator implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			int diff = o1.getName().compareTo(o2.getName());
			if(diff != 0) {
				return diff;
			}

			return o1.id < o2.id ? -1 : o1.id > o2.id ? 1 : 0; 
		}
	}

	static class NameComparatorReverse implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			int diff = o2.getName().compareTo(o1.getName());
			if(diff != 0) {
				return diff;
			}

			return o2.id < o1.id ? -1 : o2.id > o1.id ? 1 : 0;
		}
	}

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		Person person1 = new Person("Sam", 123);
		Person person2 = new Person("Adam", 234);
		Person person3 = new Person("John", 345);
		Person person4 = new Person("Bella", 456);
		Person person5 = new Person("Johnny", 678);
		Person person6 = new Person("Bella", 789);
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		persons.add(person5);
		persons.add(person6);

		Collections.sort(persons);
		System.out.println("Persons in sorted order by id := " + persons);

		Collections.reverse(persons);
		System.out.println("Persons in sorted order by id in decreasing order := " + persons);

		Collections.sort(persons, new NameComparator());
		System.out.println("Persons in sorted order by name := " + persons);

		Collections.sort(persons, new NameComparatorReverse());
		System.out.println("Persons in sorted order by name in decreasing order := " + persons);

		System.out.println("Are Bella's equal? := " + person4.equals(person6));
		System.out.println("Are the name's equal? := " + person4.getName().equals(person6.getName()));

		person4.setId(789);
		System.out.println("Are Bella's equal? := " + person4.equals(person6));

		Set<Person> treeSet = new TreeSet<>();

		for(Person person : persons) {
			System.out.println(person + " - HashCode := " + person.hashCode());
			treeSet.add(person);
		}

		System.out.println("List size := " + persons.size());
		System.out.println("Tree Set size := " + treeSet.size());

		for(Person person : treeSet) {
			System.out.println(person);
		}

		person4.setId(456);
		System.out.println("Are Bella's equal? := " + person4.equals(person6));

		for(Person person : persons) {
			treeSet.add(person);
		}

		System.out.println("Tree Set size := " + treeSet.size());

		for(Person person : treeSet) {
			System.out.println(person);
		}
	}
}
