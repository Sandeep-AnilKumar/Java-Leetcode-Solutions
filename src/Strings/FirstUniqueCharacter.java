package Strings;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println("The first non- repeating character is at := " + firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] arr = new int[256];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }
        int index = 0;
        for(char c : s.toCharArray()) {
            if(arr[c] == 1) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
