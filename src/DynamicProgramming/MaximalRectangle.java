package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle{

    public static void main(String[] args) {
        char [][]array = new char[][]{{'1','0','0','1','0'},
            {'1','1','0','0','0',},
            {'1','0','1','0','1'},
            {'1','1','1','0','1'}};
            int area = maximalRectangle(array);
            System.out.println("The area of maximal square: "+area);
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        int maxArea = 0;
        for(int i = 0; i < col; ++i) {
            dp[i] = matrix[0][i] - '0';
        }
        maxArea = Math.max(maxArea, histogram(dp));

        for(int i = 1; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if(matrix[i][j] - '0' == 1) {
                    dp[j] += 1;
                } else {
                    dp[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, histogram(dp));
        }
        return maxArea;
    }

    public static int histogram(int[] heights) {
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