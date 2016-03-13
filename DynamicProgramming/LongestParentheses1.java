package DynamicProgramming;
import java.util.Stack;

public class LongestParentheses1 {
	public static void main(String[] args)
	{
		String s = "((()))))()";
		int size = longestValidParentheses(s);
		System.out.println("The longest valid parentheses size is :" + size);
	}

	public static int longestValidParentheses(String s)
	{
		if(s.length() == 0 || s == null)
			return 0;

		int length = s.length();
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		stack.push(-1);

		for(int i = 0; i < length; i++)
		{
			if(s.charAt(i) == '(')
				stack.push(i);

			else
			{
				stack.pop();
				if(!stack.isEmpty())
				{
					result = Math.max(result, i - stack.peek());
				}
				else
				{
					stack.push(i);
				}
			}
		}
		return result;
	}
}