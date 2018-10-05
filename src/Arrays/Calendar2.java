package Arrays;

import java.util.TreeMap;

public class Calendar2 {
    TreeMap<Integer, Integer> delta;

    public Calendar2() {
        delta = new TreeMap();
    }

    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Calendar2 calendar = new Calendar2();

        System.out.println(calendar.book(24, 40));
        System.out.println(calendar.book(43, 50));
        System.out.println(calendar.book(27, 43));
        System.out.println(calendar.book(5, 21));
        System.out.println(calendar.book(30, 40));
        System.out.println(calendar.book(14, 29));
        System.out.println(calendar.book(3, 19));
        System.out.println(calendar.book(3, 14));
    }
}
