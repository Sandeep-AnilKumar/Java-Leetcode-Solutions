package Strings;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");
        wordDict.add("aaaaaaaaaaa");
        System.out.println("Does contain word break? := " + wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        if(wordDict.contains(s)) {
            return true;
        }

        Set<Integer> set = new HashSet<>();
        return wordBreak(s, 0, wordDict, set);
    }

    public static boolean wordBreak(String s, int index, Set<String> wordDict, Set<Integer> set) {
        if(index == s.length()) {
            return true;
        }
        if(set.contains(index)) {
            return false;
        }

        int length = s.length();
        for(int i = index + 1; i <= length; ++i) {
            if(wordDict.contains(s.substring(index, i)) && wordBreak(s, i, wordDict, set)) {
                return true;
            }
        }
        set.add(index);
        return false;
    }

    //Other DP Solution.
    /**
     * 
     * public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null && wordDict == null)
            return true;
        if (s == null || wordDict == null)
            return false;
        //dp[i] represents if s.substring(0, i+1) is wordbreakable.
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >=0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
     * */
}
