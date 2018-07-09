package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity2 {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Integer> wordToId = new HashMap<>();
        DSU dsu = new DSU();
        Map<Integer, Set<String>> components = new HashMap<>();
        int id = 0;
        int index;
        boolean found;
        for (String[] pair : pairs) {
            if (!wordToId.containsKey(pair[0])) {
                wordToId.put(pair[0], id++);
            }

            if (!wordToId.containsKey(pair[1])) {
                wordToId.put(pair[1], id++);
            }

            dsu.union(wordToId.get(pair[0]), wordToId.get(pair[1]));
        }

        for (String word : words1) {
            if (wordToId.containsKey(word)) {
                index = dsu.find(wordToId.get(word));
                components.computeIfAbsent(index, x -> new HashSet<>());
                components.get(index).add(word);
            }
        }

        for (String word : words2) {
            if (wordToId.containsKey(word)) {
                index = dsu.find(wordToId.get(word));
                components.computeIfAbsent(index, x -> new HashSet<>());
                components.get(index).add(word);
            }
        }

        for (int i = 0; i < words1.length; ++i) {
            found = false;
            for (Set<String> similar : components.values()) {
                if (similar.contains(words1[i]) && similar.contains(words2[i])) found = true;
            }

            if (!found && !words1[i].equals(words2[i])) return false;
        }

        return true;
    }

    class DSU {
        int parent[] = new int[1001];

        DSU() {
            for (int i = 0; i < 1001; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public static void main(String[] args) {
        SentenceSimilarity2 sentenceSimilarity2 = new SentenceSimilarity2();
        String[] words1 = {"I","have","enjoyed","happy","thanksgiving","holidays"};
        String[] words2 = {"I","have","enjoyed","happy","thanksgiving","holidays"};
        String[][] pairs = {
                {"great","good"},{"extraordinary","good"},{"well","good"},{"wonderful","good"},{"excellent","good"},
                {"fine","good"},{"nice","good"},{"any","one"},{"some","one"},{"unique","one"},{"the","one"},{"an","one"},
                {"single","one"},{"a","one"},{"truck","car"},{"wagon","car"},{"automobile","car"},{"auto","car"},
                {"vehicle","car"},{"entertain", "have"},{"drink","have"},{"eat","have"},{"take","have"},
                {"fruits","meal"},{"brunch","meal"},{"breakfast","meal"},{"food","meal"},{"dinner","meal"},
                {"super","meal"},{"lunch","meal"},{"possess","own"},{"keep","own"},{"have","own"},
                {"extremely","very"},{"actually","very"},{"really","very"},{"super","very"}};
        System.out.println("Are sentences similar? := " + sentenceSimilarity2.areSentencesSimilarTwo(words1, 
                words2, pairs));
    }
}
