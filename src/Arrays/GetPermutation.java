package Arrays;

import java.util.LinkedList;
import java.util.List;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        int[] factorial = new int[n + 1];
        int index = 0, cur = 0;
        StringBuilder sb = new StringBuilder();

        factorial[0] = 1;
        for (int i = 1; i <= n; ++i) {
            nums.add(i);
            factorial[i] = factorial[i - 1] * i;
        }
        k--;

        for (int i = 1; i <= n; ++i) {
            index = k / factorial[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[n - i];
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        System.out.println(new GetPermutation().getPermutation(n, k));
    }
}
