package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

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
        //return other.year - year;
        //will cause overflow, if both are not positive, better to use: -
        return (other.year > year ? 1 : (other.year < year ? -1 : 0));
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

        System.out.println("After adding all the elements, the Queue is: - \n--------------------------------------------------");
        pq.forEach(System.out::println);

        System.out.println("\n-------------Year Comparison (Descending order)----------------");

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

        //using population (Descending order) and java lambdas.
        PriorityQueue<Animal> pqPop = new PriorityQueue<Animal>((Animal x, Animal y) -> {
            return ((Long)y.population).compareTo(x.population);
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


        System.out.println("\n\n------------------------Using Lists-----------------------------------------");
        List<Animal> list = new ArrayList<>();
        list.add(new Animal(1700, "Mammoth", 1));
        list.add(new Animal(1456, "Kiwi", 11));
        list.add(new Animal(1200, "Monkey", 11244124));
        list.add(new Animal(2001, "Godzilla", 112445));
        list.add(new Animal(1856, "Spider", 125342));
        list.add(new Animal(100, "Fish", 11244523));

        System.out.println("\n-------------------------Animals after adding to list-------------------------------");
        list.forEach(System.out::println);

        //Will by default sort by year, since compareTo method in Animals is defined to do so, this is natural ordering (Comparable).
        Collections.sort(list);

        System.out.println("\n-------------------------Animals after sorting the list with natural ordering-------------------------------");
        list.forEach(System.out::println);

        Collections.sort(list, Collections.reverseOrder());

        System.out.println("\n-------------------------Animals after sorting the list with natural ordering in increasing order-------------------------------");
        list.forEach(System.out::println);

        Collections.sort(list, new AnimalComparator() {
            @Override
            public int compare(Animal one, Animal other) {
                return one.name.compareTo(other.name);
            }
        });

        System.out.println("\n-------------------------Animals after sorting with name (Comparator)-------------------------------");
        list.forEach(System.out::println);

        Collections.sort(list,(Animal x, Animal y) -> {
            return ((Long)x.population).compareTo(y.population);
        });

        System.out.println("\n-------------------------Animals after sorting with population (Comparator)-------------------------------");
        list.forEach(System.out::println);

        Collections.sort(list, (new AnimalComparator.YearCompare()));

        System.out.println("\n-------------------------Animals after sorting with Year (Comparator as static inner class)-------------------------------");
        list.forEach(System.out::println);

        list.sort((o1, o2) -> {return (o1.year > o2.year ? 1 : (o1.year < o2.year ? -1 : 0));});
        System.out.println("\n-------------------------Without Using Collections-----------------------------------------------------");
        list.forEach((o1) -> System.out.println(o1));
    }
}
