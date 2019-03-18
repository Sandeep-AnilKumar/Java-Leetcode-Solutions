package Strings;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of different letters that can be formed are "3" (A,B,L).
 * 
 * 
 */
public class DifferentLettersInDecoding {

    public static void main(String[] args) {
        String s = "12";
        System.out.println("Number of decodings:" + numDecodings(s));
    }

    public static int numDecodings(String s)
    {
        int count = 0;
        s = s.trim().replaceFirst("^0*","").replaceAll("\\s+", "");
        count = helper(s,s.length()-1,0,0);
        return count;
    }

    public static int helper(String s, int i, int k, int count)
    {	
        if(!(i > s.length() || i < 0))
        {
            int l = 0;
            int j = 0;
            StringBuilder r = new StringBuilder(0);
            if (i >= 0)
            {
                j = s.charAt(i) - '0';
                l = k * 10 + j;
                l = Integer.parseInt(r.append(l).reverse().toString());
                if(l <= 26 && j!= 0)
                {
                    count++;
                }
                if(String.valueOf(l).length() == 1){
                    count = helper(s, i-1, l, count);
                }
                else
                {
                    count++;
                    count = helper(s, i-1, j, count);
                }
            }
        }
        return count;
    }
}
