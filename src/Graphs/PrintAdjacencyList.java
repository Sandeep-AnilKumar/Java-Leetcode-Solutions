package Graphs;

/**
 * @author sandeepa
 */

public class PrintAdjacencyList {
	public static void print(Node[] adjacencyList) {
		if(adjacencyList == null || adjacencyList.length == 0) return;

		StringBuffer sb = new StringBuffer();

		for(Node node: adjacencyList) {
			sb.append(node);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
