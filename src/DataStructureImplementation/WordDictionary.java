package DataStructureImplementation;

class WordDictionary {


    static class TrieNode {
        private TrieNode[] next;
        private boolean isWord;
        private char c;

        public TrieNode(char c) {
            this.c = c;
            next = new TrieNode[26];
            isWord = false;
        }
    }

    static class Trie {
        public void insert(TrieNode node, String word) {
            if (node == null) {
                node = new TrieNode('*');
            }

            for(char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode(c);
                }
                node = node.next[c - 'a'];
            }

            node.isWord = true;
        }
    }

    private TrieNode root;
    private Trie trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('*');
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(root, word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, TrieNode node) {
        if (index == word.length()) return node != null && node.isWord;

        int length = word.length();
        char c;

        if (node == null) {
            return false;
        }

        for (int i = index; i < length; ++i) {
            c = word.charAt(i);

            if (c != '.') {
                if (node == null || node.next[c - 'a'] == null) {
                    return false;
                }

                if (i == length - 1) {
                    return node.next[c - 'a'].isWord;
                }

                node = node.next[c - 'a'];

            } else {
                for (int j = 0; j < 26; ++j) {
                    if (node != null && node.next[j] != null && search(word, i + 1, node.next[j])) {
                        return true;
                    }
                }

                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        System.out.println(dictionary.search("b.."));
        System.out.println(dictionary.search("b.d"));
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search("b.e"));
        System.out.println(dictionary.search("bd."));
        System.out.println(dictionary.search("bde"));
        System.out.println(dictionary.search("bae"));
        System.out.println(dictionary.search("bads"));
        dictionary.addWord("a");
        System.out.println(dictionary.search("."));
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search("aa"));
        System.out.println(dictionary.search(".a"));
        System.out.println(dictionary.search("a."));
    }
}
