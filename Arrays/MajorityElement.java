package Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,1,1,2,2,3,3,4,5,3,3,1,1,3,3,1,1,1,1};
		System.out.println(majorityElement(nums));
	}

	//Moore's voting algorithm.
	public static int majorityElement(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int count = 0;
		for(int num : nums) {
			if(count == 0) {
				result = num;
			}
			if(result == num) {
				count ++;
			}
			else {
				count--;
			}
		}
		return result;
	}
}

//Bit Manipulation, works in the same way as Single Number II problem.
/*
 * public int majorityElement(int[] num) {

    int ret = 0;

    for (int i = 0; i < 32; i++) {

        int ones = 0, zeros = 0;

        for (int j = 0; j < num.length; j++) {
            if ((num[j] & (1 << i)) != 0) {
                ++ones;
            }
            else
                ++zeros;
        }

        if (ones > zeros)
            ret |= (1 << i);
    }

    return ret;
}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */