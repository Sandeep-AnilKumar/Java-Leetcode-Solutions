package Arrays;

public class PowerOfFour {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(1));
	}

	public static boolean isPowerOfFour(int num) {
		if(num <= 0 || ((num & (num-1)) != 0)) return false;
		
		int check = Integer.MAX_VALUE;
		int xor = num ^ check;
		String bin = Integer.toBinaryString(xor);
		int index = bin.indexOf('0');

		int length = bin.length();
		int count = 0;
		for(int i = index + 1; i < length; ++i) {
			if(bin.charAt(i) != '1') {
				return false;
			}
			else {
				count++;
			}
		}
		if(count % 2 == 0) {
			return true;
		}
		return false;
	}
}


/* Better solution.
 * public boolean isPowerOfFour(int num) {
        if(num <= 0 || (num & (num-1)) != 0) {
            return false;
        }
        int temp = num;
        int count = 0;
        
        while(temp > 0) {
            if((temp & 1) == 0) {
                count++;
            }
            else {
                break;
            }
            temp >>= 1;
        }
        return (count % 2 == 0);
    }
 * */
