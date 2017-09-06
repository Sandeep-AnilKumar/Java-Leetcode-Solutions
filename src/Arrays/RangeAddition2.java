package Arrays;

public class RangeAddition2 {

	public static void main(String[] args) {
		RangeAddition2 range = new RangeAddition2();
		int[][] ops = {{2,2},{2,1}};
		int m = 3;
		int n = 3;
		System.out.println("The number of max elements are := " + range.maxCount(m, n, ops));
	}

	//Runtime of k*(m + n), where k is the number of operations.
	public int maxCount(int m, int n, int[][] ops) {
		int[] rows = new int[m];
		int[] cols = new int[n];
		int max = 0;

		for(int[] op: ops) {
			for(int i = 0; i < op[0]; ++i) {
				rows[i]++;
				if(max < rows[i]) max = rows[i];
			}

			for(int j = 0; j < op[1]; ++j) {
				cols[j]++;
				if(max < cols[j]) max = cols[j];
			}
		}

		int rowCount = 0;
		int colCount = 0;
		for(int i = 0; i < m; ++i) {
			if(rows[i] == max) rowCount++;
		}

		for(int i = 0; i < n; ++i) {
			if(cols[i] == max) colCount++;
		}
		return rowCount * colCount;
	}

	//A better solution is below, with a runtime of k.

	public int maxCountBetter(int m, int n, int[][] ops) {
		int minX = m;
		int minY = n;

		for(int[] op: ops) {
			minX = Math.min(op[0], minX);
			minY = Math.min(op[1], minY);
		}
		return minX * minY;
	}
}