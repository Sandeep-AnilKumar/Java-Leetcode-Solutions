package Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OpenLock {
    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println("The minimum number of steps required to open the locks are := " +
                openLock.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains(start)) return -1;
        String next = "";
        int ch = 0;
        int[][] c = {{1, 9}, {2, 0}, {3, 1}, {4, 2}, {5, 3}, {6, 4}, {7, 5}, {8, 6}, {9, 7}, {0, 8}};
        Set<String> s = new HashSet<>();
        Set<String> e = new HashSet<>();
        Set<String> temp = new HashSet<>();
        int level = 0;

        s.add(start);
        e.add(target);

        while (!s.isEmpty() && !e.isEmpty()) {
            if (s.size() > e.size()) {
                temp = s;
                s = e;
                e = temp;
            }

            temp = new HashSet<>();
            for (String cur : s) {
                if (e.contains(cur)) return level;
                dead.add(cur);
                for (int i = 0; i < 4; ++i) {
                    ch = cur.charAt(i) - '0';
                    for (int n : c[ch]) {
                        next = cur.substring(0, i) + n + cur.substring(i + 1, 4);
                        if (!dead.contains(next)) {
                            temp.add(next);
                        }
                    }
                }
            }
            s = temp;
            level++;
        }
        return -1;
    }
}
