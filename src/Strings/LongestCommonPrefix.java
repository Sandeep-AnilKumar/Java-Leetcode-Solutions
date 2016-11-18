package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"acc", "a"};
        System.out.println("Longest common prefix among the strings is : " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return null;
        }
        char c;
        int length = strs[0].length();
        StringBuilder lcp = new StringBuilder();
        for(int i = 0; i < length; ++i) {
            c = strs[0].charAt(i);
            for(String s : strs) {
                if(s.length() < i+1 || c != s.charAt(i)) {
                    return lcp.toString();
                }
            }
            lcp.append(c);
        }
        return lcp.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        int length = strs.length;
        int firstLength = strs[0].length();
        String temp = strs[0];
        int i = 1;
        while(firstLength-- > 0) {
            i = 1;
            for(; i < length; ++i) {
                if(strs[i].indexOf(temp) != 0) {
                    temp = temp.substring(0, temp.length() - 1);
                    break;
                }
            }
            if(i == length) {
                return temp;
            }
        }
        return "";
    }
}
