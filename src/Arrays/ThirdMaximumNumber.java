package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        boolean set = false;
        Set<Integer> seen = new HashSet<>();
        int count = 0;

        for (int num : nums) {
            if (!seen.contains(num)) {
                count++;
                if (count == 3) set = true;
                
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                }
                seen.add(num);
            }
        }
        if (!set) return max1;
        return max3;
    }
    
    public static void main(String[] args) {
        ThirdMaximumNumber maximumNumber = new ThirdMaximumNumber();
        int[] nums = {1, 2, 3};
        System.out.print("The third maximum number in [ ");
        Arrays.stream(nums).forEach(n -> System.out.print(n + ", "));
        System.out.println("] is := " + maximumNumber.thirdMax(nums));

        nums = new int[]{1, 2};
        System.out.print("The third maximum number in [ ");
        Arrays.stream(nums).forEach(n -> System.out.print(n + ", "));
        System.out.println("] is := " + maximumNumber.thirdMax(nums));

        nums = new int[]{2, 2, 3, 1};
        System.out.print("The third maximum number in [ ");
        Arrays.stream(nums).forEach(n -> System.out.print(n + ", "));
        System.out.println("] is := " + maximumNumber.thirdMax(nums));
    }
}
