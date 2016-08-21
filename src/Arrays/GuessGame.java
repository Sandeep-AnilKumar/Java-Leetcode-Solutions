package Arrays;

public class GuessGame {

	int guess(int num) {
		return 0;
	}
	
	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		int result = 0;
		int mid = 0;
		while(low <= high) {
			mid = low + (high - low)/2;
			result = guess(mid);
			if(result == 0) {
				return mid;
			}
			else if(result == -1) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return low;
	}
}
