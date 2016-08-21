package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxInEverySubarrayWindow {

	public static void main(String[] args) {
		int[] nums = new int[]{1,-2,5,6,0,9,8,-1,2,0};
		int[] result = maxSlidingWindow(nums, 3);
		for(int num : result) {
			System.out.print(num + ", ");
		}

	}

	public static Integer[] maxsInEveryWindows(int[] arr, int k) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		/* Process first k (or first window) elements of array */
		for (int i = 0; i < k; i++) {
			// For very element, the previous smaller elements are useless so
			// remove them from deque
			while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
				deque.removeLast(); // Remove from rear
			}
			// Add new element at rear of queue
			deque.addLast(i);
		}
		List<Integer> result = new ArrayList<Integer>();
		// Process rest of the elements, i.e., from arr[k] to arr[n-1]
		for (int i = k; i < arr.length; i++) {
			// The element at the front of the queue is the largest element of
			// previous window, so add to result.
			result.add(arr[deque.getFirst()]);
			// Remove all elements smaller than the currently
			// being added element (remove useless elements)
			while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
				deque.removeLast();
			}
			// Remove the elements which are out of this window
			while (!deque.isEmpty() && deque.getFirst() <= i - k) {
				deque.removeFirst();
			}
			// Add current element at the rear of deque
			deque.addLast(i);
		}
		// Print the maximum element of last window
		result.add(arr[deque.getFirst()]);

		return result.toArray(new Integer[0]);
	}

	//Other solution

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return new int[]{};
		}

		int length = nums.length;
		int[] leftMax = new int[length];
		int[] rightMax = new int[length];

		leftMax[0] = nums[0];
		rightMax[length - 1] = nums[length - 1];

		for(int i = 1; i < length; ++i) {
			leftMax[i] = (i % k == 0) ? nums[i] : Math.max(leftMax[i-1], nums[i]);
			rightMax[length - 1 - i] = ((length - 1 - i) % k == 0) ? nums[length - 1 - i] : 
				Math.max(rightMax[length - i],nums[length - 1 - i]);
		}

		int[] res = new int[length - k + 1];

		for(int i = 0; i < length - k + 1; ++i) {
			res[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
		}
		return res;
	}
}
