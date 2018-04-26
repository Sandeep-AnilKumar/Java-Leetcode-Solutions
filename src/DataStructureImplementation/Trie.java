package DataStructureImplementation;

public class Trie {

    static class TrieNode {
        char c;
        TrieNode[] map;
        boolean isWord = false;
        int count;

        TrieNode(char c) {
            this.c = c;
            map = new TrieNode[26];
            count = 0;
        }
    }

    private TrieNode node;
    /** Initialize your data structure here. */
    public Trie() {
        node = new TrieNode('*');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = node;
        for (char c : word.toCharArray()) {
            if (cur.map[c - 'a'] == null) {
                cur.map[c - 'a'] = new TrieNode(c);
            }

            cur = cur.map[c - 'a'];
            cur.count++;
        }

        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = node;

        for (char c : word.toCharArray()) {
            if (cur.map[c - 'a'] == null) {
                return false;
            }

            cur = cur.map[c - 'a'];
        }

        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = node;

        for (char c : prefix.toCharArray()) {
            if (cur.map[c - 'a'] == null) {
                return false;
            }

            cur = cur.map[c - 'a'];
        }

        return true;
    }

    /** Returns the number of words in the trie that starts with the given prefix. */
    public int countStartsWith(String prefix) {
        TrieNode cur = node;

        for (char c : prefix.toCharArray()) {
            if (cur.map[c - 'a'] == null) {
                return 0;
            }

            cur = cur.map[c - 'a'];
        }

        return cur.count;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("based");
        System.out.println(trie.search("base"));
        System.out.println(trie.startsWith("base"));
        System.out.println(trie.countStartsWith("base"));
        trie.insert("baseball");
        System.out.println(trie.countStartsWith("base"));
        System.out.println(trie.search("ball"));
        trie.insert("leetcode");
        System.out.println(trie.startsWith("lee"));
        System.out.println(trie.countStartsWith("lee"));
    }
}
