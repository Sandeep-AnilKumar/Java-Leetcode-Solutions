package Graphs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 1; i < board.length - 1; ++i) {
            for (int j = 1; j < board[i].length - 1; ++j) {
                if (board[i][j] == 'O') {
                    capture(board, i, j);
                }
            }
        }
    }

    private void capture(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length - 1 || j >= board[i].length - 1 || board[i][j] != 'O') return;
        
        board[i][j] = '.';
        capture(board, i, j - 1);
        capture(board, i - 1, j);
        capture(board, i, j + 1);
        capture(board, i + 1, j);

        if (i - 1 >= 0 && j - 1 >= 0 && i + 1 <= board.length - 1 && j + 1 <= board[i].length - 1 && board[i][j + 1] == 'X' 
                && board[i + 1][j] == 'X' && board[i - 1][j] == 'X' && board[i][j - 1] == 'X') board[i][j] = 'X';
        
        if (board[i][j] == '.') board[i][j] = 'O';
    }

    private void printBoard(char[][] board) {
        for (char[] rows : board) {
            for (char b : rows) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};

        System.out.println("The input board is := ");
        surroundedRegions.printBoard(board);
        System.out.println("The solved board is := ");
        surroundedRegions.solve(board);
        surroundedRegions.printBoard(board);

        board = new char[][]{
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}};

        System.out.println("The input board is := ");
        surroundedRegions.printBoard(board);
        System.out.println("The solved board is := ");
        surroundedRegions.solve(board);
        surroundedRegions.printBoard(board);

        board = new char[][]{
                {'X','O','X'},
                {'O','X','O'},
                {'X','O','X'}};

        System.out.println("The input board is := ");
        surroundedRegions.printBoard(board);
        System.out.println("The solved board is := ");
        surroundedRegions.solve(board);
        surroundedRegions.printBoard(board);
        
        board = new char[][]{{'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}};
        
        System.out.println("The input board is := ");
        surroundedRegions.printBoard(board);
        System.out.println("The solved board is := ");
        surroundedRegions.solve(board);
        surroundedRegions.printBoard(board);
        
        board = new char[][]{
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};

        System.out.println("The input board is := ");
        surroundedRegions.printBoard(board);
        System.out.println("The solved board is := ");
        surroundedRegions.solve(board);
        surroundedRegions.printBoard(board);
    }
}
