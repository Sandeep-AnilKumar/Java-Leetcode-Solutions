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
    } //The above solution might lead to TLE sometimes. A more beautiful detailed solution is below.

    public static String shortestPalindrome1(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);

        //get the maximum palin part in s starts from 0
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public static int[] getTable(String s){
        //get lookup table
        int[] table = new int[s.length()];

        //pointer that points to matched char in prefix part

        int index = 0;
        //skip index 0, we will not match a string with itself
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
				//we canShip extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index ++;
            }else{
                //match failed, we try to match a shorter substring

                //by assigning index to table[i-1], we will shorten the match string length, and jump to the 
                //prefix part that we used to match postfix ended at i - 1
                index = table[i-1];

                while(index > 0 && s.charAt(index) != s.charAt(i)){
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index-1];
                }

                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if(s.charAt(index) == s.charAt(i)){
                    //if match, then extend one char 
                    index ++ ;
                }
                table[i] = index;
            }
        }
        return table;
    }

    //Another way of using KMP.


    public static String shortestPalindrome2(String s) {
        if(s.length()<=1) return s;
        String rev_s = new StringBuilder(s).reverse().toString();
        String new_s = s + "#" + rev_s;
        int[] res = new int[new_s.length()];
        int pos = 1;
        int cnd = 0;
        res[0] = 0;
        while(pos < new_s.length()) {
            if(new_s.charAt(pos) == new_s.charAt(cnd)) {
                res[pos++] = ++cnd;
            }
            else if (cnd > 0) {
                cnd = res[cnd - 1];
            }
            else {
                res[pos] = 0;
                pos++;
            }
        }
        return rev_s.substring(0, s.length() - res[new_s.length() - 1]) + s;
    }
}
