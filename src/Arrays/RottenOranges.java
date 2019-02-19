package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RottenOranges {
    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] oranges = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("Time taken to rot all oranges is := " + rottenOranges.orangesRotting(oranges));
    }

    public int orangesRotting(int[][] grid) {
        Deque<Pair> dq = new ArrayDeque<>();
        int min = 0, size = 0;
        Set<Pair> fresh = new HashSet<>();
        Set<Pair> visited = new HashSet<>();
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 2) dq.offer(new Pair(i, j));
                else if (grid[i][j] == 1) fresh.add(new Pair(i, j));
            }
        }

        if (fresh.isEmpty()) return 0;
        Pair cur, next;

        while (!dq.isEmpty() && !fresh.isEmpty()) {
            size = dq.size();
            for (int i = 0; i < size; ++i) {
                cur = dq.poll();
                visited.add(cur);
                for (int[] d : dir) {
                    next = new Pair(cur.i + d[0], cur.j + d[1]);
                    if (!visited.contains(next) && fresh.contains(next)) {
                        dq.offer(next);
                        fresh.remove(next);
                    }
                }
            }
            min++;
        }
        return fresh.isEmpty() ? min : -1;
    }

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || other.getClass() != getClass()) return false;
            Pair o = (Pair) other;
            return this.i == o.i && this.j == o.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}