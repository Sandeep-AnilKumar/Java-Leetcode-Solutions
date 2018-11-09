package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return false;
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        int node = 0, next = 0;
        for (int start = 0; start < graph.length; ++start) {
            if (color[start] == -1) {
                color[start] = 0;
                dq.offer(start);
                while (!dq.isEmpty()) {
                    node = dq.poll();
                    next = color[node] ^ 1;
                    for (int e : graph[node]) {
                        if (color[e] == -1) {
                            color[e] = next;
                            dq.offer(e);
                        } else if (color[e] != next) return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println("Is the graph bipartite? := " + bipartiteGraph.isBipartite(graph));
        graph = new int[][]{{1, 2, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println("Is the graph bipartite? := " + bipartiteGraph.isBipartite(graph));
    }
}
