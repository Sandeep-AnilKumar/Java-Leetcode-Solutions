package Arrays;

public class ReverseAnInteger {

    public static void main(String[] args) {
        int num = 1234567891;
        System.out.println("Reverse of the integer : " + num + " is := " + reverseIntegerUsingArray(num));
    }

    public static int reverseInteger(int num) {
        int result = 0;
        int temp = num;
        int mod = 0;
        while(temp > 0) {
            mod = temp % 10;
            temp /= 10;
            result = result * 10 + mod; 
        }
        return result;
    }

    //What if the number is very large?
    public static int reverseIntegerUsingArray(int num) {
        if(num == 0) {
            return 0;
        }
        int result = 0;
        int temp = num;
        int digits = 1;
        while((temp /= 10) != 0) {
            ++digits;
        }
        int[] arr = new int[digits];
        temp = num;
        int i = 1;
        while(temp != 0) {
            arr[digits - i++] = temp % 10;
            temp /= 10;
        }

        reverseArray(arr, 0, digits - 1);
        temp = 0;
        for(int index = 0; index < digits; ++index) {
            temp = temp * 10 + arr[index];
        }
        result = temp;
        return result;
    }

    public static void reverseArray(int[] arr, int start, int end) {
        int temp = 0;
        while(start < end) {
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }  

    //checks for overflow and minus sign.
    public static int reverse(int x) {
        String integerChars = String.valueOf(x);
        String temp = "";

        Long xLong = (long) x;

        char integerSign = integerChars.charAt(0);
        if(integerSign == '-' || xLong == Integer.MIN_VALUE) {
            temp = "-";
            xLong = -xLong;
        }

        long number = xLong;
        long remainder = 0;
        long reverse = 0;
        boolean overflowCheck = false;
        while(number != 0) {
            remainder = number % 10;
            number = number / 10;
            if((reverse * 10 + remainder) > Integer.MAX_VALUE) {
                overflowCheck = true;
            }
            reverse = reverse * 10 + remainder;
        }

        if(!temp.isEmpty() && !overflowCheck) {
            integerChars =  String.valueOf(reverse);
            temp = temp.concat(integerChars);
            reverse = Integer.parseInt(temp);
        }

        else if(overflowCheck)
            reverse = 0;

        return (int) reverse;
    }
}
