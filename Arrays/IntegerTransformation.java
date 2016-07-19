package Arrays;

public class IntegerTransformation {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		int c = 0;
		int d = 4;
		System.out.println(canTransform(a,b,c,d));
	}

	public static boolean canTransform(int a, int b, int c, int d)
	{
		/*if(c < a || d < b)
			return false;

		int temp1C = a;
		int temp1D = a+b;

		boolean state1 = canTransform(a,b,temp1C,temp1D);

		int temp2C = a+b;
		int temp2D = b;

		boolean state2 = canTransform(a,b,temp2C,temp2D);

		if(state1 || state2)
			return true;

		return false;*/

		while(c > a || d > b)
		{
			if(c == 0 || d == 0)
			{
				if(a == c && b == d)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else if(c > d)
			{
				c = c - d;
			}
			else
			{
				d = d - c; 
			}

		}
		if(c == a && d == b)
			return true;
		return false;
	}
}