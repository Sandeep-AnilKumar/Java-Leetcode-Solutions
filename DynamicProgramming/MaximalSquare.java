package DynamicProgramming;

public class MaximalSquare {

	public static void main(String[] args) {
		char [][]array = new char[][]{{'1','0','0','0','1'},
			{'1','0','1','1','1'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','1','1','1','1'}};

			int area = maximalSqaure(array);
			System.out.println("The area of the maximum sqaure is :"+ area);
	}

	public static int maximalSqaure(char[][] matrix)
	{
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		int maxArea = 0;

		int [][]countMatrix = new int[rowSize][colSize];

		for(int i = 0; i < countMatrix.length; i++)
		{	
			if(matrix[i][0] == '1')
			{
				countMatrix[i][0] = 1;
				maxArea = 1;
			}
		}
		for(int j = 0; j < countMatrix[0].length; j++)
		{	
			if(matrix[0][j] == '1')
			{
				countMatrix[0][j] = 1;
				maxArea = 1;
			}	
		}

		for(int i = 1; i<countMatrix.length;i++)
		{
			for(int j = 1; j<countMatrix[0].length;j++)
			{	
				if(matrix[i][j] == '1')
				{
					countMatrix[i][j] = Math.min(countMatrix[i-1][j-1], 
							Math.min(countMatrix[i][j-1],countMatrix[i-1][j])) + 1;
					maxArea = Math.max(maxArea, countMatrix[i][j]);
				}
			}
		}
		return maxArea*maxArea;
	}
}