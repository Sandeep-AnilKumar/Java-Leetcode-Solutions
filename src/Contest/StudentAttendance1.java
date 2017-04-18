package Contest;

public class StudentAttendance1 {

	public static void main(String[] args) {
		String s = "LALL";
		System.out.println(checkRecord(s));
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
