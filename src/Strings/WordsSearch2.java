package Strings;
import java.util.LinkedList;
import java.util.List;

public class WordsSearch2 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b'},{'c','d'}};
        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        List<String> result = findWords(board, words);
        for(String word : result) {
            System.out.println(word);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if(board == null || board.length == 0 || words == null || words.length == 0) {
            return result;
        }

        int row = board.length;
        int column = board[0].length;
        int size = result.size();
        boolean[] wordMap = new boolean[words.length];
        int length = words.length;

        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; ++j) {
                for(int k = 0; k < length; ++k) {
                    if(board[i][j] == words[k].charAt(0) && !wordMap[k]) {
                        findWordsDFS(words[k], board, i, j, 0, result, false);
                        if(result.size() > size) {
                            wordMap[k] = true;
                            size = result.size();
                        }
                    }
                }
            }
        }
        return result;
    }

    public static boolean findWordsDFS(String word, char[][] board, int i, int j, int curChar, List<String> result, boolean found) {
        if(!found && curChar == word.length()) {
            if(!result.contains(word)) {
                result.add(word);
            }
            found = true;
            return found;
        }

        if(!found && i >= 0 && j >= 0 && i <= board.length - 1 && j <= board[0].length - 1) {
            if(board[i][j] == word.charAt(curChar)) {
                board[i][j] = '*';
                found = findWordsDFS(word, board, i-1, j, curChar + 1, result, found) ||
                        findWordsDFS(word, board, i+1, j, curChar + 1, result, found) ||
                        findWordsDFS(word, board, i, j-1, curChar + 1, result, found) ||
                        findWordsDFS(word, board, i, j+1, curChar + 1, result, found);
                board[i][j] = word.charAt(curChar);
            }
        }
        return found;
    }
} //might lead to TLE. 
