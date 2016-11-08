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
            } else if(stack.isEmpty()) {
                return false;
            } else if(stack.peekLast() != map.get(c)) {
                return false;
            } else {
                stack.pollLast();
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
