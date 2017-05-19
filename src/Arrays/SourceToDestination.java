package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import Arrays.Graph.Node;
import Arrays.Graph.State;

public class SourceToDestination {

	StringBuffer path;

	public SourceToDestination() {
		path = new StringBuffer();
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		SourceToDestination traversal = new SourceToDestination();
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(3, 2);
		g.addEdge(4, 5);
		g.addEdge(5, 1);

		System.out.println("The adjacency map for the graph is := ");
		Node start = null;
		Node end = null;
		for(Node n: g.getNodes()) {
			System.out.println(n);
			if(n.getVal() == 3) {
				start = n;
			}
			if(n.getVal() == 1) {
				end = n;
			}
		}

		boolean pathPresent = traversal.bfs(g, start, end);
		System.out.print("Is there a path from 3 to 1 using bfs ? := ");
		if(pathPresent) {
			System.out.println(pathPresent + " because of the path := " + traversal.path);
		} else {
			System.out.println(pathPresent);
		}

		for(Node n: g.getNodes()) {
			n.setState(State.Unvisited);
		}
		traversal.path = new StringBuffer();

		//DFS will give a path 3 -> 2 -> 5 -> 1. Whereas VFS will give a path 3 -> 4 -> 5 -> 1. Mainly because of the difference in implementation. One is
		//implemented using a queue, whereas other using a stack.

		pathPresent = traversal.dfs(g, start, end);
		System.out.print("Is there a path from 3 to 1 using dfs ? := ");
		if(pathPresent) {
			System.out.println(pathPresent + " because of the path := " + traversal.path);
		} else {
			System.out.println(pathPresent);
		}
	}

	public boolean bfs(Graph g, Node start, Node end) {	
		if(g.isEmpty() || start == null || end == null) {
			return false;
		}

		Deque<Node> q = new ArrayDeque<>();
		q.offerLast(start);
		Node cur;
		//Called, Caller
		Map<Integer, Integer> callingSeq = new HashMap<>();

		while(!q.isEmpty()) {
			cur = q.pollFirst();
			if(!cur.getState().equals(State.Visited)) {
				cur.setState(State.Visiting);
				for(Node n: cur.getAdjacent()) {
					if(n.getVal() == end.getVal()) {
						callingSeq.put(n.getVal(), cur.getVal());
						int source = end.getVal();
						while(source != start.getVal()) {
							path.insert(0, " -> " + source);
							source = callingSeq.get(source);
						}

						path.insert(0, start.getVal());
						return true;

					}
					if(!n.getState().equals(State.Visited)) {
						if(!callingSeq.containsKey(n.getVal())) {
							callingSeq.put(n.getVal(), cur.getVal());
						}
						q.offerLast(n);
					}
				}
				cur.setState(State.Visited);
			}
		}
		return false;
	}

	public boolean dfs(Graph g, Node start, Node end) {
		if(g.isEmpty() || start == null || end == null) {
			return false;
		}

		Deque<Node> stack = new ArrayDeque<>();
		stack.offerFirst(start);
		Node cur = null;
		Map<Integer, Integer> callingSeq = new HashMap<>();

		while(!stack.isEmpty()) {
			cur = stack.pollLast();
			if(!cur.getState().equals(State.Visited)) {
				cur.setState(State.Visiting);

				for(Node n: cur.getAdjacent()) {
					if(n.getVal() == end.getVal()) {
						callingSeq.put(n.getVal(), cur.getVal());
						int source = end.getVal();
						while(source != start.getVal()) {
							path.insert(0, " -> " + source);
							source = callingSeq.get(source);
						}

						path.insert(0, start.getVal());
						return true;
					}

					if(!n.getState().equals(State.Visited)) {
						callingSeq.put(n.getVal(), cur.getVal());
						stack.offerLast(n);
					}
				}
			}
		}
		return false;
	}

}
