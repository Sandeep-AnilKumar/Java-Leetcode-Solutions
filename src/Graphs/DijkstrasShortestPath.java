package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasShortestPath {
    public static void main(String[] args) {
        Map<Integer, List<Edge>> adjacencyList = new HashMap<>();
        adjacencyList.put(0, Arrays.asList(new Edge(0, 1, 5), new Edge(0, 2, 7), new Edge(0, 3, 12)));
        adjacencyList.put(1, Arrays.asList(new Edge(1, 0, 5), new Edge(1, 2, 9), new Edge(1, 4, 7)));
        adjacencyList.put(2, Arrays.asList(new Edge(2, 0, 7), new Edge(2, 1, 9),
                new Edge(2, 3, 4), new Edge(2, 4, 4), new Edge(2, 5, 3)));
        adjacencyList.put(3, Arrays.asList(new Edge(3, 0, 12), new Edge(3, 2, 4), new Edge(3, 5, 7)));
        adjacencyList.put(4, Arrays.asList(new Edge(4, 1, 7), new Edge(4, 2, 4),
                new Edge(4, 5, 2), new Edge(4, 6, 5)));
        adjacencyList.put(5, Arrays.asList(new Edge(5, 2, 3), new Edge(5, 3, 7),
                new Edge(5, 4, 2), new Edge(5, 6, 2)));
        adjacencyList.put(6, Arrays.asList(new Edge(6, 4, 5), new Edge(6, 5, 2)));

        DijkstrasShortestPath dijkstrasShortestPath = new DijkstrasShortestPath();
        System.out.println("The shortest path from 0 to 6 is := " +
                dijkstrasShortestPath.shortestPath(adjacencyList, 0, 6));
    }

    private int shortestPath(Map<Integer, List<Edge>> adjacencyList, int start, int dest) {

        if (adjacencyList == null || adjacencyList.size() == 0) return -1;

        int n = adjacencyList.size(), w = 0;
        int[] dist = new int[n];
        Edge cur;
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) dist[i] = Integer.MAX_VALUE;
        for (Edge edge : adjacencyList.get(start)) pq.offer(edge);

        dist[start] = 0;
        visited[start] = true;

        while (!visited[dest] && !pq.isEmpty()) {
            cur = pq.poll();
            w = cur.w;

            if (!visited[cur.end]) {
                dist[cur.end] = dist[cur.start] + w;
                for (Edge edge : adjacencyList.get(cur.end)) pq.offer(edge);
                visited[cur.end] = true;
            }
        }

        return dist[dest];
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int w;

        Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public String toString() {
            return this.start + " - " + this.w + " -> " + this.end;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.w == other.w) {
                return this.start - other.start;
            }
            return this.w - other.w;
        }
    }
}
