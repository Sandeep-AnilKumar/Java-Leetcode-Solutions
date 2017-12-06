package Graphs;

/**
 * @author sandeepa
 */

public class MatrixToList {
	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 0, 1, 1},
				{1, 0, 1, 0, 0},
				{0, 0, 0, 1, 1}, 
				{1, 0, 1, 0, 1}, 
				{1, 0, 1, 1, 0}};
		Node[] adjacencyList = new MatrixToList().convertMatrixToList(matrix);
		System.out.println("The adjacency list is := ");

		PrintAdjacencyList.print(adjacencyList);
	}

	public Node[] convertMatrixToList(int[][] matrix) {
		if(matrix ==  null || matrix.length == 0) return new Node[0];

		int size = matrix.length;
		Node[] adjacencyList = new Node[size];
		Node cur = null;

		int count = 0;
		int edgeCount = 0;
		for(int[] edges: matrix) {
			cur = new Node(count);
			adjacencyList[count] = cur;

			edgeCount = 0;
			for(int edge: edges) {
				if(edge == 1) {
					if(adjacencyList[edgeCount] == null) {
						adjacencyList[edgeCount] = new Node(edgeCount);
					}
					cur.addAdjacentNode(adjacencyList[edgeCount]);
				}
				edgeCount++;
			}
			count++;
		}
		return adjacencyList;
	}
}
