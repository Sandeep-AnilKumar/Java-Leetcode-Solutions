package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> result = permuteUnique(nums);
        for(List<Integer> r : result) {
            System.out.print("[");
            for(int num : r) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> r = new LinkedList<>();
        r.add(new ArrayList<>());
        for (int num : nums) {
            int n = r.size();
            for (int j = 0; j < n; j++) {
                List<Integer> list = r.poll();
                if (list != null) {
                    for (int k = 0; k <= list.size(); k++) {
                        if (k > 0 && list.get(k - 1) == num)
                            break;
                        List<Integer> t = new ArrayList<>(list);
                        t.add(k, num);
                        r.offer(t);
                    }
                }
            }
        }
        return r;
    }
}
