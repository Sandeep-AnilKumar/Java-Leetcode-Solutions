package Strings;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return 0;
        if (word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0) return 0;

        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();

        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                index1.add(i);
            } else if (words[i].equals(word2)) {
                index2.add(i);
            }
        }
        return minDiff(index1, index2);
    }

    private int minDiff(List<Integer> index1, List<Integer> index2) {
        if (index1 == null || index1.size() == 0 || index2 == null || index2.size() == 0) return 0;

        int i = 0, j = 0;
        int size1 = index1.size(), size2 = index2.size();
        int minDiff = Integer.MAX_VALUE;

        while (i < size1 && j < size2) {
            minDiff = Math.min(minDiff, Math.abs(index1.get(i) - index2.get(j)));
            if (minDiff == 1) return minDiff;

            if (index1.get(i) > index2.get(j)) {
                j++;
            } else {
                i++;
            }
        }

        while (i < size1) {
            minDiff = Math.min(minDiff, Math.abs(index1.get(i++) - index2.get(size2 - 1)));
        }

        while (j < size2) {
            minDiff = Math.min(minDiff, Math.abs(index1.get(size1 - 1) - index2.get(j++)));
        }

        return minDiff;
    }
    
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "practice";
        String word2 = "coding";
        System.out.println("The minimum distance between two strings is := " + new ShortestWordDistance().
                shortestDistance(words, word1, word2));
    }
}
