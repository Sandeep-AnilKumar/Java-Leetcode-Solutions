package DataStructureImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class AutocompleteSystem {

    class HotSentence implements Comparable<HotSentence> {
        private String sentence;
        private int hotness;


        public String getSentence() {
            return sentence;
        }

        public int getHotness() {
            return hotness;
        }

        public HotSentence(String sentence, int hotness) {
            this.sentence = sentence;
            this.hotness = hotness;
        }

        @Override
        public int compareTo(HotSentence other) {
            if (hotness == other.hotness) {
                return sentence.compareTo(other.sentence);
            }

            return other.hotness - hotness;
        }

        @Override
        public boolean equals(Object o) {

            if (o == this) return true;
            if (!(o instanceof HotSentence)) {
                return false;
            }

            HotSentence other = (HotSentence) o;

            return other.getSentence().equals(sentence) &&
                    other.getHotness() == hotness;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + sentence.hashCode();
            result = 31 * result + hotness;
            return result;
        }
    }

    private Map<String, Set<HotSentence>> map = new HashMap<>();
    private Set<String> dictionary = new HashSet<>();
    private StringBuilder sb = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; ++i) {
            dictionary.add(sentences[i]);
            insert(sentences[i], times[i]);
        }
    }

    public void insert(String sentence, int times) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < sentence.length(); ++j) {
            builder.append(sentence.charAt(j));
            map.putIfAbsent(builder.toString(), new TreeSet<>());
            map.get(builder.toString()).add(new HotSentence(sentence, times));
        }
    }

    public void remove(String sentence, int count) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < sentence.length(); ++i) {
            builder.append(sentence.charAt(i));
            if (map.containsKey(builder.toString()) && map.get(builder.toString()) != null) {
                map.get(builder.toString()).remove(new HotSentence(sentence, count));
            }
        }
    }

    public List<String> input(char c) {
        List<String> hotSentences = new ArrayList<>();
        Set<HotSentence> curSet;
        int count = 0;
        String cur;
        if (c == '#') {
            cur = sb.toString();
            if (dictionary.contains(cur)) {
                curSet = map.get(cur);
                for (HotSentence hs : curSet) {
                    if (hs.getSentence().equals(cur)) {
                        count = hs.getHotness();
                    }
                }
            } else {
                dictionary.add(cur);
            }

            remove(cur, count);
            insert(cur, count + 1);
            sb = new StringBuilder();
            return hotSentences;
        }

        sb.append(c);
        curSet = map.get(sb.toString());

        if (curSet != null) {
            for (HotSentence s : curSet) {
                if (count == 3) break;
                hotSentences.add(s.sentence);
                count++;
            }
        }

        return hotSentences;
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem auto = new AutocompleteSystem(sentences, times);
        System.out.println(auto.input('i'));
        System.out.println(auto.input(' '));
        System.out.println(auto.input('a'));
        System.out.println(auto.input('#'));
        System.out.println(auto.input('i'));
        System.out.println(auto.input(' '));
        System.out.println(auto.input('a'));
        System.out.println(auto.input('#'));
        System.out.println(auto.input('i'));
        System.out.println(auto.input(' '));
        System.out.println(auto.input('a'));
        System.out.println(auto.input('#'));
        System.out.println(auto.input('i'));
        System.out.println(auto.input(' '));
        System.out.println(auto.input('a'));
        System.out.println(auto.input('#'));
    }
}
