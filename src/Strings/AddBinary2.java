package Strings;
/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * 
 * 
 */

public class AddBinary2 {

	public static void main(String[] args) {
		String s = "11";
		String t = "1";
		String res = addBinary(s,t);
		System.out.println(res);
	}

	public static String addBinary(String s, String t)
	{
		return Long.toBinaryString(Long.parseLong(s,2) + Long.parseLong(t,2));
	}
	
}
