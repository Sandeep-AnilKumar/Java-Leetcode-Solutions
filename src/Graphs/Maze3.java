package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Maze3 {
    class Point implements Comparable<Point> {
        int dist;  // distance from ball
        int row;
        int col;
        String dir;  // directions from ball
        Point(int dist, int row, int col, String dir) {
            this.dist = dist;
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
        public int compareTo(Point other) {
            return this.dist == other.dist ? this.dir.compareTo(other.dir) : this.dist - other.dist;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, ball[0], ball[1], ""));

        // arrays used for exploring 4 directions from a point
        char[] dstr = {'d', 'l', 'r', 'u'};
        int[][] dirs = {{1,0},{0,-1},{0,1},{-1,0}};

        while (!pq.isEmpty()) {
            Point pt = pq.poll();
            if (pt.row == hole[0] && pt.col == hole[1]) {
                return pt.dir;
            }
            visited[pt.row][pt.col] = true;

            for (int i = 0; i < dirs.length; i++) {
                int newRow = pt.row;
                int newCol = pt.col;
                int dist = pt.dist;
                String ds = pt.dir;

                // Explore current direction until hitting a wall or the hole
                while (newRow + dirs[i][0] >= 0 &&
                        newRow + dirs[i][0] < maze.length &&
                        newCol + dirs[i][1] >= 0 &&
                        newCol + dirs[i][1] < maze[0].length &&
                        maze[newRow + dirs[i][0]][newCol + dirs[i][1]] != 1) {

                    newRow += dirs[i][0];
                    newCol += dirs[i][1];
                    dist += 1;
                    if (newRow == hole[0] && newCol == hole[1]) {
                        break;
                    }
                }
                if (!visited[newRow][newCol]) {
                    pq.offer(new Point(dist, newRow, newCol, ds+dstr[i]));
                }
            }
        }
        return "impossible";
    }

    public static void main(String[] args) {
        Maze3 maze3 = new Maze3();
        int[][] maze = {
                {0,0,0,0,0,0,0},
                {0,0,1,0,0,1,0},
                {0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1}};
        int[] ball = {0, 4};
        int[] hole = {3, 0};
        System.out.println("The shortest distance from ball to hole is := " + maze3.findShortestWay(maze, ball, hole));
    }
}
