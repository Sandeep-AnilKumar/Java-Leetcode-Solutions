package DynamicProgramming;

public class UniquePaths2 {

	public static void main(String[] args) {
		int gridWithObstacles[][] = new int[][]{{0,0,0},{0,1,0},{0,1,0},{0,0,0}};
		int paths = uniquePathsWithObstacles(gridWithObstacles);
		System.out.println("The number of unique paths is "+ paths);
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rowLength = obstacleGrid.length;
		int columnLength = obstacleGrid[0].length;
		int[][] dynamicGrid = new int [rowLength][columnLength];

		for(int i = 0; i < rowLength; i++)
		{
			if(obstacleGrid[i][0] == 1)
			{
				dynamicGrid[i][0] = 0;
				break;
			}
			else dynamicGrid[i][0] = 1;
		}

		for(int j = 0; j < columnLength; j++)
		{
			if(obstacleGrid[0][j] == 1)
			{
				dynamicGrid[0][j] = 0;
				break;
			}
			else dynamicGrid[0][j] = 1;
		}

		for(int i = 1; i < rowLength; i++)
		{
			for(int j = 1; j < columnLength; j++)
			{
				if(obstacleGrid[i][j] == 1)
					dynamicGrid[i][j ]= 0;
				else
					dynamicGrid[i][j] = dynamicGrid[i][j-1] + dynamicGrid[i-1][j];
			}
		}
		return dynamicGrid[rowLength-1][columnLength-1];
	}
}
