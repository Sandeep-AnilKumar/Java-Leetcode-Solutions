package Arrays;

public class Test {

	public static void main(String[] args) {
		String pattern = "John went to barber's arbor";
		String text = "arbor";
		System.out.println(needleInHaystack(pattern,text));
	}

	public static int needleInHaystack(String haystack, String needle)
	{
		if(haystack == null || haystack.length() == 0 && (needle == null || needle.length() == 0))
			return 0;

		if(haystack == null && needle != null)
			return -1;

		int h = haystack.length();
		int n = needle.length();
		int i = 0;

		for(i = 0; i < h; i++)
		{
			int j = 0;
			while(j < n && needle.charAt(j) == haystack.charAt(i+j))
			{
				j++;
			}
			
			if(j == n)
				break;
		}
		return i;
	}
}