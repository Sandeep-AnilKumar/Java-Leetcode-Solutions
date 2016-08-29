package Strings;

public class Trie {
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
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current.children[index].c = word.charAt(i);
            current = current.children[index];
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
            if(current.children[index] == null) {
                return false;
            }
            current = current.children[index];
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
            if(current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("beach");
        tr.insert("bean");
        System.out.println(tr.search("beans"));
        System.out.println(tr.startsWith("be"));
    }
}