package Strings;

public class LargestProductPalindrome {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(largestPalindrome(n));
    }

    //Brute force, does not work for all cases and causes TLE.
    public static int largestPalindrome(int n) {
        if(n <= 0) {
            return 0;
        }

        StringBuffer sb = new StringBuffer();
        int temp = n;
        while(temp-- > 0) {
            sb.append('9');
        }

        int num1 = Integer.parseInt(sb.toString());
        int num2 = num1;
        int prod = 0;
        int max = Integer.MIN_VALUE;

        while(num1 > 0) {
            num2 = num1;
            while(num2 > 0) {
                prod = num1*num2;
                if(ifIsPalindrome(prod)) {
                    break;
                }
                num2--;
            }
            max = Integer.max(prod, max);
            num1--;
        }
        max %= 1337;
        return max;
    }

    public static boolean ifIsPalindrome(int prod) {
        if(prod <= 0) {
            return false;
        }

        char[] p = String.valueOf(prod).toCharArray();

        int i = 0;
        int j = p.length - 1;

        while(i <= j) {
            if(p[i++] != p[j--]) {
                return false;
            }
        }
        return true;
    }
}
