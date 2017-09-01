package Strings;

public class JudgeRouteCircle {

	public static void main(String[] args) {
		String moves = "LURDDRUL";
		System.out.println("Will the robot come back to starting position? := " + new JudgeRouteCircle().judgeCircle(moves));
	}

	public boolean judgeCircle(String moves) {
		if(moves == null || moves.length() == 0) {
			return true;
		}

		int i = 0;
		int j = 0;

		for(char c: moves.toCharArray()) {
			if(c == 'L') --j;
			else if(c == 'R') ++j;
			else if(c == 'U') --i;
			else ++i;
		}
		return i == 0 && j == 0;
	}
}
