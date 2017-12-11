package Arrays;

/**
 * @author sandeepa
 */

public class ValidUtf8 {

	public static void main(String[] args) {
		int[] data = {235, 140, 4};
		System.out.println("Is the data a valid UTF-8 encoding ? := " + new ValidUtf8().validUtf8(data));
	}

	public boolean validUtf8(int[] data) {
		int length = data.length, count = 0, next = 0;

		for(int i = 0; i < length; ++i) {
			if((data[i] & (1 << 7)) == 128) {
				count = 1;
				next = 64;
				for(int j = 6; j >= 4; --j) {
					if((data[i] & (1 << j)) == next) {
						count++;
						next >>= 1;
					}
				}

				if(count == 1 || ((data[i] & (1 << (7 - count))) == (1 << 7 - count)) || !validUtf8(i + 1, count - 1, data)) {
					return false;
				}

				i += count - 1;
			}
		}

		return true;
	}

	public boolean validUtf8(int cur, int count, int[] data) {
		boolean found = false;
		while(count-- > 0 && cur < data.length) {
			found = true;
			if((data[cur] & (1 << 7)) != 128 || (data[cur] & (1 << 6)) == 64) {
				return false;
			}
			cur++;
		}

		return found;
	}
}
