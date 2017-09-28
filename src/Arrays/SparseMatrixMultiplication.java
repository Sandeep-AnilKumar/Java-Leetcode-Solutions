package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sandeepa
 */

public class SparseMatrixMultiplication {
	public static void main(String[] args) {
		int[][] A = {{7, 0, 0},
				{-1, 0, 3}};

		int[][] B = {{1, 0, 0},
				{2, 0, 0},
				{0, 0, 2}};

		System.out.println("The resultant matrix is := ");

		int[][] C = new SparseMatrixMultiplication().multiply(A, B);
		for(int[] rows: C) {
			System.out.print("[");
			for(int n: rows) {
				System.out.print(n + ", ");
			}
			System.out.println("]");
		}
	}

	public int[][] multiply(int[][] A, int[][] B) {
		if(A == null || A.length == 0) return B;
		if(B == null || B.length == 0) return A;

		int aRows = A.length;
		int aCols = A[0].length;

		int bCols = B[0].length;
		int[][] C = new int[aRows][bCols];

		Map<String, Integer> aPoints = new HashMap<>();

		for(int i = 0; i < aRows; ++i) {
			for(int j = 0; j < aCols; ++j) {
				if(A[i][j] != 0) {
					aPoints.put(i + ":" + j, A[i][j]);
				}
			}
		}

		int curRow = 0;
		int curCol = 0;
		int curValue = 0;
		String curKey = "";
		String[] parts;
		for(Map.Entry<String, Integer> entry: aPoints.entrySet()) {
			curKey = entry.getKey();
			parts = curKey.split(":");
			curRow = Integer.valueOf(parts[0]);
			curCol = Integer.valueOf(parts[1]);
			curValue = entry.getValue();

			for(int k = 0; k < bCols; ++k) {
				C[curRow][k] += curValue * B[curCol][k];
			}
		}
		return C;
	}
}
