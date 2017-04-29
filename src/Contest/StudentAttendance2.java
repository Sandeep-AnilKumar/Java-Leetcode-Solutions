package Contest;

import java.util.LinkedList;
import java.util.List;

public class StudentAttendance2 {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(checkRecord(n));
	}
	
	//Will work, but will take a lot of time for greater numbers.
	public static int checkRecord(int n) {
		n -= 1;
		char[] posChars = {'A','L','P'};
		List<String> rewardable = new LinkedList<>();
		rewardable.add("A");
		rewardable.add("L");
		rewardable.add("P");
		int total = rewardable.size();
		String record = "";

		while(n-- > 0) {
			List<String> temp = new LinkedList<>();
			for(String s : rewardable) {
				for(char c : posChars) {
					record = s + "" + c;
					if(checkRecord(record)) {
						temp.add(record);
					}
				}
			}
			rewardable = new LinkedList<>(temp);
			total = rewardable.size();
		}
		return (int) Math.round(total % (Math.pow(10, 9) + 7));
	}

	public static boolean checkRecord(String s) {
		if(s == null || s.length() == 0) {
			return true;
		}

		int aCount = 0;
		int lCount = 0;

		for(char c : s.toCharArray()) {
			if(c == 'A') {
				if(aCount < 1) {
					aCount++;
					lCount = 0;
				} else {
					return false;
				}
			} else if(c == 'L') {
				if(lCount < 2) {
					lCount++;
				} else {
					return false;
				}
			} else {
				lCount = 0;
			}
		}
		return true;
	}
}
