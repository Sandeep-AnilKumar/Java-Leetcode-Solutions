package Arrays;

import java.util.Arrays;

public class BulbSwitcher {

	public static void main(String[] args) {
		BulbSwitcher switcher = new BulbSwitcher();
		int n = 6;
		System.out.println("The number of bulbs switched on are := " + switcher.bulbSwitch(n));
	}

	//Will cause Time Limit Exceeded for large numbers.
	public int bulbSwitch(int n) {
		int[] status = new int[n + 1];
		Arrays.fill(status, 1);

		int j = 0;
		for(int i = 2; i <= n; ++i) {
			j = i;
			while(j <= n) {
				status[j] ^= 1;
				j +=i;
			}
		}

		int count = 0;
		for(int i = 1; i <= n; ++i) {
			if(status[i] == 1) count++;
		}
		return count;
	}

	//This will also cause TLE.
	//	public int bulbSwitchBetter(int n) {
	//		//		int bulbs = 1;
	//		//		int cur = 1;
	//		//		for(int i = 1; i <= n; ++i) {
	//		//			bulbs |= cur;
	//		//			cur <<= 1;
	//		//		}
	//
	//		int bulbs = (int) (Math.pow(2, n) - 1);
	//		int j = 0;
	//		int total = bulbs;
	//		for(int i = 2; i <= total; i = i * 2) {
	//			j = i;
	//			while(j <= total) {
	//				bulbs ^= j;
	//				j <<= i;
	//			}
	//		}
	//
	//		int count = 0;
	//		while(bulbs > 0) {
	//			count += bulbs & 1;
	//			bulbs >>= 1;
	//		}
	//		return count;
	//	}
}
