package Strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String s = "svsbbascdba";
        System.out.println("After removing duplicates the string is: " + removeDuplicateLetters(s));
    }


    public static String removeDuplicateLetters(String s) {

        if(s == null || s.length() <= 1) {
            return s;
        }

        Deque<Character> dq = new ArrayDeque<>();
        int[] count = new int[26];
        int length = s.length();
        for(int i = 0; i < length; ++i) {
            count[s.charAt(i)-'a']++;
        }
        char temp, c;
        boolean[] visited = new boolean[26];
        for(int i = 0; i < length; ++i) {
            c = s.charAt(i);
            count[c-'a']--;
            if(visited[c-'a']) {
                continue;
            }
            while(!dq.isEmpty() && ((temp = dq.peekLast()) > c) && count[temp- 'a'] > 0) {
                visited[temp-'a'] = false;
                dq.pollLast();
            }
            dq.offerLast(c);
            visited[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char i : dq) {
            sb.append(i);
        }
        return sb.toString();
    }


}
