package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDNASequences1(s));
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
            if(!result.contains(temp)) {
                j = i + 1;
                while(j < i + 10) {
                    if(s.indexOf(temp, j) >= 0) {
                        result.add(temp);
                        i = j - 1;
                        break;
                    }
                    j++;
                }
            }
        }
        return result;
    }

    //Easier solution.
    public static List<String> findRepeatedDNASequences1(String s) {
        if(s == null || s.length() <= 10) {
            return new ArrayList<String>();
        }

        Set<String> resultSet = new HashSet<>();
        Set<String> tempSet = new HashSet<>();
        int length = s.length();
        String temp = "";
        for(int i = 0; i <= length - 10; ++i) {
            temp = s.substring(i, i + 10);
            if(tempSet.contains(temp)) {
                resultSet.add(temp);
            } else {
                tempSet.add(temp);
            }
        }
        return new ArrayList<String>(resultSet);
    }
}
