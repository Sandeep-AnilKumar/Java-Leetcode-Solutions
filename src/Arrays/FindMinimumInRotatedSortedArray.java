package Arrays;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = new int[]{4,5,6,7,0,1,2,3};
		System.out.println("The minimum in the array is : " + findMin(nums));
	}

	public static int findMin(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int length = nums.length;
		if(length == 1) {
			return nums[0];
		}

		int low = 0, high = length - 1, mid = 0;

		while(low < high) {
			mid = low + ((high - low) >>> 1);
			if(nums[mid] < nums[high]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return nums[low];
	}
}
