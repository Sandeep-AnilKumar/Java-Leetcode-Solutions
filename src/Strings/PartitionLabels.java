package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PartitionLabels {
    class CharInterval implements Comparable<CharInterval> {
        int start;
        int end;

        public CharInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(CharInterval other) {
            if (this.start != other.start) return this.start - other.start;
            return this.end - other.end;
        }
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> sizes = new ArrayList<>();
        int[] start = new int[26];
        int[] end = new int[26];
        Set<CharInterval> set = new TreeSet<>();
        List<CharInterval> intervals = new ArrayList<>();
        CharInterval prev = null;
        int length = S.length();
        char ch;
        Arrays.fill(start, -1);

        for (int i = 0; i < length; ++i) {
            ch = S.charAt(i);
            if (start[ch - 'a'] == -1) {
                start[ch - 'a'] = i;
            }
            end[ch - 'a'] = i;
        }

        for (int i = 0; i < 26; ++i) {
            if (start[i] != -1) {
                set.add(new CharInterval(start[i], end[i]));
            }
        }

        for (CharInterval cur : set) {
            if (prev != null && cur.start < prev.end) {
                prev.end = Math.max(prev.end, cur.end);
            } else {
                intervals.add(cur);
                prev = cur;
            }
        }

        for (CharInterval interval : intervals) sizes.add(interval.end - interval.start + 1);

        return sizes;
    }
    
    public static void main(String[] args) {
        String s = "ababababcdefgdeffgdhijhlki";
		System.out.println("The string canShip be partitioned at lengths := " + new PartitionLabels().partitionLabels(s));
    }
}
