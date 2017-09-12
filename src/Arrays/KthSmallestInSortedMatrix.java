package Arrays;

public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		KthSmallestInSortedMatrix sortedMatrix = new KthSmallestInSortedMatrix();
		int[][] matrix = {{1, 5, 9},
				{4, 6, 10},
				{6, 7, 11}};
		int k = 4;
		System.out.println("The " + k + "th smallest in the matrix is := " + sortedMatrix.kthSmallest(matrix, k));
	}

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int low = matrix[0][0];
		int high = matrix[n - 1][n - 1];
		int mid = 0;
		int count = 0;

		while(low <= high) {
			mid = low + ((high - low) >>> 1);
			count = getCount(matrix, mid);
			if(count >= k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public int getCount(int[][] matrix, int target) {
		int r = 0;
		int c = matrix.length - 1;
		int count = 0;

		while(r <= matrix.length - 1 && c >= 0) {
			if(matrix[r][c] <= target) {
				r++;
				count += c + 1;
			} else {
				c--;
			}
		}
		return count;
	}
}
