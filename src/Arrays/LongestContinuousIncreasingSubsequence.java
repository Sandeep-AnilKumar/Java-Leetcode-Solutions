package Arrays;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1, cur = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                cur++;
                max = Math.max(max, cur);
            }
            else cur = 1;
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7, 9, 10};
        System.out.println("The longest continuous increasing subsequence is := " + 
                new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(nums));
    }
}
