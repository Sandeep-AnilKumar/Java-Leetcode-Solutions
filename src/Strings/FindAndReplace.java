package Strings;

public class FindAndReplace {

    public static void main(String[] args) {
        String s = "This film is the best film of the filmy year";
        String toReplace = "film";
        String replaceWith = "movie";
        System.out.println("String is := " + s);
        System.out.println("Word to be replaced is := '" + toReplace + "' with := '" + replaceWith + "'");
        String result = replaceString(s, toReplace, replaceWith);
        System.out.println("The replaced string is := " + result);
    }

    public static String replaceString(String s, String toReplace, String replaceWith) {
        if(s == null || toReplace == null || replaceWith == null ||
                s.length() == 0 || toReplace.length() == 0 || replaceWith.length() == 0) {
            return s;
        }

        char[] sChars = s.toCharArray();
        int length = sChars.length;
        char startChar = toReplace.charAt(0);
        char[] replaceWithChars = replaceWith.toCharArray();

        StringBuilder sb = new StringBuilder();
        int replaceLength = toReplace.length();

        for(int i = 0; i < length; ++i) {
            if(sChars[i] == startChar && checkIsWord(sChars, toReplace, i + 1)) {
                for(char r : replaceWithChars) {
                    sb.append(r);
                }
                i += replaceLength - 1;
            } else {
                sb.append(sChars[i]);
            }
        }
        return sb.toString();
    }

    public static boolean checkIsWord(char[] sChars, String toReplace, int index) {
        if(index >= sChars.length) {
            return false; 
        }

        char[] replace = toReplace.toCharArray();

        for(int i = index, j = 1; i < sChars.length && j < replace.length; ++i, ++j) {
            if(sChars[i] != replace[j]) {
                return false;
            }
        }
        return true;
    }
}