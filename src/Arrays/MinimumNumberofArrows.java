package Arrays;

import java.util.Arrays;
import java.util.Comparator;

/*There are a number of spherical balloons spread in two-dimensional space. For
each balloon, provided input is the start and end coordinates of the horizontal
diameter. Since it's horizontal, y-coordinates don't matter and hence the
x-coordinates of start and end of the diameter suffice. Start is always smaller
than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the
x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart =
x = xend. There is no limit to the number of arrows that can be shot. An arrow
once shot keeps travelling up infinitely. The problem is to find the minimum
number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8]
and [1,6]) and another arrow at x = 11 (bursting the other two balloons).*/

public class MinimumNumberofArrows {

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println("Minimum number of arrows to burst all balloons is :=" + findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int count = 1;
        int end = points[0][1];
        for(int[] point : points) {
            if(point[0] > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
