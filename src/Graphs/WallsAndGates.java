package Graphs;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int rows = rooms.length, cols = rooms[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (rooms[i][j] == 0) {
                    for (int[] d : dir) {
                        dfs(rooms, i + d[0], j + d[1], 1, dir);
                    }
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dist, int[][] dir) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == -1 ||
                rooms[i][j] == 0 || dist >= rooms[i][j]) return;
        rooms[i][j] = dist;
        for (int[] d : dir) {
            dfs(rooms, i + d[0], j + d[1], dist + 1, dir);
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,  -1,  0,  2147483647},
                {2147483647, 2147483647, 2147483647,  -1},
                {2147483647,  -1, 2147483647,  -1},
                {0,  -1, 2147483647, 2147483647}};
        new WallsAndGates().wallsAndGates(rooms);
        System.out.println("The updated distances are := ");
        for (int[] r : rooms) {
            for (int n : r) {
                System.out.print(n + ", ");
            }
            System.out.println("");
        }
        
    }
}
