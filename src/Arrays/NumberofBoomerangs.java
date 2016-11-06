package Arrays;

import java.util.HashMap;
import java.util.Map;

/*Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points 
 * (i, j, k) such that the distance between i and j equals the distance between 
 * i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates 
 * of points are all in the range [-10000, 10000] (inclusive).
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]*/

public class NumberofBoomerangs {

    public static void main(String[] args) {
        int[][] points = {{5,5},{4,7},{6,5},{6,9},{3,7},{4,5},{2,5},{4,4},{3,0}};
        System.out.println("Number of boomerangs :=" + numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int count = 0;
        int length = points.length;
        for (int i = 0; i < length; ++i) {
            int[] point = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < length; ++j) {
                if (j != i) {
                    int[] other = points[j];
                    int dis = getDistance(point, other);
                    if (!map.containsKey(dis)) {
                        map.put(dis, 0);
                    }
                    map.put(dis, map.get(dis)+1);
                }
            }
            for (int key : map.keySet()) {
                int val = map.get(key);
                count += val * (val-1);
            }
        }
        return count;
    }

    public static int getDistance(int[] point, int[] other) {
        return (point[0]-other[0])*(point[0]-other[0]) + (point[1]-other[1])*(point[1]-other[1]);
    }
}
