package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return false;
        int[] a = new int[rooms.size()];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);
        int cur = 0;
        while(!dq.isEmpty()) {
            cur = dq.pollLast();
            if (a[cur] == 0) {
                a[cur] = 1;
                for (int e : rooms.get(cur)) {
                    dq.offer(e);
                }
            }
        }

        for (int i = 0; i < a.length; ++i) {
            if (a[i] == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
        System.out.println("Can visit all rooms? := " + keysAndRooms.canVisitAllRooms(rooms));

        rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(0, 1));
        System.out.println("Can visit all rooms? := " + keysAndRooms.canVisitAllRooms(rooms));
    }
}
