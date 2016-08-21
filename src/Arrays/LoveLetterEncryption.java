package Arrays;

public class LoveLetterEncryption {

	public static void main(String[] args) {
		String letter = "acbefbd";
		palindromeEncryption(letter);
	}
	
	public static int palindromeEncryption(String letter)
	{
		if(letter == null || letter.length() == 0)
			return 0;
		
		int length = letter.length();
		int j = length - 1;
		int i = 0;
		int count = 0;
		while(i < j)
		{
			int difference = Math.abs(letter.charAt(i) - letter.charAt(j));
			count += difference;
			i++;
			j--;
		}
		return count;
	}

}
