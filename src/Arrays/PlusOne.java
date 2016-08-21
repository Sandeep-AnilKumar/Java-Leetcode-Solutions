package Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] nums = new int[]{9,9};
		int[] newNums = plusOne(nums);
		System.out.println("The new array after adding one is ");
		for(int i : newNums)
		{
			System.out.println(i);
		}

	}

	public static int[] plusOne(int[] digits) {
		int length = digits.length;
		int[] newDigits = new int[digits.length+1];
		if(length == 1 && digits[0] > 8)
		{
			newDigits[0] = 1;
			newDigits[1] = 0;
			return newDigits;
		}
		int i = length - 1;
		int carry = 0;

		if(digits[i] > 8)
		{
			digits[i] = 0;
			carry = 1;
		}
		else
			digits[i] = digits[i] + 1;

		i--;

		while(i >= 1)
		{
			if(carry == 1)
			{
				if(digits[i] > 8)
				{
					digits[i] = 0;
					carry = 1;
				}
				else
				{
					digits[i] = digits[i] + 1;
					carry = 0;
				}
			}		
			i--;
		}

		if(carry == 1 && digits[i] > 8)
		{
			newDigits[0] = 1;
			newDigits[1] = 0;
		}
		else if(carry == 1)
		{
			newDigits = digits;
			newDigits[0] = newDigits[0] + 1;
		}

		else
		{
			newDigits = digits;
		}

		return newDigits;
	}
}
