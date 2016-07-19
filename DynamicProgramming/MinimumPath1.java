package DynamicProgramming;

public class MinimumPath1 {

	public static void main(String[] args) {
		int gridWithObstacles[][] = new int[][]{{0,0,0},{0,1,0},{0,1,0},{0,0,0}};
		int paths = minPathSum(gridWithObstacles);
		System.out.println("The number of unique paths is "+ paths);
	}

	public static int minPathSum(int[][] grid) {
		int rowLength = grid.length;
		int columnLength = grid[0].length;

		for(int i = 1; i <rowLength;i++)
			grid[i][0] += grid[i-1][0];

		for(int j = 1; j <columnLength;j++)
			grid[0][j] += grid[0][j-1];

		for(int i = 1; i<rowLength; i++)
		{
			for(int j = 1;j<columnLength;j++)
			{
				grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
			}
		}
		return grid[rowLength-1][columnLength-1];
	}
}
