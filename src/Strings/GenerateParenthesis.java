package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> p = new ArrayList<>();
        if (n <= 0) return p;
        generateParenthesis(p, n, new ArrayList<>(), 0, 0);
        return p;
    }

    private void generateParenthesis(List<String> p, int n, List<Character> cur, int close, int index) {
        if (n == index) {
            String s = cur.stream().map(String::valueOf).collect(Collectors.joining());
            while(--close >= 0) {
                s += ")";
            }
            if (!p.contains(s)) p.add(s);
            return;
        }

        List<Character> temp = new ArrayList<>(cur);
        temp.add('(');
        close++;
        generateParenthesis(p, n, temp, close, index + 1);
        temp.remove(temp.size() - 1);
        close--;
        if (close > 0) {
            while(--close >= 0) {
                temp.add(')');
                generateParenthesis(p, n, temp, close, index);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("The parenthesis pairs are := \n" + new GenerateParenthesis().generateParenthesis(n));
    }
}
