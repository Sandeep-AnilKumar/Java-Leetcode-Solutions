package Strings;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinDeletionSize {
    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 0) return 0;
        int count = 0;
        int prev = 0, cur;
        for (int i = 0; i < A[0].length(); ++i) {
            for (int j = 0; j < A.length; ++j) {
                if (j == 0) {
                    prev = (int) A[j].charAt(i);
                } else {
                    cur = (int) A[j].charAt(i);
                    if (cur < prev) {
                        count++;
                        break;
                    }
                    prev = cur;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinDeletionSize minDeletionSize = new MinDeletionSize();
        String[] A = {"rrjk","furt","guzm"};
        System.out.println("The min deletion size is := " + minDeletionSize.minDeletionSize(A));
    }
}
