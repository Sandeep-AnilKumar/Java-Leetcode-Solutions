package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumInRotatedSortedArray2 {

	public static void main(String[] args) {
		int[] nums = new int[]{1,1,3};
		int k = 3;
		int result = findMin1(nums);
		System.out.println("Minimum element is: " + result);
	}

	public static int findMin(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		List<Integer> formattedList = new ArrayList<>();
		int length = nums.length;

		if(length == 1) {
			return nums[0];
		}

		for(int i = 0; i < length - 1; ++i) {
			if(nums[i] == nums[i+1]) {
				continue;
			}
			else {
				formattedList.add(nums[i]);
			}
		}

		formattedList.add(nums[length - 1]);
		int size = formattedList.size();
		int[] newArray = new int[size];
		for(int i = 0; i < size; ++i) {
			newArray[i] = formattedList.get(i);
		}

		if(newArray == null || newArray.length == 0) {
			return 0;
		}

		int newLength = newArray.length;
		if(newLength == 1) {
			return nums[0];
		}

		int low = 0;
		int high = newLength - 1;
		int mid = 0;

		while(low < high) {
			mid = low + ((high - low) >>> 1);

			if(newArray[mid] < newArray[high]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return newArray[low];
	} //Brute Force, not a good technique.

	//A better solution

	public static int findMin1(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int length = nums.length;

		if(length == 1) {
			return nums[0];
		}

		int low = 0;
		int high = nums.length - 1;
		int mid = 0;

		while(low < high) {
			mid = low + ((high - low ) >>> 1);

			if(nums[mid] == nums[high]) {
				if(nums[mid] == nums[low]) {
					if(mid > 0 && nums[mid] != nums[mid - 1]) {
						high = mid;
					}
					else {
						low = mid + 1;
					}
				}
				else {
					high = mid;
				}
			}
			else if(nums[mid] < nums[high]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return nums[low];
	}
}