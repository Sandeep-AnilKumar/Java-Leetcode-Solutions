package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumber {

    public static void main(String[] args) {
        int[] nums = {4,3,2,1,7,8,2,3};
        System.out.println("The disappeared numbers are : " + findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        int length = nums.length;
        int temp = 0;
        for(int i = 0; i < length; ++i) {
            temp = Math.abs(nums[i]);
            if(nums[temp - 1] > 0) {
                nums[temp - 1] = -nums[temp - 1];   
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < length; ++i) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
