package Strings;

public class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
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
        System.out.println("Word '" + word + "' added to dictionary");
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }

        if(!word.contains(".")) {
            int length = word.length();
            int index = 0;
            TrieNode current = root;

            for(int i = 0; i < length; ++i) {
                index = word.charAt(i) - 'a';
                if(current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return current.endOfWord;
        }
        else return search(word, 0, root, false);
    }

    public static boolean search(String word, int pos, TrieNode root, boolean result) {
        if(pos < word.length() && word.charAt(pos) != '.' && root.children[word.charAt(pos) - 'a'] == null) {
            return false;
        }

        if(pos == word.length()) {
            return root.endOfWord;
        }

        if(pos > word.length()) {
            return false;
        }

        char c = word.charAt(pos);
        if(c == '.') {
            for(int i = 0; i < 26 && !result; ++i) {
                if(root.children[i] != null) {
                    result = search(word, pos + 1, root.children[i], result);
                }
            }
        }
        else {
            result = search(word, pos + 1, root.children[word.charAt(pos) - 'a'], result);
        }
        return result;
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
