package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safe = new ArrayList<>();
        if (graph == null || graph.length == 0) return safe;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> neigh = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int cur;

        for (int i = 0; i < graph.length; ++i) {
            if (graph[i] == null || graph[i].length == 0) {
                dq.offer(i);
            } else {
                if (!map.containsKey(i)) {
                    map.put(i, new HashSet<>());
                }
                for (int e : graph[i]) {
                    map.get(i).add(e);
                    if (!neigh.containsKey(e)) {
                        neigh.put(e, new HashSet<>());
                    }
                    neigh.get(e).add(i);
                }
            }
        }

        while (!dq.isEmpty()) {
            cur = dq.poll();
            safe.add(cur);
            if (neigh.containsKey(cur)) {
                for (int e : neigh.get(cur)) {
                    if (map.containsKey(e) && map.get(e).remove(cur) && map.get(e).isEmpty()) {
                        dq.offer(e);
                    }
                }
            }
        }

        Collections.sort(safe);
        return safe;
    }

    public static void main(String[] args) {
        EventualSafeNodes eventualSafeNodes = new EventualSafeNodes();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println("The eventual safe nodes are := " + eventualSafeNodes.eventualSafeNodes(graph));
    }
}
