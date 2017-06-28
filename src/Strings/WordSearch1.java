package Strings;

import java.util.ArrayList;
import java.util.List;

public class WordSearch1 {

	class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			if(word == null || word.length() == 0) {
				return;
			}

			TrieNode current = root;
			int length = word.length();
			int index = 0;
			for(int i = 0; i < length; ++i) {
				index = word.charAt(i) - 'a';
				if(current.next[index] == null) {
					current.next[index] = new TrieNode();
				}
				current.next[index].c = word.charAt(i);
				current = current.next[index];
			}
			current.endOfWord = true;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			if(word == null || word.length() == 0) {
				return false;
			}

			TrieNode current = root;
			int length = word.length();
			int index = 0;
			for(int i = 0; i < length; ++i) {
				index = word.charAt(i) - 'a';
				if(current.next[index] == null) {
					return false;
				}
				current = current.next[index];
			}
			return current.endOfWord;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			if(prefix == null || prefix.length() == 0) {
				return false;
			}

			TrieNode current = root;
			int length = prefix.length();
			int index = 0;
			for(int i = 0; i < length; ++i) {
				index = prefix.charAt(i) - 'a';
				if(current.next[index] == null) {
					return false;
				}
				current = current.next[index];
			}
			return true;
		}
	}

	public static void main(String[] args) {
		WordSearch1 ws = new WordSearch1();
		char[][] board = {{'a','b','c','e'},
				{'s','f','c','s'},
				{'a','d','e','e'}};
		String[] words = {"abcced", "see", "abcb"};

		System.out.println("The words that exist in the board are?");
		List<String> result = ws.exist(board, words);
		System.out.println(result);
	}

	public List<String> exist(char[][] board, String[] words) {	
		List<String> result = new ArrayList<>();
		if(words == null || words.length == 0) {
			return result;
		}

		Trie root = new Trie();
		for(String word: words) {
			root.insert(word);
		}

		int row = board.length;
		int col = board[0].length;
		boolean[][] visited = new boolean[row][col];

		for(int i = 0; i < row; ++i) {
			for(int j = 0; j < col; ++j) {
				searchBoard(board, i, j, root, "", visited, result);
			}
		}
		return result;
	}

	public void searchBoard(char[][] board, int i, int j, Trie node, String s, boolean[][] visited, List<String> result) {
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
			return;
		}

		s += board[i][j];
		if(!node.startsWith(s)) {
			return;
		}

		if(node.search(s)) {
			result.add(s);
		}

		visited[i][j] = true;
		searchBoard(board, i + 1, j, node, s, visited, result);
		searchBoard(board, i, j + 1, node, s, visited, result);
		searchBoard(board, i - 1, j, node, s, visited, result);
		searchBoard(board, i, j - 1, node, s, visited, result);
		visited[i][j] = false;
	}
}
