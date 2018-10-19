package Arrays;

public class MinSubarrayLenNew {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s <= 0) return 0;

        int left = 0, right = 1, length = nums.length;
        int min = Integer.MAX_VALUE, cur = nums[0];

        while (right <= length && left < right) {
            if (cur < s && right < length) {
                cur += nums[right];
                right++;
            } else if (cur >= s){
                min = Math.min(min, right - left);
                cur -= nums[left];
                left++;
            } else {
                break;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums  = {2,3,1,2,4};
        int s = 7;
        System.out.println("The min len subarray with sum less than or equal to " + s + " is := " +
                new MinSubarrayLenNew().minSubArrayLen(s, nums));
    }
}
