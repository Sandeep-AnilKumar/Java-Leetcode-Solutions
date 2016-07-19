package Arrays;

/*
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
 * 
 * 
 */


import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		String s = "6+(12+(21+2-2+4)+21)-21";
		System.out.println(basicCalci(s));
	}

	public static int basicCalci(String s)
	{
		s.trim();
		Stack<Integer> st = new Stack<Integer>();
		int res = 0, val = 0; 
		int sign = 1;

		for(int i = 0; i <= s.length()-1; i++)
		{
			if(s.charAt(i) == '(')
				st.push(sign);
			else if(s.charAt(i) == ')')
				sign = st.pop();
			else if(s.charAt(i) == '+' || s.charAt(i) == '-')
			{
				res += sign*val;
				val = 0;
				if(!st.isEmpty())
					sign = s.charAt(i) == '-' ? st.peek()*(-1) : st.peek();
					else
						sign = s.charAt(i) == '-' ? -1 : 1;
			}
			else if (s.charAt(i)!=' ')
			{
				val = val * 10 + (s.charAt(i) - '0');
			}
		}
		res += val * sign;
		return res;
	}
}
