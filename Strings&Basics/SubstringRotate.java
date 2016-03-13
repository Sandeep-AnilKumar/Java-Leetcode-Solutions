
public class SubstringRotate {

	public static void main(String[] args) {
		String s  = "waterbottle";
		String sub = "ttlewaterbo";
		System.out.println(isSubstring(s,sub));

	}

	public static boolean isSubstring(String s, String sub)
	{
		if(s == null || sub == null || s.length() == 0 || sub.length() == 0)
			return false;

		if(s.length() != sub.length())
			return false;

		int len = s.length();
		String temp = sub;
		int i = 0;

		for(i = 0; i < len; i++)
		{
			if(!s.contains(temp))
			{
				int tempLength = temp.length();
				temp = temp.substring(0, tempLength - 1);
			}
			else
			{
				break;
			}
		}
		int index = i - 1;
		for(int j = 0; j < i; j++)
		{
			if(!(s.charAt(j) == sub.charAt(len - 1 - index + j)))
				return false;
		}
		return true;
	}
}
