package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Maze2 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return 0;
        int rows = maze.length, cols = maze[0].length;
        int[][] di = new int[rows][cols];
        for (int[] dd : di) Arrays.fill(dd, Integer.MAX_VALUE);
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int[] cur;
        int i, j;
        int level, curLevel;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(start);
        di[start[0]][start[1]] = 0;
        while (!q.isEmpty()) {
            cur = q.poll();
            level = di[cur[0]][cur[1]];
            for (int[] d : dir) {
                curLevel = level;
                i = cur[0] + d[0]; j = cur[1] + d[1];
                while (i >= 0 && j >= 0 && i < maze.length && j < maze[i].length && maze[i][j] == 0) {
                    curLevel++;
                    i += d[0];
                    j += d[1];
                }
                if (di[i - d[0]][j - d[1]] > curLevel) {
                    q.offer(new int[] {i - d[0], j - d[1]});
                    di[i - d[0]][j - d[1]] = curLevel;
                }
            }
        }
        return di[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : di[destination[0]][destination[1]];
    }

    public static void main(String[] args) {
        Maze2 maze2 = new Maze2();
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println("Shortest distance to destination := " + maze2.shortestDistance(maze, start, destination));
    }
}
