package DataStructureImplementation;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class MagicDictionary {

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

        public boolean search(TrieNode node, String word) {
            if (node == null) {
                return false;
            }

            for(char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    return false;
                }
                node = node.next[c - 'a'];
            }

            return node.isWord;
        }
    }

    private TrieNode root;
    private Trie trie;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode('*');
        trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        Stream.of(dict).forEach(word -> trie.insert(root, word));
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode node = root;
        if (node == null) {
            return false;
        }

        int length = word.length();
        StringBuilder sb = new StringBuilder();
        String curWord;
        String toSearch;
        char c;
        for (int i = 1; i <= length; ++i) {
            c = word.charAt(i - 1);
            for (int j = 0; j < 26; ++j) {
                toSearch = Character.toString((char)(97 + j)) + word.substring(i);
                curWord = sb.toString() + toSearch;
                if (node != null && node.next[j] != null && trie.search(node, toSearch) && !curWord.equals(word)) {
                    return true;
                }
            }
            sb.append(c);
            node = node == null ? null : node.next[c - 'a'];
        }

        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magic = new MagicDictionary();
        magic.buildDict(new String[]{"hello", "hallo", "leetcode"});
        System.out.println(magic.search("hello"));
        System.out.println(magic.search("hhllo"));
        System.out.println(magic.search("hallo"));
        System.out.println(magic.search("leetcode"));
        System.out.println(magic.search("leetcoded"));
        System.out.println(magic.search("leetdode"));
        System.out.println(magic.search("leetcodd"));

    }
}