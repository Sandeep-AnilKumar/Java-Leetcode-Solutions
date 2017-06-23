package Strings;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
	static TrieDS root;
	class TrieDS {
		char c;
		TrieDS[] next;
		List<String> ws;

		public TrieDS() {
			this.c = '0';
			next = new TrieDS[26];
			ws = new ArrayList<>();
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for(String s: ws) {
				sb.append(s + ", ");
			}
			return c + " { " + sb.toString() + " } ";
		}
	}

	public static void main(String[] args) {
		WordSquares ws = new WordSquares();
		root = ws.new TrieDS();
		root.c = '$';
		String[] words = {"ball", "lady", "lead", "wall", "area"};
		System.out.println("The word squares formed are := ");
		List<List<String>> squares = ws.wordSquares(words);
		System.out.println(squares);
	}

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> squares = new ArrayList<>();
		if(words == null || words.length == 0) {
			return squares;
		}

		int length = words[0].length();
		for(String word: words) {
			buildTrie(word);
		}

		findSquares(words, squares, length, new ArrayList<>());
		return squares;
	}

	public void findSquares(String[] words, List<List<String>> squares, int length, List<String> cur) {
		if(cur.size() == length) {
			squares.add(new ArrayList<>(cur));
			return;
		}

		StringBuffer sb = new StringBuffer();
		int index = cur.size();
		for(String s: cur) {
			sb.append(s.charAt(index));
		}

		char[] toFind = sb.toString().toCharArray();
		TrieDS curNode = root;
		int count = 0;
		int i = 0;

		if(toFind.length > 0) {
			while(curNode != null && i < toFind.length) {
				if(curNode.next[toFind[i] - 'a'] == null) {
					break;
				}
				curNode = curNode.next[toFind[i++] - 'a'];
				count++;
			}
			if(count == toFind.length) {
				for(String w: curNode.ws) {
					cur.add(w);
					findSquares(words, squares, length, cur);
					cur.remove(cur.size() - 1);
				}
			}
		} else {
			for(String word: words) {
				cur.add(word);
				findSquares(words, squares, length, cur);
				cur.remove(cur.size() - 1);
			}
		}
		return;
	}

	public void buildTrie(String word) {
		if(word == null || word.length() == 0) {
			return;
		}

		char[] array = word.toCharArray();
		TrieDS node = root;
		node.ws.add(word);

		for(char c: array) {
			if(node.next[c - 'a'] == null) {
				node.next[c - 'a'] = new TrieDS();
			}
			node.next[c - 'a'].c = c;
			node.next[c - 'a'].ws.add(word);
			node = node.next[c - 'a'];
		}
		return;
	}
}
