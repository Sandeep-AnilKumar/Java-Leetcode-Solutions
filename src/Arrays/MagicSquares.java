package Arrays;

public class MagicSquares {
    public int numMagicSquaresInside(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int ans = 0;
        for (int r = 0; r < R-2; ++r)
            for (int c = 0; c < C-2; ++c) {
                if (grid[r+1][c+1] != 5) continue;  // optional skip
                if (magic(grid[r][c], grid[r][c+1], grid[r][c+2],
                        grid[r+1][c], grid[r+1][c+1], grid[r+1][c+2],
                        grid[r+2][c], grid[r+2][c+1], grid[r+2][c+2]))
                    ans++;
            }

        return ans;
    }

    public boolean magic(int... values) {
        int[] count = new int[16];
        for (int v: values) count[v]++;
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (values[0] + values[1] + values[2] == 15 &&
                values[3] + values[4] + values[5] == 15 &&
                values[6] + values[7] + values[8] == 15 &&
                values[0] + values[3] + values[6] == 15 &&
                values[1] + values[4] + values[7] == 15 &&
                values[2] + values[5] + values[8] == 15 &&
                values[0] + values[4] + values[8] == 15 &&
                values[2] + values[4] + values[6] == 15);
    }

    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println("The number of magic sqaures are := " + new MagicSquares().numMagicSquaresInside(grid));
    }
}
