package Trees;

import java.util.Arrays;

public class ValidTree {
    public boolean validTree(int n, int[][] edges) {

        int[] pointers = new int[n];
        Arrays.fill(pointers, -1);
        int x = 0;
        int y = 0;

        for (int[] edge : edges) {
            x = find(pointers, edge[0]);
            y = find(pointers, edge[1]);

            if (x == y) return false;

            pointers[x] = y;
        }

        return n - 1 == edges.length;
    }

    private int find(int[] pointers, int index) {
        if (pointers[index] == -1) return index;
        return find(pointers, pointers[index]);
    }
    
    public static void main(String[] args) {
        ValidTree tree = new ValidTree();
        int[][] edges = {{0, 1},{0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        System.out.println("Is the graph a valid tree := " + tree.validTree(n, edges));
        
        edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 3}};
        n = 5;
        System.out.println("Is the graph a valid tree := " + tree.validTree(n, edges));
        
        edges = new int[][]{{0, 1}, {2, 3}};
        n = 4;
        System.out.println("Is the graph a valid tree := " + tree.validTree(n, edges));
    }
}
