package Graphs;

public class Maze1 {
    private int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }

    private boolean dfs(int[][] maze, boolean[][] visited, int[] c, int[] des) {
        if (visited[c[0]][c[1]]) return false;
        if (c[0] == des[0] && c[1] == des[1]) return true;

        visited[c[0]][c[1]] = true;
        boolean result = false;
        for (int[] d : dir) {
            int x = c[0] + d[0];
            int y = c[1] + d[1];
            while ( 0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
                x += d[0];
                y += d[1];
            }
            result = result || dfs(maze, visited, new int[]{ x - d[0], y - d[1]}, des);
        }
        return result;
    }

    public static void main(String[] args) {
        Maze1 maze1 = new Maze1();
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0, 4};
        int[] destination = {1, 2};
        System.out.println("Can the ball stop at destination := " + maze1.hasPath(maze, start, destination));
    }
}
