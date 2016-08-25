package Strings;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World                    f                                    ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int count = 0;

        for(int i = 0; i < length;) {
            count = 0;
            while(i < length && s.charAt(i) != ' ') {
                count++;
                i++;
            }
            while(i < length && s.charAt(i) == ' ') {
                i++;
            }
        }
        return count;
    }
}