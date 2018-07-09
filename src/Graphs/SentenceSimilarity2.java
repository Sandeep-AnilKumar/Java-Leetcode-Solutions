package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity2 {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        Map<String, Integer> wordToId = new HashMap<>();
        DSU dsu = new DSU(2 * pairs.length);
        int id = 0;
        
        for (String[] pair : pairs) {
            for (String p : pair) {
                if (!wordToId.containsKey(p)) {
                    wordToId.put(p, id++);
                }
            }

            dsu.union(wordToId.get(pair[0]), wordToId.get(pair[1]));
        }
        
        for (int i = 0; i < words1.length; ++i) {
            if (words1[i].equals(words2[i])) continue;
            
            if (!wordToId.containsKey(words1[i]) || !wordToId.containsKey(words2[i]) || 
                    dsu.find(wordToId.get(words1[i])) != dsu.find(wordToId.get(words2[i]))) return false;
        }
        
        return true;
    }

    class DSU {
        int parent[];

        DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; ++i) {
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
