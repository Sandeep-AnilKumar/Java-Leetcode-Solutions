package Strings;

public class IsOneEditDistance {

    public static void main(String[] args) {
        String s = "abc";
        String t = "abcd";
        System.out.println("Is '" + s + "' and '" + t + "' one edit distance apart? := " + isOneEditDistance(s, t));
    }

    public static boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length() - t.length()) >= 2) {
            return false;
        }

        int sLength = s.length();
        int tLength = t.length();
        int i = 0, j = 0, error = 0;
        while(i < sLength && j < tLength) {
            if(s.charAt(i) != t.charAt(j)) {
                error++;
                if(error > 1) {
                    return false;
                }

                if(sLength > tLength) {
                    j--;
                } else if(sLength < tLength){
                    i--;
                }

            }
            i++;
            j++;
        }
        return error == 1 || (error == 0 && sLength != tLength) ? true : false;
    }
}
