package Strings;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("12","24"));

    }

    public static boolean isIsomorphic(String s, String t) {
        char[] sMap = new char[256];
        char[] tMap = new char[256];
        int length = s.length();
        char curSChar, curTChar;

        for(int i = 0; i < length; ++i) {
            curSChar = s.charAt(i);
            curTChar = t.charAt(i);

            if(sMap[curSChar] == '\0' && tMap[curTChar] == '\0') {
                sMap[curSChar] = curTChar;
                tMap[curTChar] = curSChar;
            }
            else if(sMap[curSChar] != curTChar || tMap[curTChar] != curSChar) {
                return false;
            }
        }
        return true;
    }
}
