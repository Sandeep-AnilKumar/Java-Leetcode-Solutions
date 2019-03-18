package Strings;

/*Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lower case English letters.
Input is guaranteed to be valid and canShip be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.*/

public class ReconstructDigits {

    public static void main(String[] args) {
        String s = "owoztneoer";
        System.out.println(originalDigits(s));
    }

    public static String originalDigits(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        int length = s.length();
        int[] count = new int[26];
        for(int i = 0; i < length; ++i) {
            count[s.charAt(i) - 'a']++;
        }

        int[] nums = new int[10];
        nums[0] = count['z' - 'a'];
        nums[2] = count['w' - 'a'];
        nums[4] = count['u' - 'a'];
        nums[6] = count['x' - 'a'];
        nums[8] = count['g' - 'a'];
        nums[1] = count['o' - 'a'] - nums[2] - nums[4] - nums[0];
        nums[3] = count['h' - 'a'] - nums[8];
        nums[5] = count['f' - 'a'] - nums[4];
        nums[7] = count['s' - 'a'] - nums[6];
        nums[9] = count['i' - 'a'] - nums[5] - nums[6] - nums[8];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; ++i) {
            for(int j = nums[i]; j >0; j--) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
