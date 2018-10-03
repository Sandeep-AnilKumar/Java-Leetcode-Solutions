package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class RescueBoats {
    
    //O(NlogN) TreeMap approach
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) return 0;
        int boats = 1, seats = 2;
        Integer cur = 0, prev = limit;

        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int p : people) {
            set.add(p);
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        while (!set.isEmpty()) {
            cur = set.floor(prev);
            if (cur == null) {
                seats = 2;
                boats++;
                prev = limit;
                continue;
            }
            
            prev -= cur;
            seats--;
            map.put(cur, map.get(cur) - 1);

            if (map.get(cur) == 0) {
                set.remove(cur);
                map.remove(cur);
            }

            if (prev == 0 || seats == 0) {
                if (!set.isEmpty()) {
                    boats++;
                    prev = limit;
                    seats = 2;
                }
            }
        }

        return boats;
    }
    
    //O(NlogN) Two-pointer approach
    
    public int numRescueBoatsTwoPointer(int[] people, int limit) {
        if (people == null || people.length == 0) return 0;
        Arrays.sort(people);
        
        int left = 0, right = people.length - 1, boats = 0;
        
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            boats++;
            right--;
        }
        
        if (right == left) boats++;
        
        return boats;
    }

    public static void main(String[] args) {
        RescueBoats boats = new RescueBoats();
        
        //TreeMap approach
        int[] people = {5, 4, 3, 3};
        int limit = 5;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoats(people, limit));

        people = new int[]{5, 4, 2, 1};
        limit = 6;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoats(people, limit));

        people = new int[]{1, 2, 3, 3};
        limit = 3;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoats(people, limit));

        people = new int[]{3, 2, 3, 2, 2};
        limit = 6;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoats(people, limit));

        people = new int[]{7, 3, 2};
        limit = 8;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoats(people, limit));
        
        //Two-pointer approach
        people = new int[]{5, 4, 3, 3};
        limit = 5;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoatsTwoPointer(people, limit));

        people = new int[]{5, 4, 2, 1};
        limit = 6;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoatsTwoPointer(people, limit));

        people = new int[]{1, 2, 3, 3};
        limit = 3;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoatsTwoPointer(people, limit));

        people = new int[]{3, 2, 3, 2, 2};
        limit = 6;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoatsTwoPointer(people, limit));

        people = new int[]{7, 3, 2};
        limit = 8;
        System.out.println("The number of rescue boats required is := " + boats.numRescueBoatsTwoPointer(people, limit));
        
    }
}
