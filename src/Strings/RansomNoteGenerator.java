package Strings;

public class RansomNoteGenerator {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println("Can construct ransom? " + canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.length() == 0 || magazine == null || magazine.length() == 0) {
            return false;
        }

        int rLength = ransomNote.length();
        int mLength = magazine.length();
        int[] charArray = new int[26];

        for(int i = 0; i < mLength; ++i) {
            charArray[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < rLength; ++i) {
            if(--charArray[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
