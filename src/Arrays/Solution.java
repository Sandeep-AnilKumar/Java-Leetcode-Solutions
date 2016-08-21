package Arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	    static String[] buildSubsets(String s) {
	        ArrayList i = new ArrayList<>();
	        for(int j = 0; j<s.length();j++)
	        {
	        	i.add(s.charAt(j));
	        }
	        for(int j = 0;j<s.length();j++)
	        {
	        	for(int k = j+1;k<s.length();k++)
	        	{
	        		i.add(s.substring(j,k));
	        	}
	        }
	        return (String[]) i.toArray();
	    }
	    
	    public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        final String fileName = System.getenv("OUTPUT_PATH");
	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	        String[] res;
	        String _s;
	        try {
	            _s = in.nextLine();
	        } catch (Exception e) {
	            _s = null;
	        }
	        
	        res = buildSubsets(_s);
	        for(int res_i=0; res_i < res.length; res_i++) {
	            bw.write(String.valueOf(res[res_i]));
	            bw.newLine();
	        }
	        
	        bw.close();
	    }
	}
