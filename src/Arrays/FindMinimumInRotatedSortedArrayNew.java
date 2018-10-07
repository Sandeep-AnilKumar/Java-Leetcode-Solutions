package Arrays;

public class FindMinimumInRotatedSortedArrayNew {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int low = 0, high = nums.length - 1, mid = 0, min = Integer.MAX_VALUE;

        while (low < high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] < min) min = nums[mid];

            if (nums[low] <= nums[mid]) {
                if (nums[low] > nums[high]) low = mid + 1;
                else high = mid - 1;
            } else {
                if (nums[low] > nums[high]) high = mid - 1;
                else low = mid + 1;
            }
        }

        return nums[low] < min ? nums[low] : min;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("The minimum element in rotated sorted array is := " + new FindMinimumInRotatedSortedArrayNew().findMin(nums));
    }
}
