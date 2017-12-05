package Graphs;

/**
 * @author sandeepa
 */

public class TwoColoring {
	public static enum Color {
		BLUE, RED;
	}

	static boolean possible = true;

	public static void main(String[] args) {
		TwoColoring twoColor = new TwoColoring();
		Node[] adjacencyList = new Node[3];

		for(int i = 0; i < 3; ++i) {
			adjacencyList[i] = new Node(i);
		}

		adjacencyList[0].addAdjacentNode(adjacencyList[1]);
		adjacencyList[0].addAdjacentNode(adjacencyList[2]);

		adjacencyList[1].addAdjacentNode(adjacencyList[0]);
		adjacencyList[1].addAdjacentNode(adjacencyList[2]);

		adjacencyList[2].addAdjacentNode(adjacencyList[0]);
		adjacencyList[2].addAdjacentNode(adjacencyList[1]);

		int start = 0;

		Color[] colors = new Color[3];
		twoColor.color(start, adjacencyList, colors, 0);

		if(!possible) {
			System.out.println("Two coloring is not possible, there is an even length cycle in the graph");
		} else {
			System.out.println("Two coloring is possible");
		}

		System.out.println("The colors are := ");
		for(int i = 0; i < 3; ++i) {
			System.out.println(i + " -> " + colors[i]);
		}

		adjacencyList = new Node[4];

		for(int i = 0; i < 4; ++i) {
			adjacencyList[i] = new Node(i);
		}

		adjacencyList[0].addAdjacentNode(adjacencyList[1]);
		adjacencyList[0].addAdjacentNode(adjacencyList[3]);

		adjacencyList[1].addAdjacentNode(adjacencyList[0]);
		adjacencyList[1].addAdjacentNode(adjacencyList[2]);

		adjacencyList[2].addAdjacentNode(adjacencyList[1]);
		adjacencyList[2].addAdjacentNode(adjacencyList[3]);

		adjacencyList[3].addAdjacentNode(adjacencyList[0]);
		adjacencyList[3].addAdjacentNode(adjacencyList[2]);

		possible = true;

		colors = new Color[4];
		twoColor.color(start, adjacencyList, colors, 0);

		if(!possible) {
			System.out.println("\nTwo coloring is not possible, there is an even length cycle in the graph");
		} else {
			System.out.println("\nTwo coloring is possible");
		}

		System.out.println("The colors are := ");
		for(int i = 0; i < 4; ++i) {
			System.out.println(i + " -> " + colors[i]);
		}	
	}

	public void color(int start, Node[] adjacencyList, Color[] colors, int bit) {
		if(adjacencyList == null || adjacencyList.length == 0) return;
		Node cur = adjacencyList[start];

		if(!cur.isUnvisited()) return;

		cur.setVisiting();
		colors[start] = bit == 0 ? Color.BLUE : Color.RED;

		for(Node adjacent: cur.getAdjacentNodes()) {
			if(adjacent.isUnvisited() && colors[adjacent.getValue()] == null && possible) {
				color(adjacent.getValue(), adjacencyList, colors, bit ^ 1);
			} else if(possible && (colors[adjacent.getValue()].equals(Color.BLUE) && bit == 0) || ((colors[adjacent.getValue()].equals(Color.RED) && bit == 1))) {
				possible = false;
				return;
			}
		}

		cur.setVisited();
		return;
	}
}
