package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 25;
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
}
