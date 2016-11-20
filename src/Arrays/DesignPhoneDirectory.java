package Arrays;

import java.util.PriorityQueue;

public class DesignPhoneDirectory {

    PriorityQueue<Integer> pq;
    boolean[] numbers;
    int size;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        pq = new PriorityQueue<>((a, b) -> (a - b));
        numbers = new boolean[maxNumbers];
        for(int i = 0; i < maxNumbers; ++i) {
            pq.offer(i);
            numbers[i] = true;
        }
        size = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(!pq.isEmpty()) {
            int available = pq.poll();
            available %= size;
            numbers[available] = false;
            return available;
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return numbers[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(!numbers[number]) {
            numbers[number] = true;
            pq.offer(number + size);
        }
        return;
    }


    public static void main(String[] args) {
        DesignPhoneDirectory obj = new DesignPhoneDirectory(5);
        int param_1 = obj.get();
        System.out.println(param_1);
        boolean param_2 = obj.check(2);
        obj.release(2);
    }

    //Other possible solution.
    /**
     * /*
     * 
     * public PhoneDirectory(int maxNumbers) {
        future = maxNumbers;
    }

    public int get() {
        return future > 0 ? --future :
               list.isEmpty() ? -1 :
               map.remove(list.remove(list.size() - 1));
    }

    public boolean check(int number) {
        return number < future || map.containsKey(number);
    }

    public void release(int number) {
        if (!check(number)) {
            list.add(number);
            map.put(number, number);
        }
    }

    private int future;
    private ArrayList<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();
     * 
     * 
     * */
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */