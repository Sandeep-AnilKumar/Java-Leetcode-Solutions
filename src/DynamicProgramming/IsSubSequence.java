package DynamicProgramming;

public class IsSubSequence {

    public static void main(String[] args) {
        String s = "ahbgdc";
        String t = "abc";
        System.out.println("Is T present in S : " + isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) {
            return false;
        }
        return isSubSequence(s, t, 0, 0);
    }

    public static boolean isSubSequence(String s, String t, int sIndex, int tIndex) {
        if(sIndex > s.length() - 1) {
            return false;
        }
        boolean present = false;
        while(sIndex <= s.length() - 1) {
            if(s.charAt(sIndex) == t.charAt(tIndex)) {
                if(tIndex == t.length() - 1) {
                    return true;
                }
                present = isSubSequence(s, t, sIndex + 1, tIndex + 1);
                break;
            } else {
                sIndex++;
            }
        }
        return present;
    }
}
