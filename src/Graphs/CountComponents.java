package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountComponents {

    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        int totalComponents = n;

        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            adjacencyMap.put(i, set);
        }

        for (int[] edge : edges) {

            if (!adjacencyMap.get(edge[0]).contains(edge[1])) {
                totalComponents--;
                
                if (adjacencyMap.get(edge[0]).size() < adjacencyMap.get(edge[1]).size()) {
                    adjacencyMap.get(edge[1]).addAll(adjacencyMap.get(edge[0]));
                    for (int adjacent : adjacencyMap.get(edge[0])) {
                        adjacencyMap.put(adjacent, adjacencyMap.get(edge[1]));
                    }
                } else {
                    adjacencyMap.get(edge[0]).addAll(adjacencyMap.get(edge[1]));
                    for (int adjacent : adjacencyMap.get(edge[1])) {
                        adjacencyMap.put(adjacent, adjacencyMap.get(edge[0]));
                    }
                }
            }
        }
        
        return totalComponents;
    }

    public int countComponentsBetter(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }
    
    class UnionFind {
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
            }
            else {
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
            }
            count--;
        }

        public int count() {
            return count;
        }
    }
    

    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{5,6},{0,2},{1,7},{5,9},{1,8},{3,4},{0,6},{0,7},{0,3},{8,9}};
        CountComponents components = new CountComponents();
        System.out.println("The total number of disjoint components in the graph are := " + components.countComponents(n, edges));
    }
}
