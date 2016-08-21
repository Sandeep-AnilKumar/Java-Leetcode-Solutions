package Strings;

/*
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * 
 */
public class IntegerToEnglish {

    public static void main(String[] args) {
        int num = 1242565435;
        System.out.println("English: - " + integerToEnglish(num));
    }

    public static String integerToEnglish(int num)
    {
        String s = String.valueOf(num);
        s = s.trim().replaceAll("//s+","").replaceFirst("^0*", "");
        if(s.length() == 0 || s.equals("") || s.equals("0"))
            return "Zero";

        int n = s.length();
        StringBuilder chunk = new StringBuilder(15);
        int leads = 0;

        for(int i = 0; i <= n/3 && leads < n; i++)
        {	
            StringBuilder res = new StringBuilder(15);
            String temp = "";
            if(n-leads-3 < 0)
            {
                temp = s.substring(0, n-leads);
            }
            else
            {
                temp = s.substring(n-leads-3,n-leads);
            }
            res = getEnglishHelper(res,temp,i);
            chunk.insert(0, res);
            leads += 3;
        }
        int size = chunk.length();
        chunk.deleteCharAt(size - 1);
        return chunk.toString();
    }

    public static StringBuilder getEnglishHelper(StringBuilder result, String temp, int i)
    {
        int j = 0;
        int sum = 0;
        int n = temp.length();
        while(j <= n - 1)
        {
            int value = temp.charAt(j) - '0';
            sum += value;
            switch(value)
            {
                case 1 : if(j == 0 && n == 1) result.append("One ");
                else if( j == 0 && n == 2 ) {result = getTens(result, temp.charAt(j+1) - '0'); j++;}
                else if(j == 1 && n > 2) {result = getTens(result, temp.charAt(j+1) - '0'); j++;}
                else if(j == 0 && n == 3) result.append("One Hundred ");
                else result.append("One ");
                break;
                case 2 : if(j == 0 && n == 1) result.append("Two ");
                else if(j == 0 && n == 2) result.append("Twenty ");
                else if(j == 0 && n == 3) result.append("Two Hundred ");
                else if(j==1 && n > 2) result.append("Twenty ");
                else result.append("Two ");
                break;
                case 3 : if(j == 0 && n == 1) result.append("Three ");
                else if(j == 0 && n == 2) result.append("Thirty ");
                else if(j == 0 && n == 3) result.append("Three Hundred ");
                else if(j==1 && n > 2) result.append("Thirty ");
                else result.append("Three ");
                break;
                case 4 : if(j == 0 && n == 1) result.append("Four ");
                else if(j == 0 && n == 2) result.append("Forty ");
                else if(j == 0 && n == 3) result.append("Four Hundred ");
                else if(j==1 && n > 2) result.append("Forty ");
                else result.append("Four ");
                break;
                case 5 : if(j == 0 && n == 1) result.append("Five ");
                else if(j == 0 && n == 2) result.append("Fifty ");
                else if(j == 0 && n == 3) result.append("Five Hundred ");
                else if(j==1 && n > 2) result.append("Fifty ");
                else result.append("Five ");
                break;
                case 6 : if(j == 0 && n == 1) result.append("Six ");
                else if(j == 0 && n == 2) result.append("Sixty ");
                else if(j == 0 && n == 3) result.append("Six Hundred ");
                else if(j==1 && n > 2) result.append("Sixty ");
                else result.append("Six ");
                break;
                case 7 : if(j == 0 && n == 1) result.append("Seven ");
                else if(j == 0 && n == 2) result.append("Seventy ");
                else if(j == 0 && n == 3) result.append("Seven Hundred ");
                else if(j==1 && n > 2) result.append("Seventy ");
                else result.append("Seven ");
                break;
                case 8 : if(j == 0 && n == 1) result.append("Eight ");
                else if(j == 0 && n == 2) result.append("Eighty ");
                else if(j == 0 && n == 3) result.append("Eight Hundred ");
                else if(j==1 && n > 2) result.append("Eighty ");
                else result.append("Eight ");
                break;
                case 9 : if(j == 0 && n == 1) result.append("Nine ");
                else if(j == 0 && n == 2) result.append("Ninety ");
                else if(j == 0 && n == 3) result.append("Nine Hundred ");
                else if(j==1 && n > 2) result.append("Ninety ");
                else result.append("Nine ");
                break;
            }
            j++;
        }
        if(i == 1 && sum != 0)
            result.append("Thousand ");
        else if(i == 2 && sum != 0)
            result.append("Million ");
        else if(i == 3 && sum != 0)
            result.append("Billion ");

        return result;
    }

    public static StringBuilder getTens(StringBuilder result, int preval)
    {
        switch(preval)
        {
            case 1: result.append("Eleven ");
            break;
            case 2: result.append("Twelve ");
            break;
            case 3: result.append("Thirteen ");
            break;
            case 4: result.append("Fourteen ");
            break;
            case 5: result.append("Fifteen ");
            break;
            case 6: result.append("Sixteen ");
            break;
            case 7: result.append("Seventeen ");
            break;
            case 8: result.append("Eighteen ");
            break;
            case 9: result.append("Nineteen ");
            break;
            default: result.append("Ten ");
        }
        return result;
    }
}
