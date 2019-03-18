package Strings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder1 {

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
        System.out.println("Minimum length of transformations is := " + ladderLengthBetter(beginWord, endWord, wordList));
    }

	//solves the problem, but canShip lead to TLE.
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }

        wordList.add(endWord);
        List<Integer> lengths = new ArrayList<Integer>();
        getLength(beginWord, endWord, wordList, 0, lengths);

        int min = Integer.MAX_VALUE;
        for(int length : lengths) {
            min = Math.min(min, length);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void getLength(String beginWord, String endWord, Set<String> wordList, int length, List<Integer> lengths) {
        if(getEditDistance(beginWord, endWord) == 1) {
            lengths.add((length + 1));
            return;
        }

        Set<String> cur = new HashSet<>();
        for(String s : wordList) {
            if(s != beginWord && getEditDistance(beginWord, s) == 1) {
                cur = new HashSet<>(wordList);
                cur.remove(s);
                getLength(s, endWord, cur, length + 1, lengths);
            }
        }
        return;
    }

    public static int getEditDistance(String s, String t) {
        int length = s.length();
        int[][] dp = new int[length][length];
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 0 : 1;

        for(int i = 1; i < length; ++i) {
            if(s.charAt(0) == t.charAt(i)) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = 1 + dp[0][i - 1];
            }

            if(s.charAt(i) == t.charAt(0)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 1 + dp[i - 1][0];
            }
        }

        for(int i = 1; i < length; ++i) {
            for(int j = 1; j < length; ++j) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[length - 1][length - 1];
    }

    public static int ladderLengthBetter(String beginWord, String endWord, Set<String> wordList) {
        Deque<String> wordQ = new ArrayDeque<String>();
        Deque<Integer> lengthQ = new ArrayDeque<Integer>();
        wordQ.offerLast(beginWord);
        lengthQ.offerLast(1);
        wordList.remove(beginWord);

        while(wordQ.peekFirst() != null){
            String currentWord = wordQ.pollFirst();
            int len = lengthQ.pollFirst();
            if(currentWord.equals(endWord)) {
                return len;
            }

            for(int i = 0; i < currentWord.length(); ++i) {
                char[] charArray = currentWord.toCharArray();
                for(int j = 0; j < 26; ++j) {
                    charArray[i] = (char)('a' + j);
                    String tmp = String.valueOf(charArray);
                    if(wordList.contains(tmp)){
                        wordList.remove(tmp);
                        wordQ.offerLast(tmp);
                        lengthQ.offerLast(len + 1);
                    }
                }
            }
        }
        return 0;
    }
}
