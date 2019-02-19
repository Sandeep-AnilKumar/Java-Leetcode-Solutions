package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KevinBacon {

    public static void main(String[] args) {
        KevinBacon kevinBacon = new KevinBacon();
        Map<String, List<String>> edges = new HashMap<String, List<String>>() {{
            put("A", Arrays.asList("B", "E", "F"));
            put("B", Arrays.asList("A", "C", "D"));
            put("C", Arrays.asList("B", "E", "K"));
            put("D", Arrays.asList("B", "F"));
            put("E", Arrays.asList("A", "C", "K"));
            put("F", Arrays.asList("A", "D", "K"));
            put("K", Arrays.asList("C", "E", "F"));
        }};

        System.out.println("The bacon numbers are := " + kevinBacon.baconNumbers(edges));
    }

    public Map<String, Integer> baconNumbers(Map<String, List<String>> edges) {
        Map<String, Integer> numbers = new HashMap<>();
        if (edges == null || edges.size() == 0) return numbers;

        Map<String, String> parent = new HashMap<>();
        Map<String, States> visited = new HashMap<>();
        Deque<String> q = new ArrayDeque<>();

        for (String key : edges.keySet()) {
            numbers.put(key, -1);
            visited.put(key, States.Unvisited);
            parent.put(key, null);
        }

        int size = 0, dist = 0;
        String cur;

        q.offer("K");
        parent.put("K", null);

        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; ++i) {
                cur = q.poll();
                visited.put(cur, States.Visited);
                numbers.put(cur, dist);
                for (String connection : edges.get(cur)) {
                    if (visited.get(connection) == States.Unvisited) {
                        q.offer(connection);
                        parent.put(connection, cur);
                        visited.put(connection, States.Visiting);
                    }
                }
            }
            dist++;
        }

        //Path from K to All.
        StringBuffer sb;
        for (String key : parent.keySet()) {
            if (parent.get(key) != null) {
                sb = new StringBuffer();
                cur = key;
                while (cur != null) {
                    sb.insert(0, cur).insert(0, "->");
                    cur = parent.get(cur);
                }
                System.out.println(sb.substring(2, sb.length()));
            }
        }

        return numbers;
    }

    enum States {
        Visited, Visiting, Unvisited
    }
}
