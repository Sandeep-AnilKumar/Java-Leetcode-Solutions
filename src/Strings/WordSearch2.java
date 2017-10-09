package Strings;

/**
 * @author sandeepa
 */

public class WordSearch2 {

	public static void main(String[] args) {
		char[][] board = {{'a','b'},{'c','d'}};
		String word = "bacd";

		System.out.println("Does word " + word + " exists? := " + new WordSearch2().exist(board, word));
	}

	public boolean exist(char[][] board, String word) {
		if(word == null || word.length() == 0 || board == null || board.length == 0) return false;

		boolean found = false;

		for(int i = 0; i < board.length && !found; ++i) {
			for(int j = 0; j < board[i].length && !found; ++j) {
				if(board[i][j] == word.charAt(0)) {
					found = findWord(board, word, 0, i, j, new boolean[board.length][board[0].length]);
				}
			}
		}

		return found;
	}

	public boolean findWord(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
		if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || index >= word.length()) return false;

		visited[i][j] = true;
		boolean result = false;

		if(board[i][j] == word.charAt(index)) {
			if(index == word.length() - 1) return true;
			result = findWord(board, word, index + 1, i + 1, j, visited) || findWord(board, word, index + 1, i, j + 1, visited) || findWord(board, word, index + 1, i - 1, j, visited) || findWord(board, word, index + 1, i, j - 1, visited);
		}
		visited[i][j] = false;
		return result;
	}
}
