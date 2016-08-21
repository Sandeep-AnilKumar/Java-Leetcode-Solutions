package Arrays;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = new int[]{20,5,4,1,2,3};
		System.out.println("The peak element is at position: " + findPeakElement(nums));
	}

	public static int findPeakElement(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int length = nums.length;

		if(length == 1) {
			return 0;
		}

		int low = 0;
		int high = length - 1;
		int mid = 0;

		while(low <= high) {
			mid = low + ((high - low) >>> 1);

			if(mid > 0 && mid < length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			}
			else if(mid == 0 && mid < length - 1) {
				if(nums[mid] > nums[mid + 1]) {
					return mid;
				}
				else {
					return mid + 1;
				}
			}
			else if(mid == length - 1 && mid > 0) {
				if(nums[mid] > nums[mid - 1]) {
					return mid;
				}
				else {
					return mid - 1;
				}
			}
			else {
				if(nums[mid] < nums[mid - 1]) {
					high = mid - 1;
				}
				else {
					low = mid + 1;
				}
			}
		}
		return low;
	}
}