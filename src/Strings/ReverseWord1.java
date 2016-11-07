package Strings;

public class ReverseWord1 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println("The reversed string is := " + reverseWords(s));
    }

    public static String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        s = s.trim();
        String[] parts = s.split("\\s+");
        int length = parts.length;
        int start = 0;
        int end = length - 1;
        String temp = "";
        while(start < end) {
            temp = parts[start];
            parts[start++] = parts[end];
            parts[end--] = temp;
        }
        for(int index = 0; index < length; ++index) {
            temp = parts[index];
            reverseString(temp.toCharArray(), 0, temp.length() - 1);
        }
        String result = "";
        for(String p : parts) {
            result = result + " " + p;
        }
        return result.trim();
    }

    public static void reverseString(char[] c, int start, int end) {
        char temp;
        while(start < end) {
            temp = c[start];
            c[start++] = c[end];
            c[end--] = temp;
        }
        return;
    }
}
