package BitManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeBitSet {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int[] setBits = new int[R + 1];
        setBits[1] = 1;
        int totalPrimes = 0;
        int prev = 0;
        int cur = 2;
        int num = 2;

        while (num <= R) {
            if (num == cur * 2) {
                prev = cur;
                cur = cur * 2;
            } else {
                setBits[num] = setBits[num - cur] + 1;
                if (L <= num && num <= R && primes.contains(setBits[num])) totalPrimes++;
                num++;
            }
        }

        return totalPrimes;
    }
    
    public static void main(String[] args) {
        int L = 842;
        int R = 888;
        System.out.println("The total number of prime bit set numbers in the range : " 
                + L + " -> " + R + " is := " + new PrimeBitSet().countPrimeSetBits(L, R));
    }
}
