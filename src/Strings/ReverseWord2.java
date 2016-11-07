package Strings;

public class ReverseWord2 {

    public static void main(String[] args) {
        String str = "the sky is blue";
        char[] s = str.toCharArray();
        System.out.println("Reversed string is := ");
        reverseWords(s);
        for(char c : s) {
            System.out.print(c);
        }
    }

    public static char[] reverseWords(char[] s) {
        if(s == null || s.length == 0) {
            return s;
        }

        int length = s.length;
        reverseChar(s, 0, length - 1);
        int j = 0;
        for(int index = 0; index < length; ++index) {
            j = index;
            while(j < length && s[j] != ' ') {
                j++;
            }
            reverseChar(s, index, j - 1);
            index = j;
        }
        String k = s.toString();
        k = k.trim();
        String[] parts = k.split("\\s+");
        String result = parts.toString();

        return s;
    }

    public static void reverseChar(char[] s, int start, int end) {
        char temp;
        while(start < end) {
            temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
        return;
    }
}
