package Arrays;

public class HammingWeight {

	public static void main(String[] args) {
		int num = 7;
		System.out.println(hammingWeight(num));

	}

	public static int hammingWeight(int n) {
		String bin = Integer.toBinaryString(n);
		int length = bin.length();
		int count = 0;
		for(int i = 0; i < length; ++i) {
			if(bin.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
}

//This way we will have to iterate all the 32 bits. A better approach would be : -
/*
 * int count = 0;
 * while (n != 0) {
 * 	n &= n-1;
 * count++;
 * }
 * return count;
 * 
 *n & n-1 clears the LSB.
 * 
 * */

//An equally better approach would be : -

/*
 * public static int hammingWeight(int n) {
		int ones = 0;
		while(n!=0) {
			ones = ones + (n & 1);
			n >>>= 1;
		}
		return ones;
	}
 * 
 * Integer type in Java is signed and there is no unsigned int. 
 * So the input 2147483648 is represented in Java as 
 * -2147483648 (in java int type has a cyclic representation, 
 * that means Integer.MAX_VALUE+1==Integer.MIN_VALUE).
 * 
 * */

//And the fastest approach is: -
/*
 * int ret;
    ret = (num & 0x55555555)
        + ((num >> 1) & 0x55555555);
    ret = (ret & 0x33333333)
        + ((ret >> 2) & 0x33333333);
    ret = (ret & 0x0F0F0F0F)
        + ((ret >> 4) & 0x0F0F0F0F);
    ret = (ret & 0x00FF00FF)
        + ((ret >> 8) & 0x00FF00FF);
    ret = (ret & 0x0000FFFF)
        + ((ret >> 16) & 0x0000FFFF);
    return ret;
 * 
 * */