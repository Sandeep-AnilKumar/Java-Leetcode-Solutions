package Strings;

public class ShortestPalindrome {
    static String result = "";

    public static void main(String[] args) {
        String s = "aabba";
        System.out.println("The shortest palindrome after addition is: " + shortestPalindrome(s));
    }

    public static String shortestPalindrome(String s) {
        if(s == null || s .length() <= 1) {
            return s;
        }
        StringBuilder mod = new StringBuilder();
        result = getLongestPalindromicSubstring(s);
        System.out.println("The longest palindromic substring is: " + result);
        int length = s.length();
        int i = result.length();
        for (; i < length; ++i) {
            mod.insert(0, s.charAt(i));
        }
        return mod + s;
    }

    public static String getLongestPalindromicSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int length = s.length() >> 1;
        for(int i = 0; i <= length; ++i) {
            max = isPalindrome(s, i, i, max);
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

        if(i == -1 && j - i - 1 > curMax) {
            curMax = j - i - 1;
            result = s.substring(i+1, j);
        }
        return curMax;
    }
}
