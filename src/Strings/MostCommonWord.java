package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        buildMap(paragraph, map, bannedSet);
        return map.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
    }

    private void buildMap(String paragraph, Map<String, Integer> map, Set<String> bannedSet) {
        Set<Character> punctuations = new HashSet<>(Arrays.asList('!', '?', '\'', ',', ';', '.'));
        for (String word : paragraph.split("\\s+")) {
            word = word.toLowerCase();
            word = removePunctuations(word, punctuations);
            if (!bannedSet.contains(word)) map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    private String removePunctuations(String word, Set<Character> punctuations) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!punctuations.contains(c)) sb.append(c);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println("The most common word is := " + new MostCommonWord().mostCommonWord(paragraph, banned));
    }
}
