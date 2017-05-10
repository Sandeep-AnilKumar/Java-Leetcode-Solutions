package Arrays;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public static void main(String[] args) {
		int num = 3;
		List<String> binaryWatch = readBinaryWatch(num);
		System.out.println("The possible values for the watch are := " + binaryWatch);
		System.out.println("The total possible values are := " + binaryWatch.size());
	}

	public static List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>();
		if(num <= 0) {
			result.add("0:00");
			return result;
		}

		int hStart = 0;
		int hEnd = 11;
		int mStart = 0;
		int mEnd = 59;

		for(int h = hStart; h <= hEnd; ++h) {
			for(int m = mStart; m <= mEnd; ++m) {
				if(nDigits(h) + nDigits(m) == num) {
					if(m < 10) {
						result.add(h + ":0" + m);
					} else {
						result.add(h + ":" + m);
					}
				}
			}
		}
		return result;
	}

	public static int nDigits(int val) {
		int count = 0;
		while(val > 0) {
			count = val % 2 == 0 ? count : count + 1;
			val /= 2;
		}
		return count;
	}
}
