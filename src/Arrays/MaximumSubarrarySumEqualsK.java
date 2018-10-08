package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarrarySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, -1, -2, -1, 2};
        int k = 1;
        System.out.println("The maximum subarray with sum equals " + k + " is := " +
        new MaximumSubarrarySumEqualsK().maxSubArrayLen(nums, k));
    }
}
