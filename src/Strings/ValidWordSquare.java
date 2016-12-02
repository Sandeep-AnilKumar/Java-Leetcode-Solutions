package Strings;

import java.util.ArrayList;
import java.util.List;

public class ValidWordSquare {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("abcd");
        words.add("bnrt");
        words.add("crm");
        words.add("dt");

        System.out.println("Is this a valid word square? := " + validWordSquare(words));
    }

    public static boolean validWordSquare(List<String> words) {
        int size = words.size();
        String cur = "";
        int index = 0;
        String builder = "";
        for(int i = 0; i < size; ++i) {
            cur = words.get(i);

            if(cur.length() > size) {
                return false;
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; ++j) {
                builder = words.get(j);
                if(builder.length() > index) {
                    sb.append(builder.charAt(index));
                }
            }
            if(!cur.equals(sb.toString())) {
                return false;
            }
            index++;
        }
        return true;
    }

    //A better understanding code.
    public static boolean validWordSquareBetter(List<String> words) {
        if (words.size() == 0 || words == null) return true;
        int n = words.size();
        for (int i = 0; i < n; i++) {
            String tmp = words.get(i);
            for (int j = 0; j < tmp.length(); j++) {
                // too long
                if (j >= n)
                    return false;
                // too short
                if (words.get(j).length() <= i)
                    return false;
                // letter not equal
                if (tmp.charAt(j) != words.get(j).charAt(i))
                    return false;
            }
        }
        return true;
    }
}
