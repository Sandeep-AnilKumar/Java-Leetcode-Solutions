package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<Integer, Node> adjacencyMap;

	Graph() {
		adjacencyMap = new HashMap<>();
	}

	public static enum State {
		Unvisited, Visited, Visiting;
	}

	public static class Node {
		private int val;
		private List<Node> adjacent;
		private State state;

		Node(int val) {
			this.val = val;
			this.adjacent = new LinkedList<>();
			state = State.Unvisited;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public void addAdjacent(Node node) {
			if(node.val != val) {
				adjacent.add(node);
			}
		}

		public List<Node> getAdjacent() {
			return adjacent;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(val + " - > ");

			for(Node n: adjacent) {
				sb.append(n.val + " || ");
			}

			if(adjacent.isEmpty()) {
				sb.append(" null ");
			}
			return sb.toString();
		}
	}

	public void addEdge(int start, int end) {
		if(!adjacencyMap.containsKey(start)) {
			adjacencyMap.put(start, new Node(start));
		}


		if(!adjacencyMap.containsKey(end)) {
			adjacencyMap.put(end, new Node(end));
		}

		Node startNode = adjacencyMap.get(start);
		Node endNode = adjacencyMap.get(end);

		if(!startNode.getAdjacent().contains(endNode)) {
			startNode.addAdjacent(endNode);
		}

		//remove comments for undirected.
		//		if(!endNode.getAdjacent().contains(startNode)) {
		//			endNode.getAdjacent().add(startNode);
		//		}

		return;
	}

	public List<Node> getNodes() {
		List<Node> nodes = new ArrayList<>();
		for(Map.Entry<Integer, Node> entry: adjacencyMap.entrySet()) {
			nodes.add(entry.getValue());
		}
		return nodes;
	}

	public boolean isEmpty() {
		return adjacencyMap.isEmpty();
	}
}
