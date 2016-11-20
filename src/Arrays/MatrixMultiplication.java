package Arrays;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,0,0},{-1,0,3}};
        int[][] B = new int[][]{{7,0,0},{0,0,0},{0,0,1}};
        System.out.println("Multiplied Matrix is");
        int[][] result = multiply(A, B);
        for(int[] row : result) {
            System.out.print("[");
            for(int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }

        int[][] result = new int[A.length][B[0].length];
        int colA = A[0].length, rowA = A.length, colB = B[0].length;

        for(int i = 0; i < rowA; ++i) {
            for(int j = 0; j < colA; ++j) {
                if(A[i][j] != 0) {
                    for(int k = 0; k < colB; ++k) {
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }    
            }
        }
        return result;
    }
}
