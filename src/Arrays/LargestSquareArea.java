package Arrays;

/**
 * @author sandeepa
 */

public class LargestSquareArea {

	public static void main(String[] args) {
		int[] heights = {2, 5, 3, 1, 4};
		System.out.println("The largest square area is := " + new LargestSquareArea().largestSquareArea(heights));
	}

	public int largestSquareArea(int[] heights) {
		if(heights == null || heights.length == 0) {
			return 0;
		}

		int length = heights.length;
		int curMin = Integer.MAX_VALUE;
		int curIndex = 1;
		int maxArea = 0;
		int curMinIndex = 0;
		int i = 0;
		int j = 0;

		while(i < length) {
			j = i;
			curIndex = 1;
			curMinIndex = j;
			curMin = heights[i];
			while(curMin >= curIndex && j < length) {
				if(heights[j] < curMin) {
					curMin = heights[j];
					curMinIndex = j;
				}

				if(curMin >= curIndex) {
					curIndex++;
				}

				j++;
			}

			maxArea = Math.max(maxArea, (curIndex - 1) * (curIndex - 1));
			i = curMinIndex + 1;
		}

		return maxArea;
	}
}
