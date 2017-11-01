package Strings;

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
        String digits = "53382633";
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
}
