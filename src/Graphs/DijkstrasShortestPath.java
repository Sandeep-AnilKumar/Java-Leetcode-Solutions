package Graphs;

import java.util.ArrayList;
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
        System.out.println("The shortest path from 0 to 6 using usual dijkstra is := " +
                dijkstrasShortestPath.shortestPath(adjacencyList, 0, 6));


        adjacencyList = new HashMap<>();
        adjacencyList.put(0, Arrays.asList(new Edge(0, 1, 3), new Edge(0, 2, 5)));
        adjacencyList.put(1, Arrays.asList(new Edge(1, 3, 3)));
        adjacencyList.put(2, Arrays.asList(new Edge(2, 4, 5)));
        adjacencyList.put(3, Arrays.asList(new Edge(3, 4, 3)));
        adjacencyList.put(4, new ArrayList<>());
        System.out.println("The shortest path from 0 to 4 using bi-directional dijkstra is := " +
                dijkstrasShortestPath.bidirectionalShortestPath(adjacencyList, 0, 4));
    }

    private int shortestPath(Map<Integer, List<Edge>> adjacencyList, int start, int dest) {

        if (adjacencyList == null || adjacencyList.size() == 0) return -1;

        int n = adjacencyList.size();
        int[] dist = new int[n];
        Edge cur;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) dist[i] = Integer.MAX_VALUE;
        for (Edge edge : adjacencyList.get(start)) pq.offer(edge);

        dist[start] = 0;

        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (dist[cur.end] > dist[cur.start] + cur.w) {
                dist[cur.end] = dist[cur.start] + cur.w;
                for (Edge edge : adjacencyList.get(cur.end)) pq.offer(edge);
            }
        }

        return dist[dest];
    }

    //incomplete
    private int bidirectionalShortestPath(Map<Integer, List<Edge>> adjacencyList, int start, int dest) {
        int n = adjacencyList.size();
        int[] fDist = new int[n];
        int[] bDist = new int[n];
        int[] fParent = new int[n];
        int[] bParent = new int[n];
        int intermediate = 0, temp = 0, dist = 0;
        Edge cur;
        PriorityQueue<Edge> fQueue = new PriorityQueue<>();
        PriorityQueue<Edge> bQueue = new PriorityQueue<>();
        Map<Integer, List<Edge>> bAdjacencyList = new HashMap<>();
        processBackwardEdges(adjacencyList, bAdjacencyList);

        Arrays.fill(fDist, Integer.MAX_VALUE);
        Arrays.fill(bDist, Integer.MAX_VALUE);

        Arrays.fill(fParent, -1);
        Arrays.fill(bParent, -1);

        fDist[start] = 0;
        bDist[dest] = 0;

        for (Edge edge : adjacencyList.get(start)) fQueue.offer(edge);
        for (Edge edge : bAdjacencyList.get(dest)) bQueue.offer(edge);

        while (!fQueue.isEmpty() && !bQueue.isEmpty()) {
            if (fQueue.peek() != null && bQueue.peek() != null && fQueue.peek().start == bQueue.peek().end) {
                intermediate = fQueue.peek().start;
                break;
            }

            cur = fQueue.poll();
            if (fDist[cur.end] > fDist[cur.start] + cur.w) {
                fDist[cur.end] = fDist[cur.start] + cur.w;
                fParent[cur.end] = cur.start;
                for (Edge edge : adjacencyList.get(cur.end)) fQueue.offer(edge);
            }

            cur = bQueue.poll();
            if (bDist[cur.start] > bDist[cur.end] + cur.w) {
                bDist[cur.start] = bDist[cur.end] + cur.w;
                bParent[cur.start] = cur.end;
                for (Edge edge : adjacencyList.get(cur.start)) bQueue.offer(edge);
            }
        }

        temp = intermediate;
        while (temp != start) {
            dist += fDist[temp];
            temp = fParent[temp];
        }

        temp = intermediate;
        while (temp != dest) {
            dist += bDist[temp];
            temp = bParent[temp];
        }

        return dist;
    }

    private void processBackwardEdges(Map<Integer, List<Edge>> adjacencyList, Map<Integer, List<Edge>> bAdjacencyList) {
        for (Map.Entry<Integer, List<Edge>> entry : adjacencyList.entrySet()) {
            for (Edge edge : entry.getValue()) {
                bAdjacencyList.putIfAbsent(edge.end, new ArrayList<>());
                bAdjacencyList.get(edge.end).add(new Edge(edge.end, edge.start, edge.w));
            }
        }
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
