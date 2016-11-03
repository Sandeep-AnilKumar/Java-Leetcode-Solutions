package Strings;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FrequencySort {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println("Word after frequency sort is :" + frequencySort(s));
    }

    public static String frequencySort(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        int length = s.length();
        int[] map = new int[256];
        Set<Character> set = new HashSet<>();
        char temp;
        for(int i = 0; i < length; ++i) {
            temp = s.charAt(i);
            map[temp]++;
            set.add(temp);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>((a,b) -> (b.f - a.f));
        for(int i = 0; i < length; ++i) {
            temp = s.charAt(i);
            if(set.contains(temp)) {
                Freq fq = new Freq(temp, map[temp]);
                pq.offer(fq);
                set.remove(temp);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Freq fq = pq.poll();
            int count = fq.f;
            while(count-- > 0) {
                sb.append(fq.c);
            }
        }
        return sb.toString();
    }

    static class Freq {
        char c;
        int f;
        Freq(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }
}
