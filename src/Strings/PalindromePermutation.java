package Strings;

public class PalindromePermutation {

    public static void main(String[] args) {
        String s = "careracd";
        System.out.println("Does a palindorme permutation of '" + s + "' exist?= " + canPermutePalindrome(s));
    }

    public static boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        int[] arr = new int[256];

        for(char c : s.toCharArray()) {
            arr[c]++;
        }

        int odd = 0;
        for(int i : arr) {
            if(i % 2 != 0) {
                odd++;
            } 
        }
        return odd <= 1;
    }
}
