package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime2 {
    static class Pair {
        int n;
        int w;

        public Pair(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dp = new int[N + 1];
        Map<Integer, List<Pair>> ad = new HashMap<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[K] = 0;
        int total = -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.offer(new Pair(K, 0));
        Pair cur;

        for (int[] t : times) {
            if (!ad.containsKey(t[0])) {
                ad.put(t[0], new ArrayList<>());
            }
            ad.get(t[0]).add(new Pair(t[1], t[2]));
        }

        while(!pq.isEmpty()) {
            cur = pq.poll();
            if (cur != null && ad.containsKey(cur.n)) {
                for (Pair next : ad.get(cur.n)) {
                    if (dp[next.n] > dp[cur.n] + next.w) {
                        dp[next.n] = dp[cur.n] + next.w;
                        pq.offer(next);
                    }
                }
            }
        }

        for (int i = 1; i <= N; ++i) {
            if (dp[i] == Integer.MAX_VALUE) return -1;
            total = Math.max(total, dp[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        NetworkDelayTime2 networkDelayTIme2 = new NetworkDelayTime2();
        int[][] times = {{2,1,1},{2,3,3},{3,4,2}};
        int N = 4;
        int K = 2;
        System.out.println("The total time to propogate to all nodes is := " + networkDelayTIme2.networkDelayTime(times, N, K));
    }
}
