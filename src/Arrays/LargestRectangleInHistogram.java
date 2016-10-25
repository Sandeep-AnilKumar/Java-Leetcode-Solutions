package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println("Largest Rectangle in Histogram is : " + largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int length = heights.length;
        int top = 0;
        int area = 0;
        int maxArea = 0;
        int i = 0;
        for(;i < length; ++i) {
            if(i == 0 || heights[i] < heights[stack.peekLast()]) {
                while(!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                    top = stack.pollLast();
                    if(stack.isEmpty()) {
                        area = heights[top] * i;
                    } else {
                        area = heights[top] * (i - 1 - stack.peekLast());
                    }
                    if(area > maxArea) {
                        maxArea = area;
                    }
                }
                stack.offerLast(i);
            } else {
                stack.offerLast(i);
            }
        }

        while(!stack.isEmpty()) {
            top = stack.pollLast();
            if(stack.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - 1 - stack.peekLast());
            }
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
