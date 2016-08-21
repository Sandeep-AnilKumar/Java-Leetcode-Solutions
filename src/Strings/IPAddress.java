package Strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * 
 */
public class IPAddress {

    public static void main(String[] args) {
        String s = "1234453371";
        List<String> a = restoreIpAddresses(s);
        String ip = "";
        for(Iterator<String> i = a.iterator(); i.hasNext();)
        {
            ip = i.next();
            System.out.println(ip);
        }	
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s,"",res,0);
        return res;
    }
    public static void helper(String s, String tmp, List<String> res,int n){
        if(n==4){
            if(s.length()==0) res.add(tmp.substring(0,tmp.length()-1));
            //substring here to get rid of last '.'
            return;
        }
        for(int k=1;k<=3;k++){
            if(s.length()<k) continue;
            int val = Integer.parseInt(s.substring(0,k));
            if(val>255 || k!=String.valueOf(val).length()) continue;
            /*in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.*/
            helper(s.substring(k),tmp+s.substring(0,k)+".",res,n+1);
        }
    }

}
