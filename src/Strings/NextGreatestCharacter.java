package Strings;

/**
 * @author sandeepa
 */

public class NextGreatestCharacter {

	public static void main(String[] args) {
		char[] letters = {'c', 'f', 'j'};
		char target = 'f';
		System.out.println("The next greatest character is := " + new NextGreatestCharacter().nextGreatestLetter(letters, target));
	}

	//O(n) solution
	public char nextGreatestLetter(char[] letters, char target) {
		char minChar = target;
		int min = 26;
		int val = 0;
		int curMin = 0;
		int targetVal = target - 'a' + 1;

		for(char c : letters) {
			if(target != c) {
				val = c - 'a' + 1;
				curMin = ((val - targetVal) % 26);
				if(curMin < 0) {
					curMin += 26;
				}

				if(min > curMin) {
					min = curMin;
					minChar = c;
				}
			}
		}

		return minChar;
	}

	//O(logn)
	public char nextGreatestLetterBetter(char[] letters, char target) {
		int n = letters.length;
		int l = 0, r = n - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (letters[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l == n ? letters[0] : letters[l];
	}

	//Even better
	public char nextGreatestLetterBest(char[] a, char x) {
		int n = a.length;

		if (x >= a[n - 1])   {
			x = a[0];
		} else {
			x++;
		}

		int lo = 0, hi = n - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == x) {
				return a[mid];
			} else if (a[mid] < x) {
				lo = mid + 1;
			} else    hi = mid;
		}
		return a[hi];
	}
}
