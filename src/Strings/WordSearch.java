package Strings;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCESEEDASA";

        System.out.println("Does word exist in the board: " + exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0 || board.length == 0) {
            return false;
        }

        int row = board.length;
        int column = board[0].length;
        boolean result = false;

        for(int i = 0; i < row && !result; ++i) {
            for(int j = 0; j < column && !result; ++j) {
                if(board[i][j] == word.charAt(0)) {
                    result = findWordDFS(board, word, i, j, 0, result);
                }
            }
        }
        return result;
    }

    public static boolean findWordDFS(char[][] board, String word, int i, int j, int curChar, boolean result) {
        if(curChar == word.length()) {
            return true;
        }

        if(i >= 0 && i <= board.length - 1 && j >= 0  && j <= board[0].length - 1 && curChar < word.length()) {
            if(board[i][j] != word.charAt(curChar)) return false;

            char c = board[i][j];
            board[i][j] = '*';
            result = findWordDFS(board, word, i-1, j, curChar + 1, result) || findWordDFS(board, word, i, j-1, curChar + 1, result) ||
                    findWordDFS(board, word, i+1, j, curChar + 1, result) || findWordDFS(board, word, i, j+1, curChar + 1, result);
            board[i][j] = c;
            return result;
        }
        return false;
    }
}
