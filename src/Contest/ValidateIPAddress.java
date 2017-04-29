package Contest;

import java.util.HashSet;
import java.util.Set;

public class ValidateIPAddress {

	public static void main(String[] args) {
		String IP = "172.16.254.1";
		System.out.println(validIPAddress(IP));
	}
	public static String validIPAddress(String IP) {
		String neither = "Neither";
		String ip4 = "IPv4";
		String ip6 = "IPv6";
		if(IP == null || IP.length() == 0 || IP.length() > 39 || (IP.indexOf(".") != -1 && (IP.indexOf(":") != -1)) || (IP.indexOf(".") == -1 && IP.indexOf(":") == -1)) {
			return neither;
		}

		if(IP.charAt(0)==':') return "Neither";
		if(IP.charAt(IP.length()-1)==':') return "Neither";
		if(IP.charAt(0)=='.') return "Neither";
		if(IP.charAt(IP.length()-1)=='.') return "Neither";

		String parts[] = null;
		if(IP.indexOf(".") != -1) {
			parts = IP.split("\\.");
			if(parts.length != 4) {
				return neither;
			} else {
				for(String p : parts) {
					if(!isIPv4(p)) {
						return neither;
					}
				}
				return ip4;
			}
		} else if(IP.indexOf(":") != -1) {
			parts = IP.split("\\:");
			if(parts.length != 8) {
				return neither;
			} else {
				for(String p : parts) {
					if(!isIPv6(p)) {
						return neither;
					}
				}
				return ip6;
			}
		} else {
			return neither;
		}
	}

	public static boolean isIPv4(String ip) {
		if(ip == null || ip.length() == 0) {
			return false;
		}

		char[] posChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		Set<Character> set = new HashSet<>();
		for(char c : posChars) {
			set.add(c);
		}

		for(char c : ip.toCharArray()) {
			if(!set.contains(c)) {
				return false;
			}
		}

		int val = Integer.valueOf(ip);
		if(val >= 0 && val <= 255) {
			if(ip.length() > 3 || (ip.length() != 1 && (val >= 0 && val <= 9)) || (ip.length() != 2 && (val >= 10 && val <= 99))) {
				return false;
			}
		} else {
			return false;
		}
		return true;	
	}

	public static boolean isIPv6(String ip) {
		if(ip == null || ip.length() == 0 || ip.length() > 4) {
			return false;
		}

		ip = ip.toUpperCase();
		char[] posChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

		Set<Character> set = new HashSet<>();
		for(char c : posChars) {
			set.add(c);
		}

		for(char c : ip.toCharArray()) {
			if(!set.contains(c)) {
				return false;
			}
		}
		return true;
	}
}