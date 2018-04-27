package Strings;

public class LongestWord {
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
                if (node.next[c - 'a'] == null || !node.next[c - 'a'].isWord) {
                    return false;
                }
                node = node.next[c - 'a'];
            }

            return true;
        }
    }

    private TrieNode root = new TrieNode('*');
    private Trie trie = new Trie();

    public String longestWord(String[] words) {
        for(String word : words) trie.insert(root, word);

        int max = Integer.MIN_VALUE;
        String longest = "";
        int length = 0;

        for(String word : words) {
            if (trie.search(root, word)) {
                length = word.length();
                if (length == max) {
                    longest = word.compareTo(longest) < 0 ? word : longest;
                } else if (length > max) {
                    max = length;
                    longest = word;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new LongestWord().longestWord(words));
    }
}
