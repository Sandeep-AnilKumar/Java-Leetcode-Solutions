package Strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{}[]{([])}[}";
        System.out.println("Is '" + s + "' a valid parentheses := " + isValid(s));
    }

    public static boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for(char c : s.toCharArray()) {
            if(c == '{' || c == '[' || c == '(') {
                stack.offerLast(c);
            } else if(stack.isEmpty() || stack.pollLast() != map.get(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    //A better solution without using stack.
    public static boolean isValidBetter(String s) {
        char[] right = {')', '}', ']'};
        String left = "({[";
        int[] stack = new int[s.length()];
        int head = 0; 
        for(char c : s.toCharArray()) {
            int rIdx = left.indexOf(c);
            if(rIdx != -1) {
                stack[head++] = rIdx;
                continue;
            }
            if (head == 0 || c != right[stack[--head]]) {
                return false;
            }
        }
        return head == 0;
    }
}
