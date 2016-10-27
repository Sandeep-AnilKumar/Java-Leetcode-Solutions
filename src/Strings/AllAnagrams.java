package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagrams {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    //Very complicated Code.
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }
        if(p == null || p.length() == 0) {
            result.add(0);
            return result;
        }
        List<List<Character>> anagrams = new ArrayList<>();
        getAnagrams(p.toCharArray(), 0, anagrams, p.length() - 1);

        StringBuilder sb = new StringBuilder();
        int index = 0;
        String temp = "";
        for(List<Character> anagram : anagrams) {
            sb = new StringBuilder();
            for(char c : anagram) {
                sb.append(c);
            }
            temp = sb.toString();
            index = s.indexOf(temp);
            while(index >= 0) {
                if(!result.contains(index)) {
                    result.add(index);
                    index = s.indexOf(temp, index + 1);
                }
            }
        }
        return result;
    }

    public static void getAnagrams(char[] p, int start, List<List<Character>> result, int end) {
        if(start == end) {
            Character[] anaChars = new Character[p.length];
            for(int i = 0; i < p.length; ++i) {
                anaChars[i] = p[i];
            }
            result.add(Arrays.asList(anaChars));
        } else {
            for(int i = start; i <= end; ++i) {
                swap(p, i, start);
                getAnagrams(p, start + 1, result, end);
                swap(p, i, start);
            }
        }
        return;
    }

    public static void swap(char[] p, int start, int end) {
        char temp = p[start];
        p[start] = p[end];
        p[end] = temp;
    }
    
    //Easy version.
    
}
