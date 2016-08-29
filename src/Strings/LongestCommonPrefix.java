package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"bank","banks","banker","banked","baked"};
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
}
