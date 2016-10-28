package Strings;

import java.util.ArrayList;
import java.util.List;

public class RepeatedDNASequence {

    public static void main(String[] args) {
        String s = "AAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }

    //TLE version, Brute Force.
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() <= 9) {
            return result;
        }
        if(s.length() == 10) {
            return result;
        }

        int length = s.length();
        String temp = "";
        int j = 0;
        for(int i = 0; i + 10 < length; ++i) {
            temp = s.substring(i, i + 10);
            j = i + 1;
            while(j < i + 10) {
                if(s.indexOf(temp, j) >= 0 && !result.contains(temp)) {
                    result.add(temp);
                }
                j++;
            }
        }
        return result;
    }
}
