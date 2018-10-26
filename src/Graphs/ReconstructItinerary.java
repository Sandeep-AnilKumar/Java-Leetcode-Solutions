package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> iti = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return iti;
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t : tickets) {
            map.putIfAbsent(t[0], new PriorityQueue<>());
            map.get(t[0]).add(t[1]);
        }

        dfs("JFK", map, iti);
        return iti;
    }

    private void dfs(String cur, Map<String, PriorityQueue<String>> map, List<String> iti) {
        PriorityQueue<String> neigh = map.get(cur);
        while(neigh != null && !neigh.isEmpty()) {
            dfs(neigh.poll(), map, iti);
        }
        iti.add(0, cur);
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
