package Arrays;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1, mid = 0;

        while (low < high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }

        return nums[low] == target ? low : -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 4;
        System.out.println("The position of " + target + " is := " + new SearchInRotatedSortedArray().search(nums, target));
    }
}
