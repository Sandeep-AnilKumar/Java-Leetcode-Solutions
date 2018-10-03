package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class ThreeSumNew {

    public static void main(String[] args) {
        int[] nums = {-1, 0, -1, 2, 1, -4};
        System.out.println("The different triplets are := " + new ThreeSumNew().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        if (nums == null || nums.length == 0) return triplets;
        Arrays.sort(nums);
        int left = 0, right = 0, target = 0, sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            target = -nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum == target) {
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left = getIndex(nums, left, 1);
                    right = getIndex(nums, right, -1);
                } else if (sum < target) {
                    left = getIndex(nums, left, 1);
                } else {
                    right = getIndex(nums, right, -1);
                }
            }
        }
        return triplets;
    }

    private int getIndex(int[] nums, int index, int additive) {
        do {
            index += additive;
        } while (index >= 0 && index < nums.length && (additive == 1 ? nums[index] == nums[index - 1] :
                nums[index] == nums[index + 1]));
        return index;
    }
}
