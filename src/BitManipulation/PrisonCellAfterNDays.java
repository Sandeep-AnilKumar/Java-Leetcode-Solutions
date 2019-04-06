package BitManipulation;

public class PrisonCellAfterNDays {
	public static void main(String[] args) {
		PrisonCellAfterNDays prisonCellAfterNDays = new PrisonCellAfterNDays();
		int state = 10;
		System.out.println(prisonCellAfterNDays.nextDay(state));
	}

	public int nextDay(int state) {
		int ans = 0;
		for (int i = 1; i <= 3; ++i) {
			if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
				ans ^= 1 << i;
			}
		}

		return ans;
	}
}
