package Arrays;

public class MinimumSubarraySum {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println("Minimum size subarray sum is := " + minSubArrayLen(s, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0 || s <= 0) {
            return 0;
        }
        int length = nums.length, sum = 0, start = 0, max = Integer.MAX_VALUE;
        for(int i = 0; i < length; ++i) {
            sum += nums[i];
            if(sum >= s) {
                max = Math.min(max, i - start + 1);
            }
            while(sum > s && start <= i-1) {
                sum -= nums[start++];
                if(sum >= s) {
                    max = Math.min(max, i - start + 1);
                }
            }
        }
        return max == Integer.MAX_VALUE ? 0 : max;
    }
}
