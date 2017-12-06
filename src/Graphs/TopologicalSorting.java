package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sandeepa
 */

public class TopologicalSorting {

	public static void main(String[] args) {
		TopologicalSorting sorting = new TopologicalSorting();
		Node[] adjacencyList = new Node[4];

		for(int nodeNum = 0; nodeNum < 4; ++nodeNum) {
			adjacencyList[nodeNum] = new Node(nodeNum);
		}

		adjacencyList[0].addAdjacentNode(adjacencyList[1]);
		adjacencyList[0].addAdjacentNode(adjacencyList[2]);
		adjacencyList[2].addAdjacentNode(adjacencyList[3]);

		List<Integer> order = new LinkedList<>();

		boolean canSort = sorting.topologicalSort(adjacencyList, order);
		PrintAdjacencyList.print(adjacencyList);

		if(canSort) {
			System.out.println("Topological sorting is possible, one possible ordering is " + order);
		} else {
			System.out.println("Topological sorting is not possible");
		}
		
		System.out.println("=================================================================");

		adjacencyList = new Node[4];

		for(int nodeNum = 0; nodeNum < 4; ++nodeNum) {
			adjacencyList[nodeNum] = new Node(nodeNum);
		}

		adjacencyList[0].addAdjacentNode(adjacencyList[1]);
		adjacencyList[1].addAdjacentNode(adjacencyList[0]);
		adjacencyList[0].addAdjacentNode(adjacencyList[2]);
		adjacencyList[2].addAdjacentNode(adjacencyList[3]);

		order = new LinkedList<>();

		canSort = sorting.topologicalSort(adjacencyList, order);
		PrintAdjacencyList.print(adjacencyList);

		if(canSort) {
			System.out.println("Topological sorting is possible, one possible ordering is " + order);
		} else {
			System.out.println("Topological sorting is not possible");
		}
	}

	public boolean topologicalSort(Node[] adjacencyList, List<Integer> order) {
		if(adjacencyList == null || adjacencyList.length == 0) return true;

		Deque<Integer> queue = new ArrayDeque<>();
		int length = adjacencyList.length, cur = 0;
		int[] incident = new int[length];

		for(Node node: adjacencyList) {
			for(Node adjacent: node.getAdjacentNodes()) {
				incident[adjacent.getValue()]++;
			}
		}

		for(int nodeNum = 0; nodeNum < length; ++nodeNum) {
			if(incident[nodeNum] == 0) {
				queue.offer(nodeNum);
			}
		}


		while(!queue.isEmpty()) {
			cur = queue.poll();
			order.add(cur);

			for(Node adjacent : adjacencyList[cur].getAdjacentNodes()) {
				incident[adjacent.getValue()]--;
				if(incident[adjacent.getValue()] == 0) {
					queue.offer(adjacent.getValue());
				}
			}
		}
		return order.size() == length;
	}
}
