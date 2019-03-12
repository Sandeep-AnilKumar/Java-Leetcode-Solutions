package Trees;

public class ConstructQuadTree {
	public static void main(String[] args) {
		ConstructQuadTree quadTree = new ConstructQuadTree();
		int[][] grid = {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
		Node node = quadTree.construct(grid);
		System.out.println(node);

		grid = new int[][]{{1, 1, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1},
				{0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 0}};
		node = quadTree.construct(grid);
		System.out.println(node);
	}

	public Node construct(int[][] grid) {
		if (grid == null || grid.length == 0) return null;
		return construct(grid, 0, grid.length - 1, 0, grid.length - 1);
	}

	private Node construct(int[][] grid, int rs, int re, int cs, int ce) {
		Node node = new Node();
		if (hasSameValue(grid, rs, re, cs, ce)) {
			node.val = grid[rs][cs] != 0;
			node.isLeaf = true;
		} else {
			node.isLeaf = false;
			int rmid = rs + (re - rs) / 2;
			int cmid = cs + (ce - cs) / 2;
			node.topLeft = construct(grid, rs, rmid, cs, cmid);
			node.topRight = construct(grid, rs, rmid, cmid + 1, ce);
			node.bottomLeft = construct(grid, rmid + 1, re, cs, cmid);
			node.bottomRight = construct(grid, rmid + 1, re, cmid + 1, ce);
			node.val = true;
		}
		return node;
	}

	private boolean hasSameValue(int[][] grid, int rs, int re, int cs, int ce) {
		if (rs == re) return true;
		int val = grid[rs][cs];
		for (int i = rs; i <= re; ++i) {
			for (int j = cs; j <= ce; ++j) {
				if (grid[i][j] != val) return false;
			}
		}
		return true;
	}

	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		@Override
		public String toString() {
			return "Node{" +
					"val=" + val +
					", isLeaf=" + isLeaf +
					", topLeft=" + topLeft +
					", topRight=" + topRight +
					", bottomLeft=" + bottomLeft +
					", bottomRight=" + bottomRight +
					'}';
		}
	}
}
