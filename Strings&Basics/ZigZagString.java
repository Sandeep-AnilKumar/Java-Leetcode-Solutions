package String;

public class ZigZagString {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int rows = 3;
		System.out.println(doZigZag(s,rows));
	}

	public static String doZigZag(String s, int rows)
	{
		String result = "";
		if(!(s == null || s.length() == 0 || s == ""))
		{
			int length = s.length();

			if(length > rows && rows == 1)
				return s;

			String[] zigzagString = new String[rows];
			boolean direction = false;

			for(int i = 0, rowCount = 0; i < length && rowCount < rows && rowCount >= 0; i++)
			{
				if(zigzagString[rowCount] == null)
					zigzagString[rowCount] = "";

				zigzagString[rowCount] += s.charAt(i);
				if(rowCount == 0)
				{
					rowCount++;
					direction = false;
				}

				else if(rowCount == rows - 1)
				{
					rowCount--;
					direction = true;
				}

				else if(!direction)
				{
					rowCount++;
				}
				else
				{
					rowCount--;
				}
			}

			for(int i = 0; i < rows; i++)
			{
				if(zigzagString[i] != null)
					result += zigzagString[i];
			}
		}
		return result;
	}
}
