package Trees;

import java.util.Arrays;

public class RedundantConnection {
    public static class UnionFind {
        private int[] size;
        private int[] parent;
        private int[] redundantConnection;

        UnionFind(int n) {
            size = new int[n];
            parent = new int[n];
            redundantConnection = new int[2];

            Arrays.fill(size, 1);

            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        private int find(int i) {
            //path compression by halving
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        void union(int[] edge) {
            int x = find(edge[0]);
            int y = find(edge[1]);

            if (x == y) {
                redundantConnection[0] = edge[0] < edge[1] ? edge[0] : edge[1];
                redundantConnection[1] = edge[0] < edge[1] ? edge[1] : edge[0];
            } else {
                if (size[x] < size[y]) {
                    parent[x] = y;
                    size[y] += size[x];
                } else {
                    parent[y] = x;
                    size[x] += size[y];
                }
            }
        }

        int[] getRedundantConnection() {
            return redundantConnection;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);

        for (int[] edge : edges) {
            unionFind.union(edge);
        }

        return unionFind.getRedundantConnection();
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        RedundantConnection connection = new RedundantConnection();
        int[] redundantConnection = connection.findRedundantConnection(edges);
        System.out.print("The redundant connection is := " + redundantConnection[0] + ", " + redundantConnection[1]);
    }
}
