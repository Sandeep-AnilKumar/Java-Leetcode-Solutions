package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class ReconstructItinerary {
    List<String> finalList;
    int size;
    boolean found;
    Map<String, Integer> visited;

    public ReconstructItinerary() {
        finalList = new ArrayList<>();
        size = 0;
        found = false;
        visited = new HashMap<>();
    }

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return finalList;
        Map<String, Node> map = new HashMap<>();
        List<String> temp = new ArrayList<>();
        size = tickets.length + 1;

        for (String[] t : tickets) {
            if (!map.containsKey(t[0])) {
                map.put(t[0], new Node(t[0]));
            }

            if (!map.containsKey(t[1])) {
                map.put(t[1], new Node(t[1]));
            }
            map.get(t[0]).set.add(map.get(t[1]));
            visited.put(t[0] + "," + t[1], visited.getOrDefault(t[0] + "," + t[1], 0) + 1);
        }
        temp.add("JFK");
        dfs(map, "JFK", temp);
        return finalList;
    }

    private void dfs(Map<String, Node> map, String cur, List<String> list) {
        if (found) return;

        if (list.size() == size) {
            found = true;
            finalList = new ArrayList<>(list);
        }

        Node curNode = map.get(cur);
        for (Node next : curNode.set) {
            if (found || visited.get(curNode.name + "," + next.name) == 0) continue;
            visited.put(curNode.name + "," + next.name, visited.get(curNode.name + "," + next.name) - 1);
            list.add(next.name);
            dfs(map, next.name, list);
            visited.put(curNode.name + "," + next.name, visited.get(curNode.name + "," + next.name) + 1);
            list.remove(list.size() - 1);
        }
    }

    class Node implements Comparable<Node> {
        String name;
        TreeSet<Node> set;

        public Node(String name) {
            this.name = name;
            set = new TreeSet<>();
        }

        @Override
        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        ReconstructItinerary itinerary1 = new ReconstructItinerary();
        System.out.println("The reconstructed itinerary is := " + itinerary1.findItinerary(tickets));

        ReconstructItinerary itinerary2 = new ReconstructItinerary();
        tickets = new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        System.out.println("The reconstructed itinerary is := " + itinerary2.findItinerary(tickets));

        ReconstructItinerary itinerary3 = new ReconstructItinerary();
        tickets = new String[][]{{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},
                {"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        System.out.println("The reconstructed itinerary is := " + itinerary3.findItinerary(tickets));
    }
}
