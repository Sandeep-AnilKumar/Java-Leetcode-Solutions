package Strings;
/*
 * 
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5

 * 
 * 
 */

public class BasicCalculator2 {
    public static void main(String[] args) {
        String s = "3+5 / 2";
        System.out.println("The value of the expression is : " + basicCalculator2(s));
    }

    public static int basicCalculator2(String s)
    {
        s = s.trim();
        if(s.length() == 0)
            return 0;

        int result = 0, i=0, preval = 0, curval = 0;
        char sign = '+';

        while(i<s.length())
        {
            curval = 0;
            while(i<s.length() && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48)
            {
                curval = curval * 10 + (s.charAt(i) - '0');
                i++;
            }
            if(sign == '+')
            {
                result += preval;
                preval = curval;
            }
            else if(sign == '-')
            {
                result += preval;
                preval = -curval;
            }
            else if(sign == '*')
            {
                preval *= curval;
            }
            else if(sign == '/')
            {
                preval /= curval;
            }
            if(i<s.length())
            {
                sign = s.charAt(i);
                i++;
            }
        }
        result += preval;
        return result;
    }
}
