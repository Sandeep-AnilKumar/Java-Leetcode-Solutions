package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = new int[]{3,2,4};
        int target = 6;
        int indices[] = twoSum(nums,target);
        System.out.println("The two indices of numbers that add up to the target are : ");
        for(int i : indices) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int index1 = 0, index2 = 0;
        for(int i = 0; i < length; ++i) {
            if(map.containsKey(target - nums[i])) {
                index1 = map.get(target - nums[i]);
                index2 = i;
                return new int[]{index1, index2};
            }
            map.put(nums[i], i);

        }
        return new int[2];
    }
}
