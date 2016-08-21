package Strings;

/*
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
 * 
 * 
 */
public class ReverseStringWordByWord {

    public static void main(String[] args) {
        String s = "the sky is the limit";
        System.out.println(reverseWordByWord(s));
    }

    public static String reverseWordByWord(String s)
    {
        if( s.length() == 0 || s == "")
            return "";
        String[] sets = s.trim().split("\\s+");
        StringBuilder reverse = new StringBuilder();
        for(int i = sets.length - 1; i >= 0; --i)
        {
            reverse.append(sets[i]);
            if(i!=0)
                reverse.append(" ");
        }
        return reverse.toString();
    }
}
