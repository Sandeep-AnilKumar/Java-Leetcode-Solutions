package DynamicProgramming;

import java.util.Arrays;

public class MaximalRectangle{

	public static void main(String[] args) {
		char [][]array = new char[][]{{'1','0','0','1','0'},
			{'1','1','0','0','0',},
			{'1','0','1','0','1'},
			{'1','1','1','0','1'}};
			int area = maximalSquare(array);
			System.out.println("The area of maximal square: "+area);
	}

	public static int maximalSquare(char[][] matrix)
	{
		int m = matrix.length; 
		int n = matrix[0].length; 
		int left[]=new int[n];
		int right[]=new int[n];
		int height[]=new int[n]; 
		Arrays.fill(right,n);
		int maxA = 0;
		for(int i=0; i<m; i++)
		{
			int curleft=0, curright=n-1; 
			for(int j=0; j<n; j++) 
			{ 
				if(matrix[i][j]=='1') 
					height[j]++; 
				else height[j]=0; 
			} 
			for(int j=0; j<n; j++) 
			{
				if(matrix[i][j]=='1') 
					left[j]=Math.max(left[j],curleft);
				else
				{
					left[j]=0; curleft=j+1;
				} 
			}
			for(int j=n-1; j>=0; j--) 
			{
				if(matrix[i][j]=='1')
					right[j]=Math.min(right[j],curright);
				else 
				{
					right[j]=n-1; curright=j-1;
				}
			}
			for(int j=0; j<n; j++) 
				maxA = Math.max(maxA,(right[j]-left[j]+1)*height[j]);
		}
		return maxA;
	}
}