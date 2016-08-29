package Strings;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    }// Might lead to TLE.

    //A better solution using Trie.

    static Set<String> res = new HashSet<String>();

    public static List<String> findWords1(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<String>(res);
    }

    public static void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (visited[x][y]) return;

        str += board[x][y];
        if (!trie.startsWith(str)) return;

        if (trie.search(str)) {
            res.add(str);
        }

        visited[x][y] = true;
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }
}
