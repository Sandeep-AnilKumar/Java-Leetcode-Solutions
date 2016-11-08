package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 */
public class PhoneLetterCombinations {

    public static void main(String[] args) {
        String digits = "7263337";
        List<String> combo = letterCombinations(digits);
        System.out.println("Total combo:" + combo.size());
        System.out.println("The letter combinations are:\n");
        for(String s : combo)
            System.out.println(s);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        String[] table = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i = 0; i < digits.length(); i++){
            result = combine(result, table[digits.charAt(i) - '0']);
        }
        return result;
    }

    private static List<String> combine(List<String> input, String temp){
        List<String> result = new LinkedList<>();
        for(int i = 0; i < temp.length(); i++){
            if(input.isEmpty()){
                result.add(temp.substring(i, i + 1));
            }else{
                for(String s: input){
                    result.add(s + temp.substring(i, i + 1));
                }
            }
        }
        return result;
    }

    //Other solution.
    public static List<String> letterCombinationsNew(String digits) {
        if(digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }

        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        List<String> curList = new ArrayList<>();
        int temp = 0;
        int size = 0;
        String combo = "";
        String newCombo = "";
        for(char c : digits.toCharArray()) {
            temp = c - '0';
            if(temp >= 2) {
                if(result.isEmpty()) {
                    for(char p : phone[temp].toCharArray()) {
                        result.add(p + "");
                    }
                } else {
                    size = result.size();
                    curList = new ArrayList<>();
                    for(int index = 0; index < size; ++index) {
                        combo = result.get(index);
                        for(char p : phone[temp].toCharArray()) {
                            newCombo = combo + p;
                            curList.add(newCombo);
                        }
                    }
                    result = new ArrayList<>(curList);
                }
            } else {
                return new ArrayList<>();
            }
        }
        return result;
    }
}
