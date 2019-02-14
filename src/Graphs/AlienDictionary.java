package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class AlienDictionary {
    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("The characters in lexicograhical orders are := " + alienDictionary.alienOrder(words));

        words = new String[]{"z", "x", "z"};
        System.out.println("The characters in lexicograhical orders are := " + alienDictionary.alienOrder(words));

        words = new String[]{"z", "z"};
        System.out.println("The characters in lexicograhical orders are := " + alienDictionary.alienOrder(words));

        words = new String[]{"x", "ab", "adc", "e"};
        System.out.println("The characters in lexicograhical orders are := " + alienDictionary.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        HashSet<Integer>[] edges = new HashSet[26];
        Set<Character> chars = new HashSet<>();
        int[] in = new int[26];
        int max = Integer.MIN_VALUE;
        char prev, cur;
        int node;

        for (String s : words) {
            max = Math.max(max, s.length());
            for (char c : s.toCharArray()) chars.add(c);
        }

        for (int index = 0; index < max; ++index) {
            for (int j = 1; j < words.length; ++j) {
                if (words[j].length() > index && words[j - 1].length() > index &&
                        (index == 0 || words[j].charAt(index - 1) == words[j - 1].charAt(index - 1))) {
                    prev = words[j - 1].charAt(index);
                    cur = words[j].charAt(index);
                    if (prev != cur) {
                        if (edges[prev - 'a'] == null) edges[prev - 'a'] = new HashSet<>();
                        if (edges[prev - 'a'].add(cur - 'a'))
                            in[cur - 'a']++;
                    }
                }
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (char c : chars) {
            if (in[c - 'a'] == 0) dq.offer(c - 'a');
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            node = dq.poll();
            sb.append((char) (node + 'a'));
            if (edges[node] != null) {
                for (int n : edges[node]) {
                    in[n]--;
                    if (in[n] == 0) dq.offer(n);
                }
            }
        }

        return sb.toString().length() == 0 || sb.toString().length() != chars.size() ? "" : sb.toString();
    }
}
