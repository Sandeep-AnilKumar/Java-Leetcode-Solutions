package Strings;

import java.util.PriorityQueue;

public class KthSmallestInLexicographicOrder {

    public static void main(String[] args) {
        int n = 4289384;
        int k = 1922239;
        System.out.println("The kth smallest element in Lexicographic Order is : " + findKthNumber(n, k));
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
}
