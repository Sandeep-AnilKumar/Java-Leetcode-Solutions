package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

    public static void main(String[] args) {
        String[] words = new String[]{"lls","s","sssll","abcd","dcba"};
        List<List<Integer>> result = findPalindromePairs(words);

        for(List<Integer> indices : result) {
            System.out.println(indices);
        }
    }


    public static List<List<Integer>> findPalindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0) {
            return result;   
        }

        Map<String, Integer> wordMap = new HashMap<>();
        int i = 0;
        for(String word : words) {
            wordMap.put(word,i++);
        }

        int length = 0;
        i = 0;
        String str1, str2, reverseStr;
        List<Integer> indices = new ArrayList<Integer>();
        for(String word : words) {
            length = word.length();
            for(int j = 0; j <= length; ++j) {
                str1 = word.substring(0,j);
                str2 = word.substring(j);

                if(isPalindrome(str1)) {
                    reverseStr = reverseString(str2);
                    if(wordMap.containsKey(reverseStr) && wordMap.get(reverseStr) != i) {
                        indices = new ArrayList<>();
                        indices.add(wordMap.get(reverseStr));
                        indices.add(i);
                        result.add(indices);
                    }
                }

                if(isPalindrome(str2)) {
                    reverseStr = reverseString(str1);
                    if(wordMap.containsKey(reverseStr) && wordMap.get(reverseStr) != i && str2.length() != 0) {
                        indices = new ArrayList<>();
                        indices.add(i);
                        indices.add(wordMap.get(reverseStr));
                        result.add(indices);
                    }
                }
            }
            i++;
        }
        return result;
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i <= j) {
            if(str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static String reverseString(String str) {
        StringBuilder strRev = new StringBuilder(str);
        return strRev.reverse().toString();
    }
}
