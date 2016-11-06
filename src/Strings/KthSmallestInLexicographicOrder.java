package Strings;

import java.util.PriorityQueue;

public class KthSmallestInLexicographicOrder {

    public static void main(String[] args) {
        int n = 200;
        int k = 20;
        System.out.println("The kth smallest element in Lexicographic Order is : " + findKthNumberEasier(n, k));
    }

    //Works fine but leads to MemoryLimitExceeded and/or TLE.
    public static int findKthNumber(int n, int k) {
        PriorityQueue<String>[] pq = new PriorityQueue[10];
        String temp = "";
        char msb;
        int msd = 0;
        for(int i = 0; i <= n; ++i) {
            temp = String.valueOf(i);
            msb = temp.charAt(0);
            msd = (((int) msb) - 48);
            if(pq[msd] == null) {
                pq[msd] = new PriorityQueue<String>();
            }
            pq[msd].offer(temp);
        }

        PriorityQueue<String> values = new PriorityQueue<>();
        int result = 0;
        int size = 0;
        for(int i = 1; i <= 9; ++i) {
            size = pq[i].size();
            if(k <= size) {
                values = pq[i];
                while(k-- > 0) {
                    temp = values.poll();
                }
                result = Integer.parseInt(temp);
                break;
            } else {
                k -= size;
            }
        }
        return result;
    }


    public static int findKthNumberEasier(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }
    //use long in case of overflow
    public static int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
