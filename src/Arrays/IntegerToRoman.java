package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an integer, convert it to a Roman numeral.

Input is guaranteed to be within the range from 1 to 3999.


Symbol			Value
 I				1
 V				5
 X				10
 L				50
 C				100
 D				500
 M				1000
 * 
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        String s = "MCMXCVI";
        System.out.println("Integer equivalent of " + s + " is := " +  romanToInt(s));
    }

    public static int romanToInt(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        Map<Character, Integer> roman = new HashMap<>();
        s = s.toUpperCase();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int sum = 0;
        char prev = s.charAt(length - 1);
        char c;
        int value = 0;
        for(int i = length - 1; i >= 0; --i) {
            c = s.charAt(i);
            value = roman.get(c);
            if(value >= roman.get(prev)) {
                sum += value;
            } else {
                sum = Math.abs(sum - value);
            }
            prev = c;
        }
        return sum;

    }
}
