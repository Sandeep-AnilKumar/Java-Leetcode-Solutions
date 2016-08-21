package Strings;


public class BoyerMoore {

    public static void main(String[] args) {
        String haystack = "barb bard barber";
        String needle = "barber";

        boyerMoore(haystack, needle);
    }

    public static int boyerMoore(String haystack , String needle)
    {
        if(haystack == null || haystack.length() == 0 && ( needle == null || needle.length() == 0))
            return 0;

        if(haystack == null && needle != null)
            return -1;

        int h = haystack.length();
        int n = needle.length();

        int shift[] = new int[256];
        for(int i = 0; i < 256; i++)
            shift[i] = -1;

        for(int i = 0; i < n; i++)
            shift[needle.charAt(i)] = i;

        int skip;
        for(int i = 0; i <= h - n; i+=skip)
        {
            skip = 0;
            for(int j = n-1; j >= 0 ; j--)
            {
                if(haystack.charAt(i + j) != needle.charAt(j))
                {
                    skip = Math.max(1 , j - shift[haystack.charAt(i+j)]);
                    break;
                }
            }

            if(skip == 0)
                return i;
        }
        return -1;
    }
}
