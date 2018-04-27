package DataStructureImplementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReplaceWords {
    static class TrieNode {
        private TrieNode[] next;
        private boolean isWord;
        private char c;

        public TrieNode(char c) {
            this.c = c;
            isWord = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root = new TrieNode('*');

    public void insert(TrieNode node, String word) {
        if (node == null) {
            node = new TrieNode('*');
        }

        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode(c);
            }
            node = node.next[c - 'a'];
        }

        node.isWord = true;
    }

    private String tokenize(TrieNode node, String token) {
        StringBuilder sb = new StringBuilder();
        int length = token.length();
        char c;

        for (int i = 0; i < length; ++i) {
            c = token.charAt(i);
            sb.append(c);

            if (node != null && node.next[c - 'a'] != null && node.next[c - 'a'].isWord) break;

            node = node == null ? null : node.next[c - 'a'];
        }

        return sb.toString();
    }

    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0) {
            return sentence;
        }

        dict.forEach(word -> insert(root, word));
        StringBuilder sb = new StringBuilder();
        Stream.of(sentence.split("\\s+"))
                .forEach(token -> sb.append(tokenize(root, token)).append(' '));

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new ReplaceWords().replaceWords(dict, sentence));
    }
}
