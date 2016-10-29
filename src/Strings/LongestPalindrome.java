package Strings;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "bananas";
        System.out.println("Length of the longest palindrome is : " + longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int lowerStart = (int)'a';
        int lowerEnd = (int)'z';
        int upperStart = (int)'A';
        int upperEnd = (int)'Z';

        char[] str = s.toCharArray();
        int[] map = new int[52];
        int ascii = 0;
        for(char c : str) {
            ascii = (int)c;
            if(ascii >= lowerStart && ascii <= lowerEnd) {
                map[ascii - 'a']++;
            } else if(ascii >= upperStart && ascii <= upperEnd) {
                map[ascii - 'A' + 26]++;
            }
        }
        int total = 0;
        int oddHighest = Integer.MIN_VALUE;
        int prev = 0;
        int index = 0;
        for(int i = 0; i < 52; ++i) {
            if(map[i] % 2 == 1) {
                prev = oddHighest;
                oddHighest = Math.max(oddHighest, map[i]);
                if(prev != oddHighest) {
                    index = i;
                }
            } else {
                total += map[i];
            }
        }
        if(oddHighest != Integer.MIN_VALUE) {
            for(int i = 0; i < 52; ++i) {
                if(i != index && map[i] % 2 != 0) {
                    total += map[i] - 1;
                }
            }
        }
        return total + (oddHighest == Integer.MIN_VALUE ? 0 : oddHighest);
    }
}
