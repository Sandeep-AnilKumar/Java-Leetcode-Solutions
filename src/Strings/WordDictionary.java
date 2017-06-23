package Strings;

public class WordDictionary {
	private TrieNode root;
	public WordDictionary() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		if(word == null || word.length() == 0) {
			return;
		}
		TrieNode node = root;
		char[] array = word.toCharArray();
		for(char c: array) {
			if(node.next[c - 'a'] == null) {
				node.next[c - 'a'] = new TrieNode();
			}
			node.next[c - 'a'].c = c;
			node = node.next[c - 'a'];
		}
		node.endOfWord = true;
		return;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		if(word == null || word.length() == 0) {
			return false;
		}

		TrieNode node = root;
		char[] array = word.toCharArray();
		char c;
		for(int i = 0; i < array.length; ++i) {
			c = array[i];
			if(c != '.') {
				if(node.next[c - 'a'] == null) {
					return false;
				}
				node = node.next[c - 'a'];
			} else {
				return search(word, i, node);
			}
		}
		return node.endOfWord;
	}

	public boolean search(String word, int index, TrieNode node) {
		if(index < word.length() && word.charAt(index) != '.' && node.next[word.charAt(index) - 'a'] == null) {
			return false;
		}

		if(index == word.length()) {
			return node.endOfWord;
		}

		if(index > word.length()) {
			return false;
		}

		if(word.charAt(index) == '.') {
			for(int i = 0; i < 26; ++i) {
				if(node.next[i] != null) {
					if(search(word, index + 1, node.next[i])) {
						return true;
					}
				}
			}
		} else {
			return search(word, index + 1, node.next[word.charAt(index) - 'a']);
		}
		return false;
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("band");
		wordDictionary.addWord("bag");
		System.out.println("\nWord 'b' present in dictionary? " + wordDictionary.search("b"));
		System.out.println("\nWord 'b..' present in dictionary? " + wordDictionary.search("b.."));
		System.out.println("\nWord 'b.d' present in dictionary? " + wordDictionary.search("b.d"));
		System.out.println("\nWord 'b...' present in dictionary? " + wordDictionary.search("b..."));
		System.out.println("\nWord 'b..g' present in dictionary? " + wordDictionary.search("b..g"));
		System.out.println("\nWord '.' present in dictionary? " + wordDictionary.search("."));
		System.out.println("\nWord 'b....' present in dictionary? " + wordDictionary.search("b...."));
		System.out.println("\nWord 'b.n.' present in dictionary? " + wordDictionary.search("b.n."));
		System.out.println("\nWord '....' present in dictionary? " + wordDictionary.search("...."));
	}
}
