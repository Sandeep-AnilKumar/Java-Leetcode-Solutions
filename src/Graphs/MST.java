package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class MST {

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

        MST mst = new MST();
        System.out.println("The MST with Prims is := ");
        mst.prims(adjacencyList, 0);
        System.out.println("The MST with Kruskals is := ");
        mst.kruskals(adjacencyList);
    }

    private void prims(Map<Integer, List<Edge>> adjacencyList, int start) {
        if (adjacencyList == null || adjacencyList.size() == 0 || start < 0 || start >= adjacencyList.size()) return;
        List<Edge> tree = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Edge cur;
        int next, cost = 0;

        for (Edge edge : adjacencyList.get(start)) pq.offer(edge);
        visited.add(start);

        while (!pq.isEmpty()) {
            cur = pq.poll();
            next = cur.end;
            if (!visited.contains(next)) {
                visited.add(next);
                tree.add(cur);
                cost += cur.w;
                for (Edge edge : adjacencyList.get(next)) pq.offer(edge);
            }
        }

        System.out.println("Cost with prim's is := " + cost);
        for (Edge edge : tree) System.out.println(edge);
    }

    private void kruskals(Map<Integer, List<Edge>> adjacencyList) {
        if (adjacencyList == null || adjacencyList.size() == 0) return;
        List<Edge> tree = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Edge cur;
        int cost = 0;
        DSU dsu = new DSU(adjacencyList.size());

        for (Map.Entry<Integer, List<Edge>> entry : adjacencyList.entrySet()) {
            for (Edge edge : entry.getValue()) {
                pq.offer(edge);
            }
        }

        for (int i = 0; i < adjacencyList.size(); ++i) {
            while (!pq.isEmpty()) {
                cur = pq.poll();
                if (dsu.find(cur.start) == dsu.find(cur.end)) continue;
                dsu.union(cur.start, cur.end);
                tree.add(cur);
                cost += cur.w;
                break;
            }
        }

        System.out.println("Cost with Kruskal's is := " + cost);
        for (Edge edge : tree) System.out.println(edge);
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

    static class DSU {
        private int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            Arrays.fill(rank, 1);
            for (int i = 0; i < n; ++i) parent[i] = i;
        }

        public int find(int v) {
            while (parent[v] != v) {
                v = find(parent[v]);
            }
            return parent[v];
        }

        public void union(int u, int v) {
            int uParent = find(u);
            int vParent = find(v);

            if (uParent == vParent) return;
            if (rank[uParent] > rank[vParent]) {
                parent[vParent] = uParent;
                rank[uParent] += rank[vParent];
            } else {
                parent[uParent] = vParent;
                rank[vParent] += rank[uParent];
            }
        }
    }
}
