package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2};
        List<List<Integer>> result = iterativePermute2(nums);
        for(List<Integer> r : result) {
            System.out.print("[");
            for(int num : r) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }

    public static List<List<Integer>> iterativePermute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        List<Integer> permutation  = new ArrayList<Integer>();
        permutation.add(nums[0]);
        result.add(permutation);
        int length = nums.length;
        int start = 0;
        int curSize = 0;

        for(int i = 1; i < length; ++i) {
            if(i == 0 || nums[i] != nums[i-1]) {
                start = 0;
            }
            curSize = result.size();
            for(int j = start; j < curSize; ++j) {
                for(int k = 0; k < result.get(j).size(); ++k) {
                    permutation = new ArrayList<Integer>(result.get(j));
                    permutation.add(k, nums[i]);
                    result.add(permutation);
                }
                result.get(j).add(nums[i]);
                start = curSize;
            }
        }
        return result;
    }
}
