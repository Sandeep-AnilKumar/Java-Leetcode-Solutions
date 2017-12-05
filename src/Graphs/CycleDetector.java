package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class CycleDetector {
	static boolean isCycle = false;
	public static void main(String[] args) {
		CycleDetector detect = new CycleDetector();
		Node[] adjacencyList = new Node[3];

		for(int i = 0; i < 3; ++i) {
			adjacencyList[i] = new Node(i);
		}

		// Directed Graph: 0->1->2->0
		adjacencyList[0].addAdjacentNode(adjacencyList[1]);

		adjacencyList[1].addAdjacentNode(adjacencyList[2]);

		adjacencyList[2].addAdjacentNode(adjacencyList[0]);

		int start = 0;

		detect.DFSCycle(start, adjacencyList);

		if(isCycle) {
			System.out.println("The graph has a cycle");
		} else {
			System.out.println("The graph doesn't have a cycle");
		}

		for(int i = 0; i < 3; ++i) {
			adjacencyList[i].setUnvisited();
		}

		isCycle = false;
		detect.BFSCycle(start, adjacencyList);

		if(isCycle) {
			System.out.println("The graph has a cycle");
		} else {
			System.out.println("The graph doesn't have a cycle");
		}

		adjacencyList = new Node[4];

		isCycle = false;
		for(int i = 0; i < 4; ++i) {
			adjacencyList[i] = new Node(i);
		}

		// Directed Graph: 0 -> 1, 0 -> 2 -> 0, 0 -> 3
		adjacencyList[0].addAdjacentNode(adjacencyList[1]);
		adjacencyList[0].addAdjacentNode(adjacencyList[2]);
		adjacencyList[0].addAdjacentNode(adjacencyList[3]);

		adjacencyList[1].addAdjacentNode(adjacencyList[2]);

		adjacencyList[2].addAdjacentNode(adjacencyList[0]);
		adjacencyList[2].addAdjacentNode(adjacencyList[3]);

		detect.DFSCycle(start, adjacencyList);

		if(isCycle) {
			System.out.println("The graph has a cycle");
		} else {
			System.out.println("The graph doesn't have a cycle");
		}

		for(int i = 0; i < 4; ++i) {
			adjacencyList[i].setUnvisited();
		}

		isCycle = false;
		detect.BFSCycle(start, adjacencyList);

		if(isCycle) {
			System.out.println("The graph has a cycle");
		} else {
			System.out.println("The graph doesn't have a cycle");
		}

		isCycle = false;
		for(int i = 0; i < 4; ++i) {
			adjacencyList[i] = new Node(i);
		}

		// Directed Graph: 0 -> 1, 0 -> 2, 0 -> 3
		adjacencyList[0].addAdjacentNode(adjacencyList[1]);
		adjacencyList[0].addAdjacentNode(adjacencyList[2]);
		adjacencyList[0].addAdjacentNode(adjacencyList[3]);

		adjacencyList[1].addAdjacentNode(adjacencyList[2]);

		//adjacencyList[2].addAdjacentNode(adjacencyList[0]);
		adjacencyList[2].addAdjacentNode(adjacencyList[3]);

		detect.DFSCycle(start, adjacencyList);

		if(isCycle) {
			System.out.println("The graph has a cycle");
		} else {
			System.out.println("The graph doesn't have a cycle");
		}

		for(int i = 0; i < 4; ++i) {
			adjacencyList[i].setUnvisited();
		}

		isCycle = false;
		detect.BFSCycle(start, adjacencyList);

		if(isCycle) {
			System.out.println("The graph has a cycle");
		} else {
			System.out.println("The graph doesn't have a cycle");
		}

	}

	public void DFSCycle(int start, Node[] adjacencyList) {
		if(adjacencyList == null || adjacencyList.length == 0) return;
		Node cur = adjacencyList[start];

		if(!cur.isUnvisited()) return;

		cur.setVisiting();

		for(Node adjacent: cur.getAdjacentNodes()) {
			if(!isCycle && adjacent.isUnvisited()) {
				DFSCycle(adjacent.getValue(), adjacencyList);
			} else if(!isCycle && adjacent.isVisiting()) {
				isCycle = true;
				return;
			}
		}

		cur.setVisited();
		return;
	}

	public void BFSCycle(int start, Node[] adjacencyList) {
		if(adjacencyList == null || adjacencyList.length == 0) return;

		Deque<Node> queue =  new ArrayDeque<>();
		queue.offer(adjacencyList[start]);

		Node cur = null;

		while(!queue.isEmpty()) {
			cur = queue.poll();

			cur.setVisiting();

			for(Node adjacent: cur.getAdjacentNodes()) {
				if(!isCycle && adjacent.isUnvisited()) {
					adjacent.setVisiting();
					queue.offer(adjacent);
				} else if(!isCycle && adjacent.isVisited()) {
					isCycle = true;
					return;
				}
			}
			cur.setVisited();
		}
		return;
	}
}
