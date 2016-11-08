package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    private static void recurse(List<String> res, String present, int left, int right) {
        if (right == 0) {
            res.add(present);
        }
        if (left > 0) {
            recurse(res, present + "(", left - 1, right);
        }
        if (right > left) {
            recurse(res, present + ")", left, right - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        recurse(res, "", n, n);
        return res;
    }

    //Using StringBuilder.

    public static List<String> generateParenthesisStringBuilder(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0) {
            return result;
        }

        recurse(result, new StringBuilder(), n, n);
        return result;
    }

    public static void recurse(List<String> result, StringBuilder sb, int left, int right) {
        if(right == 0) {
            result.add(sb.toString());
            return;
        }
        if(left > 0) {
            recurse(result, sb.append("("), left - 1, right);
            sb.setLength(Math.max(sb.length() - 1, 0));
        }
        if(right > left) {
            recurse(result, sb.append(")"), left, right - 1);
            sb.setLength(Math.max(sb.length() - 1, 0));
        }
    }
}
