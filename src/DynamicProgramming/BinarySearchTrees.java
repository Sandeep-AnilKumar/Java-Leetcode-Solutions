package DynamicProgramming;

public class BinarySearchTrees {

	public static void main(String[] args) {
		int steps = numTrees(5);
		System.out.println("Number of distinct Trees:- "+ steps);
	}

	public static int numTrees(int n) {
		if(n<2)
			return 1;
		else
		{
			Integer M[] = new Integer[n+1];
			M[0] = 1;
			for(int i = 1; i <M.length; i++)
			{
				M[i] = 0;
				for(int j = 1; j <= i; j++)
				{
					M[i] += M[j-1] * M[i-j];
				}
			}
			return M[n];
		}
	}
}