package Arrays;

public class ImageSmoother {

	public static void main(String[] args) {
		ImageSmoother smoother = new ImageSmoother();
		int[][] M = {{2,3,4},
				{5,6,7},
				{8,9,10},
				{11,12,13},
				{14,15,16}};
		M = smoother.imageSmoother(M);
		System.out.println("The matrix of image smoothing is := ");
		for(int[] rows: M) {
			System.out.print("[");
			for(int i: rows) {
				System.out.print(i + ", ");
			}
			System.out.print("]\n");
		}
	}

	public int[][] imageSmoother(int[][] M) {
		int rows = M.length;
		int cols = M[0].length;
		int[][] smoothed = new int[rows][cols];
		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < cols; ++j) {
				smooth(M, smoothed, i, j, rows, cols);
			}
		}
		return smoothed;
	}

	public void smooth(int[][] M, int[][] smoothed, int i, int j, int rows, int cols) {
		int cur = 0;
		int total = 0;

		cur += M[i][j];
		total++;

		if(i > 0 && j > 0) {
			cur += M[i - 1][j - 1];
			total++;
		}

		if(i > 0) {
			cur += M[i - 1][j];
			total++;
		}

		if(i > 0 && j < cols - 1) {
			cur += M[i - 1][j + 1];
			total++;
		}

		if(j > 0) {
			cur += M[i][j - 1];
			total++;
		}

		if(j < cols - 1) {
			cur += M[i][j + 1];
			total++;
		}

		if(i < rows - 1 && j > 0) {
			cur += M[i + 1][j - 1];
			total++;
		}

		if(i < rows - 1) {
			cur += M[i + 1][j];
			total++;
		}

		if(i < rows - 1 && j < cols - 1) {
			cur += M[i + 1][j + 1];
			total++;
		}
		smoothed[i][j] = (int)(cur / total);
		return;
	}

	//A better approach
	public int[][] imageSmootherBetter(int[][] m) {
		if(m == null || m.length == 0 || m[0].length == 0)
			return m;

		int rows = m.length;
		int cols = m[0].length;
		int res[][] = new int[rows][cols];

		for(int rw=0; rw< rows;rw++) {
			for(int col = 0; col< cols; col++){
				res[rw][col] = average(rw, col, rows, cols, m); // checks 8 sides to get the average
			}
		}

		return res;
	}

	private int average(int rw, int col, int rows, int cols, int[][] m) {
		int sum = 0;
		int count = 0;
		for(int x: new int[]{-1, 0, 1}) { // travers 8 sides
			for(int y: new int[]{-1, 0, 1}) {
				if(valid(rw+x, col+y, rows, cols)) {
					count++;
					sum += m[rw+x][col+y];
				}
			}
		}
		return sum/count;
	}

	// validate that the coordinates are valid
	private boolean valid(int rw, int col, int rows, int cols) {
		return rw >=0 && rw < rows && col >=0 && col < cols;
	}
}