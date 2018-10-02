package Arrays;

public class MaxMovingAverage {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int temp = k;
        double sum = 0, average = 0;
        while (--temp >= 0) {
            sum += nums[temp];
        }
        average = sum / k;
        for (int i = k; i < nums.length; ++i) {
            sum += nums[i] - nums[i - k];
            average = Math.max(average, sum / k);
        }
        return average;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println("The max avergage in contiguous subarray of size " + k + " is := " +
        new MaxMovingAverage().findMaxAverage(nums, k));
    }
}
