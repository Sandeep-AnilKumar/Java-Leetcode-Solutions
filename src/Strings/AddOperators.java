package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class AddOperators {

    public static void main(String[] args) {
        String num = "105";
        int target = 5;
        System.out.println("The addition of operators to numbers that yeild the target are := ");
        System.out.println(new AddOperators().addOperators(num, target));
    }

    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if(num == null || num.length() <= 1) {
            return list;
        }

        String s = num.charAt(0) + "";
        addOperators(num, target, list, 1, Integer.parseInt(s), Integer.parseInt(s), s);
        return list;
    }

    public void addOperators(String num, int target, List<String> list, int index, int curSum, int prev, String s) {
        if(index == num.length()) {
            if(curSum == target) {
                list.add(s);
            }
            return;
        }

        int cur = num.charAt(index) - '0';
        for(; index < num.length(); index++) {
            addOperators(num, target, list, index + 1, curSum * 10 + cur, cur, s + "" + cur);
            addOperators(num, target, list, index + 1, curSum + cur, cur, s + "+" + cur);
            addOperators(num, target, list, index + 1, (prev * cur) + (curSum - prev), cur, s + "*" + cur);
            addOperators(num, target, list, index + 1, curSum - cur, cur, s + "-" + cur);
        }
    }
}
