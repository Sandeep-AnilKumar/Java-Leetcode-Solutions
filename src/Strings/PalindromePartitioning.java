package Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "ratata";
        List<List<String>> result = partition(s);
        for(List<String> r : result) {
            System.out.print("[");
            for(String s1 : r) {
                System.out.print(s1+" ");
            }
            System.out.println("]");
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        search(list, new ArrayList<>(), s, 0);
        return list;
    }

    public static void search(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    search(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    } 

    //other solution

    public static List<List<String>> partition1(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length()==0) {
            res.add(new ArrayList<String>());
            return res;
        }
        if(s.length()==1) {
            List<String> subLs = new ArrayList<String>();
            subLs.add(s);
            res.add(subLs);
            return res;
        }
        for(int i=0; i<s.length(); i++) {
            String subS = s.substring(0,i+1);
            if(isPalindrome(subS, 0, subS.length() - 1)) {
                List<List<String>> subRes = partition1(s.substring(i+1));
                for(List<String> l : subRes) {
                    l.add(0,subS);
                    res.add(l);
                }
            }
        }
        return res;
    }
}
