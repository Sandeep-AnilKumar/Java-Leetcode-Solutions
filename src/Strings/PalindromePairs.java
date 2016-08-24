package Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {

    public static void main(String[] args) {
        String[] words = new String[]{"lls","s","sssll","abcd","dcba"};
        List<List<Integer>> result = findPalindromePairs(words);

        for(List<Integer> indices : result) {
            System.out.println(indices);
        }
    }

    public static List<List<Integer>> findPalindromePairs(String[] words) {
        if(words == null || words.length == 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        return result;
    }
}
