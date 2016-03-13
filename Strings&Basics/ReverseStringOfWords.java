
public class ReverseStringOfWords {

	public static void main(String[] args) {
		String s = "              Have a great day                  ";
		s = s.trim();
		s = reverseWords(s);
		System.out.println(s);
	}

	public static String reverseWords(String s) {
		if(s.length() == 0 || s == null || s == " ")
			return s;

		int i = 0;
		int j = 0;
		while(j < s.length())
		{
			if(s.charAt(j) == ' ')
			{
				s = reverse(i, j-1 ,s);
				i = ++j;
			}
			else
			{
				j++;
			}
		}
		
		s = reverse(i, j-1 ,s);
		return reverse(0, s.length() - 1, s);
	}

	public static String reverse(int i, int j, String s)
	{
		char str[] = s.toCharArray();
		while(i < j)
		{
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			i++;
			j--;
		}
		s = new String(str);
		return s;
	}

}
