package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFightWithKStops {
    public static void main(String[] args) {
        CheapestFightWithKStops cheapestFightWithKStops = new CheapestFightWithKStops();
        int[][] flights = {{0, 2, 1}, {0, 1, 2}, {2, 0, 10}};
        int src = 0, dst = 2, k = 1;
        System.out.println("The cheapest flight from src to dst with at most k stops is := " +
                cheapestFightWithKStops.findCheapestPrice(3, flights, src, dst, k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops <= k) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[]{price + adj.get(a), a, stops + 1});
                }
            }
        }
        return -1;
    }
}
