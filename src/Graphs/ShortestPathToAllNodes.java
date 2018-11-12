package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToAllNodes {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<State> queue = new LinkedList<>();
        int[][] dist = new int[1 << N][N];
        for (int[] row : dist) Arrays.fill(row, N * N);

        for (int x = 0; x < N; ++x) {
            queue.offer(new State(1 << x, x));
            dist[1 << x][x] = 0;
        }

        while (!queue.isEmpty()) {
            State node = queue.poll();
            int d = dist[node.cover][node.head];
            if (node.cover == (1 << N) - 1) return d;

            for (int child : graph[node.head]) {
                int cover2 = node.cover | (1 << child);
                if (d + 1 < dist[cover2][child]) {
                    dist[cover2][child] = d + 1;
                    queue.offer(new State(cover2, child));

                }
            }
        }

        return -1;
    }

    static class State {
        int cover, head;

        State(int c, int h) {
            cover = c;
            head = h;
        }
    }

    public static void main(String[] args) {
        ShortestPathToAllNodes shortestPathToAllNodes = new ShortestPathToAllNodes();
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println("The shortest path to all nodes is of length := " + shortestPathToAllNodes.shortestPathLength(graph));

        graph = new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}};
        System.out.println("The shortest path to all nodes is of length := " + shortestPathToAllNodes.shortestPathLength(graph));

        graph = new int[][]{{1}, {0, 2, 4}, {1, 3}, {2}, {1, 5}, {4}};
        System.out.println("The shortest path to all nodes is of length := " + shortestPathToAllNodes.shortestPathLength(graph));
    }
}
