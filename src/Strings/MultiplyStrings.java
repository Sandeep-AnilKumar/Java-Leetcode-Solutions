package Strings;

import java.math.BigInteger;

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers canShip be arbitrarily large and are non-negative.
 * 
 * 
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String n1 = "123456789";
        String n2 = "987654321";
        System.out.println("The multiplication of 2 strings is:" + multiply(n1,n2));
    }

    public static String multiply(String num1, String num2)
    {	
        num1 = num1.trim().replaceAll(" +", "");
        num2 = num2.trim().replaceAll(" +", "");
        if(num1.length() == 0 || num2.length() == 0)
            return null;
        if(num1.equals("0") || num2.equals("0"))
        {
            return "0";
        }
        else
        {
            BigInteger b = new BigInteger(num1);
            String n1 = b.toString(2);
            b = new BigInteger(num2);
            String n2 = b.toString(2);
            int i = n1.length() - 1;
            int j = n2.length() - 1;
            int k = i + j + 1;
            StringBuilder result = new StringBuilder(k);
            StringBuilder temp = new StringBuilder(k);
            while(j>=0)
            {
                if(n2.charAt(j) == '1')
                {
                    temp = add(temp,n1);
                    //temp.append('0');
                }
                else
                {
                    temp.insert(0, '0');	
                }
                n1 = n1.concat("0");
                j--;
            }
            b = new BigInteger(temp.toString(),2);
            return String.valueOf(b);
        }
    }

    public static StringBuilder add(StringBuilder temp, String s1)
    {	
        StringBuilder result = new StringBuilder();
        String s3 = temp.toString();
        int i = s3.length();
        int j = s1.length();
        int max = Math.max(i, j);
        int sum = 0;
        int carry = 0;

        for(int k = 0; k < max; k++ )
        {
            int m = getBit(s1, j - k - 1);
            int n = getBit(s3, i - k - 1);
            sum = carry + m + n;
            result.append(sum % 2);
            carry = sum / 2;
        }
        if(carry == 1)
            result.append("1");

        return result.reverse(); 
    }

    public static int getBit(String s, int len)
    {
        if(len < 0 || len >= s.length())
            return 0;

        if(s.charAt(len) == '0')
            return 0;
        else
            return 1;
    }
}
