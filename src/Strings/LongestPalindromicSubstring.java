package Strings;

public class LongestPalindromicSubstring {
    static String result = "";
    public static void main(String[] args) {
        String s = "ncabbacfdeg";
        System.out.println("Longest Palindromic Substring is: " + getLongestPalindromicSubstring(s));
    }

    public static String getLongestPalindromicSubstring(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int max = Integer.MIN_VALUE;
        int length = s.length();
        for(int i = 0; i < length; ++i) {
            max = isPalindrome(s,i,i,max);
            max = isPalindrome(s, i, i+1, max);
        }
        return result;
    }

    public static int isPalindrome(String s, int i, int j, int curMax) {
        while(i >= 0 && i < s.length() && j < s.length() && j >= 0) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }

        if(j - i - 1 > curMax) {
            curMax = j - i - 1;
            result = s.substring(i+1, j);
        }
        return curMax;
    }
}
