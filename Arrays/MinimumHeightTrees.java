package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {

	public static void main(String[] args) {
		int n = 2;
		int[][] edges = new int[][]{{0,1},{1,0}};
		List<Integer> result = findMinHeightTrees(n, edges);
		if(result != null && result.size() > 0) {
			System.out.println("Minimum height trees starts at: - ");
			for(int node : result) {
				System.out.print(node + ", ");
			}
		}
		else {
			System.out.println("There is no minimum height tree");
		}
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n <= 1) {
			return Collections.singletonList(0);
		}

		@SuppressWarnings("unchecked")
		Set<Integer>[] adj = new Set[n];
		for(int i = 0; i < n; ++i) {
			adj[i] = new HashSet<Integer>();
		}

		for(int[] e : edges) {
			adj[e[1]].add(e[0]);
			adj[e[0]].add(e[1]);
		}

		List<Integer> leaves = new ArrayList<Integer>();
		for(int i = 0; i < n; ++i) {
			if(adj[i].size() == 1) {
				leaves.add(i);
			}
		}


		while(n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<Integer>();
			for(int leaf : leaves) {
				int nextLeaf = adj[leaf].iterator().next();

				adj[nextLeaf].remove(leaf);
				if(adj[nextLeaf].size() == 1) {
					newLeaves.add(nextLeaf);
				}
			}

			leaves = newLeaves;
		}
		return leaves;
	}


	//Failed attempt.

	/*static class Trees {
		int node;
		List<Trees> edges;
		boolean visited;

		public Trees() {
			edges = new ArrayList<Trees>();
			node = 0;
			visited = false;
		}

		public Trees(int number) {
			this();
			node = number;
		}

		public void add(Trees edge) {
			edges.add(edge);
		}

		public boolean contains(Trees edge) {
			return edges.contains(edge);
		}
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		Trees[] tree = new Trees[n];
		for(int i = 0; i < n; ++i) {
			tree[i] = new Trees(i);
		}

		int length = edges.length;

		for(int i = 0; i < length; ++i) {
			if(!tree[edges[i][1]].contains(tree[edges[i][0]])) {
				tree[edges[i][1]].add(tree[edges[i][0]]);
			}
			if(!tree[edges[i][0]].contains(tree[edges[i][1]])) {
				tree[edges[i][0]].add(tree[edges[i][1]]);
			}
		}

		Map<Integer, Integer> result = new HashMap<>();
		for(int i = 0; i < n; ++i) {
			if(!tree[i].visited) {
				constructLeaves(result, tree[i], null);
			}
		}

		int min = Integer.MAX_VALUE;
		for(int key : result.keySet()) {
			min = Math.min(min, result.get(key));
		}

		List<Integer> rootNodes = new ArrayList<>();

		for(int key : result.keySet()) {
			if(min == result.get(key)) {
				rootNodes.add(key);
			}
		}
		return rootNodes;
	}

	public static int constructLeaves(Map<Integer, Integer> result, Trees cur, Trees prev) {
		if(cur.visited == true) {
			return result.containsKey(cur) ? result.get(cur) : 0;
		}

		cur.visited = true;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		for(Trees e : cur.edges) {
			if(e != prev) {
				sum = 0;
				sum = 1 + constructLeaves(result, e, cur);
				min = Math.min(sum, min);
			}
		}

		if(!result.containsKey(cur)) {
			result.put(cur.node, min);
		}
		else {
			min = Math.min(min, result.get(cur));
			result.put(cur.node, min);
		}
		return sum;
	}*/
}